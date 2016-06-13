package br.unicamp.ic.mc911.lya.grammar.semantic;

/**
 * @author Diego Rocha (diego.rocha@movile.com)
 */
public enum BinaryOperator {
    PLUS, MINUS, MULT, DIV, MOD, EQ, DIFF, GT, GTE, LT, LTE, AND, OR;

    public static BinaryOperator findOperatorByToken(String token) {
        if (token.equals("+")) return PLUS;
        else if (token.equals("-")) return MINUS;
        else if (token.equals("*")) return MULT;
        else if (token.equals("/")) return DIV;
        else if (token.equals("%")) return MOD;
        else if (token.equals("==")) return EQ;
        else if (token.equals("!=")) return DIFF;
        else if (token.equals(">")) return GT;
        else if (token.equals(">=")) return GTE;
        else if (token.equals("<")) return LT;
        else if (token.equals("<=")) return LTE;
        else if (token.equals("&&")) return AND;
        else if (token.equals("||")) return OR;
        else return null;
    }
}
