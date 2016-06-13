package br.unicamp.ic.mc911.lya.grammar.semantic;

/**
 * @author Diego Rocha (diego.rocha@movile.com)
 */
public enum UnaryOperator {
    POSITIVE, NEGATIVE, NEGATION;

    public static UnaryOperator findOperatorByToken(String token) {
        if (token.equals("+")) return POSITIVE;
        else if (token.equals("-")) return NEGATIVE;
        else if (token.equals("!")) return NEGATION;
        else return null;
    }
}
