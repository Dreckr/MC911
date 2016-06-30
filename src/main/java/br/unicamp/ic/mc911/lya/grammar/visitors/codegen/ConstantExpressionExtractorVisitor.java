package br.unicamp.ic.mc911.lya.grammar.visitors.codegen;

import br.unicamp.ic.mc911.lya.grammar.LyaBaseVisitor;
import br.unicamp.ic.mc911.lya.grammar.LyaParser;
import br.unicamp.ic.mc911.lya.grammar.environment.*;
import br.unicamp.ic.mc911.lya.grammar.visitors.utils.LyaUtils;

import static br.unicamp.ic.mc911.lya.grammar.visitors.utils.LyaUtils.throwError;

/**
 * Created by Diego Rocha (diego.rocha@movile.com)
 */
public class ConstantExpressionExtractorVisitor extends LyaBaseVisitor<Object> {

    private final Environment environment;

    public ConstantExpressionExtractorVisitor(Environment environment) {
        this.environment = environment;
    }

    @Override
    public Integer visitInteger_literal(LyaParser.Integer_literalContext context) {
        return Integer.parseInt(context.getText());
    }

    @Override
    public Boolean visitBoolean_literal(LyaParser.Boolean_literalContext context) {
        return Boolean.parseBoolean(context.getText());
    }

    @Override
    public Character visitCharacter_literal(LyaParser.Character_literalContext context) {
        return context.getText().charAt(1);
    }

    @Override
    public Object visitEmpty_literal(LyaParser.Empty_literalContext context) {
        return null;
    }

    @Override
    public StringConstant visitCharacter_string_literal(LyaParser.Character_string_literalContext context) {
        String text = context.getText();
        text = text.substring(1, text.length() - 1);

        return environment.addStringConstant(text);
    }

    // Operations
    // Visit operand0
    // Visit operand1
    // Visit operand2
    // Visit operand3
    @Override
    public Object visitOperand0(LyaParser.Operand0Context context) {
        Object value = null;
        if (context.operator1() != null) {
            Object operand0 = context.operand0().accept(this);
            Object operand1 = context.operand1().accept(this);

            if (context.operator1().relational_operator() != null) {
                BinaryOperator binaryOperator = BinaryOperator.findOperatorByToken(context.operator1().getText());

                if (binaryOperator == null) {
                    throwError("Illegal binary operator " + context.operator1().getText(), context);
                }

                switch (binaryOperator) {
                    case AND:
                        value = ((Boolean) operand0) && ((Boolean) operand1);
                        break;
                    case OR:
                        value = ((Boolean) operand0) || ((Boolean) operand1);
                        break;
                    case EQ:
                        value = operand0.equals(operand1);
                        break;
                    case DIFF:
                        value = !operand0.equals(operand1);
                        break;
                    case GT:
                        value = ((Comparable)operand0).compareTo(operand1) > 0;
                        break;
                    case GTE:
                        value = ((Comparable)operand0).compareTo(operand1) >= 0;
                        break;
                    case LT:
                        value = ((Comparable)operand0).compareTo(operand1) < 0;
                        break;
                    case LTE:
                        value = ((Comparable)operand0).compareTo(operand1) <= 0;
                        break;
                    default:
                        throwError("Unsupported binary operator " + binaryOperator.name(), context);
                }
            } else {
                Character character = (Character) operand0;
                StringConstant stringConstant = (StringConstant) operand1;

                value = stringConstant.getString().indexOf(character) >= 0;
            }
        } else {
            value = context.operand1().accept(this);
        }

        return value;
    }

    @Override
    public Object visitOperand1(LyaParser.Operand1Context context) {
        Object value = null;

        if (context.operator2() != null) {
            Object operand1 = context.operand1().accept(this);
            Object operand2 = context.operand2().accept(this);

            if (context.operator2().arithmetic_additive_operator() != null) {
                BinaryOperator binaryOperator = BinaryOperator.findOperatorByToken(context.operator2().getText());

                if (binaryOperator == null) {
                    throwError("Illegal operator: " + context.operator2().getText(), context);
                }

                switch (binaryOperator) {
                    case PLUS:
                        value = ((Integer) operand1) + ((Integer) operand2);
                        break;
                    case MINUS:
                        value = ((Integer) operand1) - ((Integer) operand2);
                        break;
                    default:
                        throwError("Unsupported binary operator " + binaryOperator.name(), context);
                }

            } else {
                String string = ((StringConstant) operand1).getString() + ((StringConstant) operand2).getString();

                value = environment.addStringConstant(string);
            }
        } else {
            value = context.operand2().accept(this);
        }

        return value;
    }

    @Override
    public Object visitOperand2(LyaParser.Operand2Context context) {
        Object value = null;

        if (context.arithmetic_multiplicative_operator() != null) {
            Integer operand2 = (Integer) context.operand2().accept(this);
            Integer operand3 = (Integer) context.operand3().accept(this);

            BinaryOperator binaryOperator =
                    BinaryOperator.findOperatorByToken(context.arithmetic_multiplicative_operator().getText());

            if (binaryOperator == null) {
                throwError("Illegal operator: " + context.arithmetic_multiplicative_operator().getText(), context);
            }

            switch (binaryOperator) {
                case MULT:
                    value = operand2 * operand3;
                    break;
                case MOD:
                    value = operand2 % operand3;
                    break;
                case DIV:
                    value = operand2 / operand3;
                    break;
                default:
                    throwError("Unsupported binary operator " + binaryOperator.name(), context);
            }
        } else {
            value = context.operand3().accept(this);
        }

        return value;
    }

    @Override
    public Object visitOperand3(LyaParser.Operand3Context context) {
        Object value = null;

        if (context.monadic_operator() != null) {
            Object operand4 = context.operand4().accept(this);

            UnaryOperator unaryOperator =
                    UnaryOperator.findOperatorByToken(context.monadic_operator().getText());

            if (unaryOperator == null) {
                throwError("Illegal operator: " + context.monadic_operator().getText(), context);
            }

            switch (unaryOperator) {
                case NEGATION:
                    value = !((Boolean) operand4);
                    break;
                case NEGATIVE:
                    value = -((Integer) operand4);
                    break;
                case POSITIVE:
                    value = operand4;
                    break;
                default:
                    throwError("Unsupported unary operator " + unaryOperator.name(), context);
            }
        } else {
            value = context.operand4().accept(this);
        }

        return value;
    }

    @Override
    public Object visitParenthesized_expression(LyaParser.Parenthesized_expressionContext context) {
        return context.expression().accept(this);
    }

    // Locations
    // Visit location_name
    @Override
    public Object visitLocation_name(LyaParser.Location_nameContext context) {
        String constantName = context.getText();

        Symbol symbol = environment.findSymbol(constantName);
        if (symbol == null) {
            throwError(constantName + " is undefined", context);
        }

        if (symbol.getType() == SymbolType.Const) {
            Integer constant = LyaUtils.constantValueToInstArg(environment.findConstant(symbol), context);

            if (constant == null) {
                throwError("Undefined constant " + constantName, context);
            }

            return constant;
        } else {
            throwError("Illegal location for constant " + constantName, context);
        }

        return  null;
    }
}
