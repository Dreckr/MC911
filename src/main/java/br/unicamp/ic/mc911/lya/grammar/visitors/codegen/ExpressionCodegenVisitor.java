package br.unicamp.ic.mc911.lya.grammar.visitors.codegen;

import br.unicamp.ic.mc911.lya.grammar.LyaBaseVisitor;
import br.unicamp.ic.mc911.lya.grammar.LyaParser;
import br.unicamp.ic.mc911.lya.grammar.environment.*;
import br.unicamp.ic.mc911.lya.grammar.visitors.utils.LyaUtils;

import java.util.List;

import static br.unicamp.ic.mc911.lya.grammar.visitors.utils.LyaUtils.throwError;

/**
 * Created by Diego Rocha (diego.rocha@movile.com)
 */
public class ExpressionCodegenVisitor extends LyaBaseVisitor<Type> {

    private final Environment environment;

    public ExpressionCodegenVisitor(Environment environment) {
        this.environment = environment;
    }

    @Override
    public Type visitInteger_literal(LyaParser.Integer_literalContext context) {
        int constant = Integer.parseInt(context.getText());

        addInst("ldc", constant);

        return PrimitiveType.INT;
    }

    @Override
    public Type visitBoolean_literal(LyaParser.Boolean_literalContext context) {
        int constant = Boolean.parseBoolean(context.getText()) ? 1 : 0;

        addInst("ldc", constant);

        return PrimitiveType.BOOL;
    }

    @Override
    public Type visitCharacter_literal(LyaParser.Character_literalContext context) {
        int constant = context.getText().charAt(1);

        addInst("ldc", constant);

        return PrimitiveType.CHAR;
    }

    @Override
    public Type visitEmpty_literal(LyaParser.Empty_literalContext context) {
        addInst("ldc", 0);

        return NullType.NULL;
    }

    @Override
    public Type visitCharacter_string_literal(LyaParser.Character_string_literalContext context) {
        String text = context.getText();
        text = text.substring(1, text.length() - 2);

        StringConstant constant = environment.addStringConstant(text);

        addInst("ldc", constant.getIndex());

        return PrimitiveType.STRING;
    }

    // Operations
    // Visit operand0
    // Visit operand1
    // Visit operand2
    // Visit operand3
    @Override
    public Type visitOperand0(LyaParser.Operand0Context context) {
        Type type = visitChildren(context);

        if (context.operator1() != null) {

            if (context.operator1().relational_operator() != null) {
                type = PrimitiveType.BOOL;
                BinaryOperator binaryOperator = BinaryOperator.findOperatorByToken(context.operator1().getText());

                if (binaryOperator == null) {
                    throwError("Illegal binary operator " + context.operator1().getText(), context);
                }

                switch (binaryOperator) {
                    case AND:
                        addInst("and");
                        break;
                    case OR:
                        addInst("lor");
                        break;
                    case EQ:
                        addInst("equ");
                        break;
                    case DIFF:
                        addInst("neq");
                        break;
                    case GT:
                        addInst("grt");
                        break;
                    case GTE:
                        addInst("gre");
                        break;
                    case LT:
                        addInst("les");
                        break;
                    case LTE:
                        addInst("leq");
                        break;
                    default:
                        throwError("Unsupported binary operator " + binaryOperator.name(), context);
                }
            }
        }

        return type;
    }

    @Override
    public Type visitOperand1(LyaParser.Operand1Context context) {
        Type type = visitChildren(context);

        if (context.operator2() != null) {
            if (context.operator2().arithmetic_additive_operator() != null) {
                type = PrimitiveType.INT;
                BinaryOperator binaryOperator = BinaryOperator.findOperatorByToken(context.operator2().getText());

                if (binaryOperator == null) {
                    throwError("Illegal operator: " + context.operator2().getText(), context);
                }

                switch (binaryOperator) {
                    case PLUS:
                        addInst("add");
                        break;
                    case MINUS:
                        addInst("sub");
                        break;
                    default:
                        throwError("Unsupported binary operator " + binaryOperator.name(), context);
                }

            }
        }

        return type;
    }

    @Override
    public Type visitOperand2(LyaParser.Operand2Context context) {
        Type type = visitChildren(context);

        if (context.arithmetic_multiplicative_operator() != null) {
            type = PrimitiveType.INT;
            BinaryOperator binaryOperator =
                    BinaryOperator.findOperatorByToken(context.arithmetic_multiplicative_operator().getText());

            if (binaryOperator == null) {
                throwError("Illegal operator: " + context.arithmetic_multiplicative_operator().getText(), context);
            }

            switch (binaryOperator) {
                case MULT:
                    addInst("mul");
                    break;
                case MOD:
                    addInst("mod");
                    break;
                case DIV:
                    addInst("div");
                    break;
                default:
                    throwError("Unsupported binary operator " + binaryOperator.name(), context);
            }
        }

        return type;
    }

    @Override
    public Type visitOperand3(LyaParser.Operand3Context context) {
        Type type = visitChildren(context);

        if (context.monadic_operator() != null) {

            UnaryOperator unaryOperator =
                    UnaryOperator.findOperatorByToken(context.monadic_operator().getText());

            if (unaryOperator == null) {
                throwError("Illegal operator: " + context.monadic_operator().getText(), context);
            }

            switch (unaryOperator) {
                case NEGATION:
                    addInst("not");
                    type = PrimitiveType.BOOL;
                    break;
                case NEGATIVE:
                    addInst("neg");
                case POSITIVE:
                    type = PrimitiveType.INT;
                    break;
                default:
                    throwError("Unsupported unary operator " + unaryOperator.name(), context);
            }
        }

        return type;
    }

    @Override
    public Type visitParenthesized_expression(LyaParser.Parenthesized_expressionContext context) {
        return context.expression().accept(this);
    }

    // Locations
    // Visit referenced_location
    // Visit location_name
    @Override
    public Type visitReferenced_location(LyaParser.Referenced_locationContext context) {
        String locationName = context.location().getText();

        Symbol symbol = environment.findSymbol(locationName);
        if (symbol == null) {
            throwError(locationName + " is undefined", context);
        }

        if (symbol.getType() == SymbolType.Variable) {
            Variable variable = environment.findVariable(symbol);

            if (variable == null) {
                throwError("Undefined variable" + locationName, context);
            }

            addInst("ldr", variable.getScope(), variable.getDisplacement());

            return new ReferenceType(variable.getType());
        } else {
            throwError("Illegal expression operand " + locationName, context);
        }

        return null;
    }

    @Override
    public Type visitArray_element(LyaParser.Array_elementContext context) {
        Variable variable = environment.findVariable(context.array_location().getText());
        addInst("ldr", variable.getScope(), variable.getDisplacement());

        // Load displacement
        int currentIndex = 0;
        for (LyaParser.ExpressionContext indexExpression : context.expression_list().expression()) {
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

        addInst("grc");

        return variable.getType().getTypeParameter();
    }

    @Override
    public Type visitLocation_name(LyaParser.Location_nameContext context) {
        Type type = null;
        String locationName = context.getText();

        Symbol symbol = environment.findSymbol(locationName);
        if (symbol == null) {
            throwError(locationName + " is undefined", context);
        }

        if (symbol.getType() == SymbolType.Const) {
            Constant constant = environment.findConstant(symbol);

            if (constant == null) {
                throwError("Undefined constant " + locationName, context);
            }

            addInst("ldc", LyaUtils.constantValueToInstArg(constant, context));
            type = constant.getType();
        } else if (symbol.getType() == SymbolType.Variable) {
            Variable variable = environment.findVariable(symbol);

            if (variable == null) {
                throwError("Undefined variable " + locationName, context);
            }

            addInst("ldv", variable.getScope(), variable.getDisplacement());
            type = variable.getType();
        } else {
            throwError("Illegal expression operand " + locationName, context);
        }

        return type;
    }

    @Override
    public Type visitProcedure_call(LyaParser.Procedure_callContext context) {
        Symbol procedureName = environment.findSymbol(context.procedure_name().getText());
        Procedure procedure = environment.findProcedure(procedureName);
        Label procedureLabel = environment.findLabel(procedureName);

        List<LyaParser.ParameterContext> parameters = context.parameter_list().parameter();
        for (int i = parameters.size() - 1; i >= 0; i--) {
            LyaParser.ParameterContext parameter = parameters.get(i);

            visit(parameter.expression());
        }

        addInst("cfu", procedureLabel.getIndex());

        return procedure.getReturnType();
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
