package br.unicamp.ic.mc911.lya.grammar.semantic.visitors;

import br.unicamp.ic.mc911.lya.grammar.LyaBaseVisitor;
import br.unicamp.ic.mc911.lya.grammar.LyaParser;
import br.unicamp.ic.mc911.lya.grammar.semantic.*;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * @author Diego Rocha (diego.rocha@movile.com)
 */
public class ExpressionTypeExtractionVisitor extends LyaBaseVisitor<Type> {

    private final Environment environment;

    public ExpressionTypeExtractionVisitor(Environment environment) {
        this.environment = environment;
    }

    // Literals
    // Visit integer_literal
    // Visit boolean_literal
    // Visit character_literal
    // Visit empty_literal
    // Visit character_string_literal
    @Override
    public Type visitInteger_literal(LyaParser.Integer_literalContext context) {
        return PrimitiveType.INT;
    }

    @Override
    public Type visitBoolean_literal(LyaParser.Boolean_literalContext context) {
        return PrimitiveType.BOOL;
    }

    @Override
    public Type visitCharacter_literal(LyaParser.Character_literalContext context) {
        return PrimitiveType.CHAR;
    }

    @Override
    public Type visitEmpty_literal(LyaParser.Empty_literalContext context) {
        return NullType.NULL;
    }

    @Override
    public Type visitCharacter_string_literal(LyaParser.Character_string_literalContext context) {
        return PrimitiveType.STRING;
    }

    // Operations
    // Visit operand0
    // Visit operand1
    // Visit operand2
    // Visit operand3
    @Override
    public Type visitOperand0(LyaParser.Operand0Context context) {
        if (context.operator1() != null) {
            Type operand0Type = context.operand0().accept(this);
            Type operand1Type = context.operand1().accept(this);

            if (context.operator1().relational_operator() != null) {
                BinaryOperator binaryOperator = BinaryOperator.findOperatorByToken(context.operator1().getText());

                if (binaryOperator == null) {
                    throwError("Illegal membership operator: " + context.operator1().getText(), context);
                }

                if (!operand0Type.equals(operand1Type)) {
                    throwError("Operand types do not match", context);
                } else if (!operand0Type.getSupportedBinaryOperators().contains(binaryOperator)) {
                    throwError("Unsupported binary operator " + binaryOperator.name(), context);
                }

                return PrimitiveType.BOOL;
            } else {

                if (!operand1Type.isComposite()) {
                    throwError("Unsupported IN operator", context);
                } else if (!operand0Type.equals(operand1Type.getTypeParameter())) {
                    throwError("Type mismatch on: " + context.getText(), context);
                }

                return PrimitiveType.BOOL;
            }
        }

        return visitChildren(context);
    }

    @Override
    public Type visitOperand1(LyaParser.Operand1Context context) {
        if (context.operator2() != null) {
            Type operand1Type = context.operand1().accept(this);
            Type operand2Type = context.operand2().accept(this);

            if (!operand1Type.equals(operand2Type)) {
                throwError("Operand types do not match", context);
            }

            if (context.operator2().arithmetic_additive_operator() != null) {
                BinaryOperator binaryOperator = BinaryOperator.findOperatorByToken(context.operator2().getText());

                if (binaryOperator == null) {
                    throwError("Illegal operator: " + context.operator2().getText(), context);
                }

                if (!operand1Type.getSupportedBinaryOperators().contains(binaryOperator)) {
                    throwError("Unsupported binary operator " + binaryOperator.name(), context);
                }

                return operand1Type;
            } else {
                if (!operand1Type.isComposite()) {
                    throwError("Unsupported & operator", context);
                } else if (!operand1Type.getReferencedType().equals(PrimitiveType.STRING)) {
                    throw new IllegalArgumentException(
                            "Type " + operand1Type.getName() + " of " + context.operand1().getText() + " does not support String concatenation");
                } else if (!operand2Type.getReferencedType().equals(PrimitiveType.STRING)) {
                    throw new IllegalArgumentException(
                            "Type " + operand2Type.getName() + " of " + context.operand2().getText() + " does not support String concatenation");
                }

                return operand1Type;
            }
        }

        return visitChildren(context);
    }

    @Override
    public Type visitOperand2(LyaParser.Operand2Context context) {
        if (context.arithmetic_multiplicative_operator() != null) {
            Type operand2Type = context.operand2().accept(this);
            Type operand3Type = context.operand3().accept(this);

            if (!operand2Type.equals(operand3Type)) {
                throwError("Operand types do not match", context);
            }

            BinaryOperator binaryOperator =
                    BinaryOperator.findOperatorByToken(context.arithmetic_multiplicative_operator().getText());

            if (binaryOperator == null) {
                throwError("Illegal operator: " + context.arithmetic_multiplicative_operator().getText(), context);
            }

            if (!operand2Type.getSupportedBinaryOperators().contains(binaryOperator)) {
                throwError("Unsupported binary operator " + binaryOperator.name(), context);
            }

            return operand2Type;
        }

        return visitChildren(context);
    }

    @Override
    public Type visitOperand3(LyaParser.Operand3Context context) {
        if (context.monadic_operator() != null) {
            Type operand4Type = context.operand4().accept(this);

            UnaryOperator unaryOperator =
                    UnaryOperator.findOperatorByToken(context.monadic_operator().getText());

            if (unaryOperator == null) {
                throwError("Illegal operator: " + context.monadic_operator().getText(), context);
            }

            if (!operand4Type.getSupportedUnaryOperators().contains(unaryOperator)) {
                throwError("Unsupported unary operator " + unaryOperator.name(), context);
            }

            return operand4Type;
        }

        return visitChildren(context);
    }

    @Override
    public Type visitParenthesized_expression(LyaParser.Parenthesized_expressionContext context) {
        return context.expression().accept(this);
    }

    // Locations
    // Visit location_name
    // Visit dereferenced_reference
    // Visit array_element
    // Visit array_slice
    // Visit string_element
    // Visit string_slice
    // Visit builtin_call
    // Visit procedure_call
    // Visit referenced_location
    @Override
    public Type visitLocation_name(LyaParser.Location_nameContext context) {
        String locationName = context.getText();

        Symbol locationSymbol = environment.lookup(locationName);
        if (locationSymbol == null) {
            throwError("Undefined location " + locationName, context);
        }

        Location location = environment.findLocation(locationSymbol);
        if (location == null) {
            throwError(locationName + " is not a location", context);
        }

        return location.getType();
    }

    @Override
    public Type visitDereferenced_reference(LyaParser.Dereferenced_referenceContext context) {
        // TODO: wtf?
        return null;
    }

    @Override
    public Type visitArray_element(LyaParser.Array_elementContext context) {
        String locationName = context.array_location().getText();

        Symbol locationSymbol = environment.lookup(locationName);
        if (locationSymbol == null) {
            throwError("Undefined location " + locationName, context);
        }

        Location location = environment.findLocation(locationSymbol);
        if (location == null) {
            throwError(locationName + " is not a location", context);
        } else if (!location.getType().isComposite()) {
            throwError(locationName + " is not of composite type", context);
        }

        return location.getType().getTypeParameter();
    }

    @Override
    public Type visitArray_slice(LyaParser.Array_sliceContext context) {
        String locationName = context.array_location().getText();

        Symbol locationSymbol = environment.lookup(locationName);
        if (locationSymbol == null) {
            throwError("Undefined location " + locationName, context);
        }

        Location location = environment.findLocation(locationSymbol);
        if (location == null) {
            throwError(locationName + " is not a location", context);
        } else if (!location.getType().isComposite()) {
            throwError(locationName + " is not of composite type", context);
        }

        return location.getType();
    }

    @Override
    public Type visitString_element(LyaParser.String_elementContext context) {
        String locationName = context.string_location().getText();

        Symbol locationSymbol = environment.lookup(locationName);
        if (locationSymbol == null) {
            throwError("Undefined location " + locationName, context);
        }

        Location location = environment.findLocation(locationSymbol);
        if (location == null) {
            throwError(locationName + " is not a location", context);
        } else if (!location.getType().isComposite()) {
            throwError(locationName + " is not of composite type", context);
        }

        return location.getType().getTypeParameter();
    }

    @Override
    public Type visitString_slice(LyaParser.String_sliceContext context) {
        String locationName = context.string_location().getText();

        Symbol locationSymbol = environment.lookup(locationName);
        if (locationSymbol == null) {
            throwError("Undefined location " + locationName, context);
        }

        Location location = environment.findLocation(locationSymbol);
        if (location == null) {
            throwError(locationName + " is not a location", context);
        } else if (!location.getType().isComposite()) {
            throwError(locationName + " is not of composite type", context);
        }

        return location.getType();
    }

    @Override
    public Type visitBuiltin_call(LyaParser.Builtin_callContext context) {
        return VoidType.VOID;
    }

    @Override
    public Type visitProcedure_call(LyaParser.Procedure_callContext context) {
        String procedureName = context.procedure_name().getText();

        Symbol procedureSymbol = environment.lookup(procedureName);
        if (procedureSymbol == null) {
            throwError("Undefined procedure " + procedureName, context);
        }

        Procedure procedure = environment.findProcedure(procedureSymbol);
        if (procedure == null) {
            throwError(procedureName + " is not a procedure", context);
        }

        return procedure.getReturnType();
    }

    @Override
    public Type visitReferenced_location(LyaParser.Referenced_locationContext context) {
        Type referencedType = context.location().accept(this);

        return new ReferenceType(referencedType);
    }

    private void throwError(String message, ParserRuleContext context) {
        throw new IllegalArgumentException(message + " on line " + context.getStart().getLine());
    }

}
