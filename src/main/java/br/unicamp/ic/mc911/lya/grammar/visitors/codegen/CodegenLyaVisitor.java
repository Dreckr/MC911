package br.unicamp.ic.mc911.lya.grammar.visitors.codegen;

import br.unicamp.ic.mc911.lya.grammar.LyaBaseVisitor;
import br.unicamp.ic.mc911.lya.grammar.LyaParser;
import br.unicamp.ic.mc911.lya.grammar.environment.*;
import br.unicamp.ic.mc911.lya.grammar.visitors.utils.LyaUtils;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

import static br.unicamp.ic.mc911.lya.grammar.visitors.utils.LyaUtils.throwError;

/**
 * @author Diego Rocha (diego.rocha@movile.com)
 */
public class CodegenLyaVisitor extends LyaBaseVisitor<Environment> {

    private final Environment environment;

    private final ExpressionCodegenVisitor expressionCodegenVisitor;
    private final ConstantExpressionExtractorVisitor constantExpressionExtractorVisitor;

    public CodegenLyaVisitor(Environment environment) {
        this.environment = environment;
        this.expressionCodegenVisitor = new ExpressionCodegenVisitor(environment);
        this.constantExpressionExtractorVisitor = new ConstantExpressionExtractorVisitor(environment);
    }

    @Override
    public Environment visitProgram(LyaParser.ProgramContext context) {
        environment.resetScopeIndex();

        addInst("stp");

        visitChildren(context);

        addInst("dlc", environment.getCurrentScope().getAndIncrementNextPosition(0));

        addInst("end");

        return environment;
    }

    public Environment visitExpression(LyaParser.ExpressionContext context) {
        expressionCodegenVisitor.visit(context);
        return environment;
    }

    @Override
    public Environment visitDeclaration_statement(LyaParser.Declaration_statementContext context) {
        Scope scope = environment.getCurrentScope();

        for (LyaParser.DeclarationContext declaration : context.declaration_list().declaration()) {
            List<Variable> declarationVariables = new ArrayList<Variable>();

            // Get type
            Type type = LyaUtils.typeFromModeContext(environment, declaration.modo());

            // Get size
            int size = LyaUtils.sizeFromMode(environment, declaration.modo());

            for (TerminalNode identifier : declaration.identifier_list().IDENTIFIER()) {
                Location location = environment.findLocation(identifier.getText());

                if (location == null) {
                    throwError("Undefined location " + identifier.getText(), context);
                }

                Symbol name = location.getName();

                Variable variable;
                if (type.isComposite()) {
                    List<Integer> indexesSizes =
                            LyaUtils.compositeIndexesSizes(environment, declaration.modo().composite_mode());

                    variable =
                            new Variable(name, type, size, scope.getIndex(), scope.getAndIncrementNextPosition(size), indexesSizes);
                } else {
                    variable =
                            new Variable(name, type, size, scope.getIndex(), scope.getAndIncrementNextPosition(size));
                }

                declarationVariables.add(variable);
                environment.addVariable(variable);
            }

            // Allocate space
            addInst("alc", size * declarationVariables.size());

            if (declaration.initialization() != null) {
                // Set value
                expressionCodegenVisitor.visit(declaration.initialization().expression());

                Variable first = declarationVariables.get(0);
                addInst("stv", first.getScope(), first.getDisplacement());

                if (declarationVariables.size() > 1) {
                    for (int i = 1; i < declarationVariables.size(); i++) {
                        addInst("ldv", first.getScope(), first.getDisplacement());
                    }

                    for (int i = 1; i < declarationVariables.size(); i++) {
                        addInst("stv", declarationVariables.get(i).getScope(), declarationVariables.get(i).getDisplacement());
                    }
                }
            }
        }

        return environment;
    }

    @Override
    public Environment visitSynonym_definition(LyaParser.Synonym_definitionContext context) {
        Object constant = constantExpressionExtractorVisitor.visit(context.constant_expression());
        Type constantType = LyaUtils.typeOfConstant(constant, context);

        for (TerminalNode identifier : context.identifier_list().IDENTIFIER()) {
            Location location = environment.findLocation(identifier.getText());

            if (location == null) {
                throwError("Undefined location " + identifier.getText(), context);
            }

            Symbol name = location.getName();

            environment.addConstant(name, new Constant(constantType, constant));
        }

        return environment;
    }

    @Override
    // TODO: handle composite types
    public Environment visitAssignment_action(LyaParser.Assignment_actionContext context) {
        LyaParser.LocationContext locationContext =  context.location();
        if (locationContext.array_element() != null) {
            LyaParser.Array_elementContext arrayElement = locationContext.array_element();
            // Load reference
            Variable variable = environment.findVariable(arrayElement.array_location().getText());
            addInst("ldr", variable.getScope(), variable.getDisplacement());

            // Load displacement
            int currentIndex = 0;
            for (LyaParser.ExpressionContext indexExpression : arrayElement.expression_list().expression()) {
                visit(indexExpression);
                addInst("ldc", 1);
                addInst("sub");

                int dimSize = 1;
                for (int i = currentIndex + 1; i < variable.getIndexesSizes().size(); i++) {
                    dimSize *= variable.getIndexesSizes().get(i);
                }

                addInst("idx", dimSize);

                currentIndex++;
            }

            expressionCodegenVisitor.visit(context.expression());

            addInst("smv", 1);

        } else if (locationContext.array_slice() != null) {
            throwError("unimplemented", context);
        } else if (locationContext.string_element() != null) {
            throwError("unimplemented", context);
        } else if (locationContext.string_slice() != null) {
            throwError("unimplemented", context);
        } else if (locationContext.location_name() != null) {
            Variable variable = environment.findVariable(locationContext.location_name().getText());

            if (context.assigning_operator().closed_dyadic_operator() != null) {
                addInst("ldv", variable.getScope(), variable.getDisplacement());

                expressionCodegenVisitor.visit(context.expression());

                switch (context.assigning_operator().closed_dyadic_operator().getText().charAt(0)) {
                    case '+':
                        addInst("add");
                        break;
                    case '-':
                        addInst("sub");
                        break;
                    case '*':
                        addInst("mul");
                        break;
                    case '/':
                        addInst("div");
                        break;
                    case '%':
                        addInst("mod");
                        break;
                    case '&':
                        // TODO
                        break;
                    default:
                        throwError("Illegal dyadic operator " + context.assigning_operator().closed_dyadic_operator().getText(), context);
                }
            } else {
                expressionCodegenVisitor.visit(context.expression());
            }

            addInst("stv", variable.getScope(), variable.getDisplacement());
        } else {
            throwError("what?", context);
        }

        return environment;
    }

    @Override
    public Environment visitBuiltin_call(LyaParser.Builtin_callContext context) {
        String builtinName = context.builtin_name().getText();

        if (builtinName.equals("read")) {
            for (LyaParser.ParameterContext parameterContext : context.parameter_list().parameter()) {
                String variableName = parameterContext.getText();

                Symbol symbol = environment.findSymbol(variableName);

                if (symbol == null) {
                    throwError("Undefined symbol " + variableName, context);
                }

                Variable variable = environment.findVariable(symbol);
                if (variable == null) {
                    throwError("Undefined variable " + variableName, context);
                }

                if (variable.getType() != PrimitiveType.STRING) {
                    addInst("rdv");
                } else {
                    addInst("rds");
                }

                addInst("stv", variable.getScope(), variable.getDisplacement());
            }

        } else if (builtinName.equals("print")) {
            for (LyaParser.ParameterContext parameterContext : context.parameter_list().parameter()) {
                Object constant = null;
                try {
                    constant = constantExpressionExtractorVisitor.visit(parameterContext.expression());
                } catch(Exception ignored) {}

                if (constant != null && constant instanceof StringConstant) {
                    addInst("prc", ((StringConstant) constant).getIndex());
                } else {
                    Type type = expressionCodegenVisitor.visit(parameterContext.expression());

                    if (type == PrimitiveType.STRING) {
                        addInst("prs");
                    } else {
                        addInst("prv");
                    }
                }
            }
        }

        return environment;
    }

    @Override
    public Environment visitIf_action(LyaParser.If_actionContext context) {
        Integer afterIfLabelIndex = environment.nextLabelIndex();
        Integer afterElseLabelIndex = environment.nextLabelIndex();
        visit(context.boolean_expression());

        addInst("jof", afterIfLabelIndex);

        visit(context.then_clause());

        addInst("jmp", afterElseLabelIndex);

        addInst("lbl", afterIfLabelIndex);

        if (context.else_clause() != null) {
            visit(context.else_clause());
        }

        addInst("lbl", afterElseLabelIndex);

        return environment;
    }

    @Override
    public Environment visitElse_clause(LyaParser.Else_clauseContext context) {
        if (context.ELSE() != null) {
            for (LyaParser.Action_statementContext action : context.action_statement()) {
                visit(action);
            }
        } else {
            Integer afterElseIfLabelIndex = environment.nextLabelIndex();
            Integer afterElseLabelIndex = environment.nextLabelIndex();
            visit(context.boolean_expression());

            addInst("jof", afterElseIfLabelIndex);

            visit(context.then_clause());

            addInst("jmp", afterElseLabelIndex);

            addInst("lbl", afterElseIfLabelIndex);

            if (context.else_clause() != null) {
                visit(context.else_clause());
            }

            addInst("lbl", afterElseLabelIndex);

        }

        return environment;
    }

    @Override
    public Environment visitDo_action(LyaParser.Do_actionContext context) {
        if (context.control_part() == null) {
            for (LyaParser.Action_statementContext action : context.action_statement()) {
                visit(action);
            }
        } else if (context.control_part().for_control() == null) {
            Integer doLabelIndex = environment.nextLabelIndex();
            Integer afterDoLabelIndex = environment.nextLabelIndex();
            addInst("lbl", doLabelIndex);

            visit(context.control_part());
            addInst("jof", afterDoLabelIndex);

            for (LyaParser.Action_statementContext action : context.action_statement()) {
                visit(action);
            }

            addInst("jmp", doLabelIndex);

            addInst("lbl", afterDoLabelIndex);
        } else {
            LyaParser.For_controlContext forControl = context.control_part().for_control();

            if (forControl.iteration().step_enumeration() != null) {
                LyaParser.Step_enumerationContext stepEnumeration = forControl.iteration().step_enumeration();
                String loopCounterName = stepEnumeration.loop_counter().getText();
                Variable loopCounter = environment.findVariable(loopCounterName);

                visit(stepEnumeration.start_value());

                addInst("stv", loopCounter.getScope(), loopCounter.getDisplacement());

                Integer doLabelIndex = environment.nextLabelIndex();
                Integer afterDoLabelIndex = environment.nextLabelIndex();
                addInst("lbl", doLabelIndex);

                addInst("ldv", loopCounter.getScope(), loopCounter.getDisplacement());
                visit(stepEnumeration.end_value());

                addInst("leq");

                if (context.control_part().while_control() != null) {
                    visit(context.control_part().while_control().boolean_expression());
                    addInst("and");
                }

                addInst("jof", afterDoLabelIndex);

                for (LyaParser.Action_statementContext action : context.action_statement()) {
                    visit(action);
                }

                addInst("ldv", loopCounter.getScope(), loopCounter.getDisplacement());

                if (stepEnumeration.step_value() != null) {
                    visit(stepEnumeration.step_value());
                } else {
                    addInst("ldc", 1);
                }

                if (stepEnumeration.DOWN() != null) {
                    addInst("sub");
                } else {
                    addInst("add");
                }

                addInst("stv", loopCounter.getScope(), loopCounter.getDisplacement());

                addInst("jmp", doLabelIndex);

                addInst("lbl", afterDoLabelIndex);

            } // TODO: range mode
        }

        return environment;
    }

    @Override
    public Environment visitProcedure_statement(LyaParser.Procedure_statementContext context) {
        String procedureName = context.procedure_name().getText();
        Symbol procedureSymbol = environment.findSymbol(procedureName);
        Procedure procedure = environment.findProcedure(procedureSymbol);

        Integer procedureLabelIndex = environment.nextLabelIndex();
        Integer afterProcedureLabelIndex = environment.nextLabelIndex();

        Label procedureLabel = new Label(procedureLabelIndex, procedureSymbol);
        environment.addLable(procedureLabel);

        addInst("jmp", afterProcedureLabelIndex);
        addInst("lbl", procedureLabelIndex);
        addInst("enf", procedureLabelIndex);
        Scope scope = environment.enterScope();

        int parameterDisplacement = 0;
        List<LyaParser.Formal_parameterContext> formalParameters =
                context.procedure_definition().formal_parameter_list().formal_parameter();
        for (int i =  0; i < formalParameters.size(); i++) {
            LyaParser.Formal_parameterContext parameter = formalParameters.get(i);
            int size = LyaUtils.sizeFromMode(environment, parameter.parameter_spec().modo());

            List<TerminalNode> identifiers = parameter.identifier_list().IDENTIFIER();
            for (int j = 0; j < identifiers.size(); j++) {
                TerminalNode identifier = identifiers.get(j);
                Location parameterLocation = environment.findLocation(identifier.getText());
                Type type = parameterLocation.getType();
                Symbol name = parameterLocation.getName();

                Variable variable;
                if (type.isComposite()) {
                    List<Integer> indexesSizes =
                            LyaUtils.compositeIndexesSizes(environment, parameter.parameter_spec().modo().composite_mode());

                    variable =
                            new Variable(name, type, size, scope.getIndex(), -(2 + parameterDisplacement), indexesSizes);
                } else {
                    variable =
                            new Variable(name, type, size, scope.getIndex(), -(2 + parameterDisplacement));
                }

                environment.addVariable(variable);

                parameterDisplacement += size;
            }
        }
        scope.setReturnDisplacement(-(2 + parameterDisplacement));

        for (LyaParser.StatementContext statementContext : context.procedure_definition().statement()) {
            visit(statementContext);
        }

        environment.leaveScope();

        addInst("dlc", scope.getAndIncrementNextPosition(0));

        if (procedure.getReturnType() == VoidType.VOID) {
            addInst("ret", scope.getIndex(), parameterDisplacement + 1);
        } else {
            addInst("ret", scope.getIndex(), parameterDisplacement);
        }

        addInst("lbl", afterProcedureLabelIndex);

        return environment;
    }

    @Override
    public Environment visitProcedure_call(LyaParser.Procedure_callContext context) {
        Symbol procedureName = environment.findSymbol(context.procedure_name().getText());
        Label procedureLabel = environment.findLabel(procedureName);

        List<LyaParser.ParameterContext> parameters = context.parameter_list().parameter();
        for (int i = parameters.size() - 1; i >= 0; i--) {
            LyaParser.ParameterContext parameter = parameters.get(i);

            visit(parameter.expression());
        }

        addInst("cfu", procedureLabel.getIndex());

        return environment;
    }

    @Override
    public Environment visitReturn_action(LyaParser.Return_actionContext context) {
        Scope scope = environment.getCurrentScope();
        if (context.result() != null) {
            visit(context.result());
        }

        addInst("ret", scope.getIndex(), environment.getCurrentScope().getAndIncrementNextPosition(0));

        return environment;
    }

    @Override
    public Environment visitResult(LyaParser.ResultContext  context) {
        Scope scope = environment.getCurrentScope();

        visit(context.expression());

        addInst("stv", scope.getIndex(), scope.getReturnDisplacement());

        return environment;
    }

    private void addInst(String mnemonic) {
        addInst(mnemonic, null, null);
    }

    private void addInst(String mnemonic, Integer firstArg) {
        addInst(mnemonic, firstArg, null);
    }

    private void addInst(String mnemonic, Integer firstArg, Integer secondArg) {
        environment.addInstruction(new Instruction(mnemonic, firstArg, secondArg));
    }
}
