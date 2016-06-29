package br.unicamp.ic.mc911.lya.grammar.visitors.semantic;

import br.unicamp.ic.mc911.lya.grammar.LyaBaseVisitor;
import br.unicamp.ic.mc911.lya.grammar.LyaParser;
import br.unicamp.ic.mc911.lya.grammar.environment.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import static br.unicamp.ic.mc911.lya.grammar.visitors.utils.LyaUtils.*;

/**
 * @author Diego Rocha (diego.rocha@movile.com)
 */
// This should fill the symbol table and check for undefined usages.
public class SemanticAnalysisVisitor extends LyaBaseVisitor<Environment> {

    private final Environment environment;
    private final ExpressionTypeExtractionVisitor typeExtractionVisitor;

    public SemanticAnalysisVisitor(Environment environment) {
        this.environment = environment;
        this.typeExtractionVisitor = new ExpressionTypeExtractionVisitor(environment);
    }

    // Create symbols
    // Visit declaration
    // Visit synonym_definition
    // Visit procedure_statement
    // Visit mode_definition
    // Visit loop_counter
    // Visit action_statement
    // Visit formal_parameter
    @Override
    public Environment visitDeclaration(LyaParser.DeclarationContext context) {
        Type declarationType = typeFromModeContext(environment, context.modo());

        for (TerminalNode tn : context.identifier_list().IDENTIFIER()) {
            Symbol declarationSymbol = new Symbol(SymbolType.Variable, tn.getText());
            environment.addSymbol(tn.getText(), declarationSymbol);
            environment.addLocation(new Location(declarationSymbol, declarationType));
        }

        if (context.initialization() != null) {
            Type expressionType = typeExtractionVisitor.visit(context.initialization().expression());

            if (!declarationType.equals(expressionType)) {
                throwError("Declarations should be initialize with expression of type " + declarationType.getName().getValue(), context);
            }
        }

        visitChildren(context);
        return environment;
    }

    @Override
    public Environment visitSynonym_definition(LyaParser.Synonym_definitionContext context) {
        Type type = typeExtractionVisitor.visit(context.constant_expression());

        if (context.modo() != null) {
            Type modeType = typeFromModeContext(environment, context.modo());

            if (!type.equals(modeType)) {
                throwError("Constant expression must be of type " + modeType, context);
            }
        }

        for (TerminalNode tn : context.identifier_list().IDENTIFIER()) {
            Symbol synonymSymbol = new Symbol(SymbolType.Const, tn.getText());
            environment.addSymbol(tn.getText(), synonymSymbol);
            environment.addLocation(new Location(synonymSymbol, type));
        }

        visitChildren(context);
        return environment;
    }

    @Override
    public Environment visitProcedure_statement(LyaParser.Procedure_statementContext context) {
        String procedureName = context.procedure_name().getText();
        Symbol procedureSymbol = new Symbol(SymbolType.Procedure, procedureName);
        Type returnType = VoidType.VOID;

        if (context.procedure_definition().result_spec() != null) {
            returnType = typeFromModeContext(environment, context.procedure_definition().result_spec().modo());
        }

        environment.addSymbol(procedureName, procedureSymbol);
        environment.addProcedure(new Procedure(new Symbol(SymbolType.Procedure, procedureName), returnType));

        visitChildren(context);
        return environment;
    }

    @Override
    public Environment visitMode_definition(LyaParser.Mode_definitionContext context) {
        Type type = typeFromModeContext(environment, context.modo());

        for (TerminalNode tn : context.identifier_list().IDENTIFIER()) {
            Symbol modeSymbol = new Symbol(SymbolType.Mode, tn.getText());
            environment.addSymbol(tn.getText(), modeSymbol);
            environment.addType(new TypeAlias(modeSymbol, type));
        }

        visitChildren(context);
        return environment;
    }

    @Override
    public Environment visitAction_statement(LyaParser.Action_statementContext context) {
        if (context.label_id() != null) {
            String actionLabel = context.label_id().getText();
            environment.addSymbol(actionLabel, new Symbol(SymbolType.Label, actionLabel));
        }

        visitChildren(context);
        return environment;
    }

    @Override
    public Environment visitFormal_parameter(LyaParser.Formal_parameterContext context) {
        Type type = typeFromModeContext(environment, context.parameter_spec().modo());

        for (TerminalNode tn : context.identifier_list().IDENTIFIER()) {
            Symbol parameterSymbol = new Symbol(SymbolType.Variable, tn.getText());
            environment.addSymbol(tn.getText(), parameterSymbol);
            environment.addLocation(new Location(parameterSymbol, type));
        }

        visitChildren(context);
        return environment;
    }

    // Enter Scope / Leave Scope
    // Visit procedure_definition
    // Visit do_action
    // Visit then_clause
    // Visit else_clause

    @Override
    public Environment visitProcedure_definition(LyaParser.Procedure_definitionContext context) {
        environment.enterScope();
        visitChildren(context);
        environment.leaveScope();

        return environment;
    }

    @Override
    public Environment visitDo_action(LyaParser.Do_actionContext context) {
        environment.enterScope();
        visitChildren(context);
        environment.leaveScope();

        return environment;
    }

    @Override
    public Environment visitThen_clause(LyaParser.Then_clauseContext context) {
        environment.enterScope();
        visitChildren(context);
        environment.leaveScope();

        return environment;
    }

    @Override
    public Environment visitElse_clause(LyaParser.Else_clauseContext context) {
        environment.enterScope();
        visitChildren(context);
        environment.leaveScope();

        return environment;
    }

    // Check symbols definition
    // Visit procedure_call
    // Visit location_name
    // Visit mode_name
    // Visit discrete_mode
    // Visit exit_action
    // Visit loop_counter
    @Override
    public Environment visitProcedure_call(LyaParser.Procedure_callContext context) {
        String procedureName = context.procedure_name().getText();

        Symbol procedureSymbol = environment.lookup(procedureName);

        if (procedureSymbol == null) {
            throwError("Undefined procedure " + procedureName + " called: " + context.getText(), context);
        } else if (procedureSymbol.getType() != SymbolType.Procedure) {
            throwError(procedureName + " is not a procedure", context);
        }

        visitChildren(context);
        return environment;
    }

    @Override
    public Environment visitLocation_name(LyaParser.Location_nameContext context) {
        String locationName = context.getText();

        Symbol locationSymbol = environment.lookup(locationName);

        if (locationSymbol == null) {
            throwError("Undefined variable " + locationName, context);
        } else if (locationSymbol.getType() != SymbolType.Variable && locationSymbol.getType() != SymbolType.Const) {
            throwError(locationName + " is not a variable or constant", context);
        }

        visitChildren(context);
        return environment;
    }

    @Override
    public Environment visitMode_name(LyaParser.Mode_nameContext context) {
        String modeName = context.getText();

        Symbol modeSymbol = environment.lookup(modeName);

        if (modeSymbol == null) {
            throwError("Undefined mode " + modeName, context);
        } else if (modeSymbol.getType() != SymbolType.Mode) {
            throwError(modeName + " is not a mode", context);
        }

        visitChildren(context);
        return environment;
    }

    @Override
    public Environment visitDiscrete_mode_name(LyaParser.Discrete_mode_nameContext context) {
        String modeName = context.getText();

        Symbol modeSymbol = environment.lookup(modeName);

        if (modeSymbol == null) {
            throwError("Undefined mode " + modeName, context);
        } else if (modeSymbol.getType() != SymbolType.Mode) {
            throwError(modeName + " is not a mode", context);
        }

        visitChildren(context);
        return environment;
    }

    @Override
    public Environment visitExit_action(LyaParser.Exit_actionContext context) {
        String labelName = context.label_id().getText();

        Symbol labelSymbol = environment.lookup(labelName);

        if (labelSymbol == null) {
            throwError("Undefined label " + labelName + " called: " + context.getText(), context);
        } else if (labelSymbol.getType() != SymbolType.Label) {
            throwError(labelName + " is not a label", context);
        }

        visitChildren(context);
        return environment;
    }

    @Override
    public Environment visitLoop_counter(LyaParser.Loop_counterContext context) {
        String locationName = context.getText();

        Symbol locationSymbol = environment.lookup(locationName);

        if (locationSymbol == null) {
            throwError("Undefined variable " + locationName, context);
        } else if (locationSymbol.getType() != SymbolType.Variable) {
            throwError(locationName + " is not a variable", context);
        }

        visitChildren(context);
        return environment;
    }

    // Assignment
    @Override
    public Environment visitAssignment_action(LyaParser.Assignment_actionContext context) {
        Type leftSideType = typeExtractionVisitor.visit(context.location());
        Type rightSideType = typeExtractionVisitor.visit(context.expression());

        if (!leftSideType.equals(rightSideType)) {
            throwError("Illegal assignment. Expression should be of type " + leftSideType.getName().getValue(), context);
        }

        return environment;
    }

    // Symbol types
    // Variable
    // Const
    // Procedure
    // Mode
    // Label

}
