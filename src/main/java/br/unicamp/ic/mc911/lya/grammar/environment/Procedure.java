package br.unicamp.ic.mc911.lya.grammar.environment;

/**
 * @author Diego Rocha (diego.rocha@movile.com)
 */
public class Procedure {

    private final Symbol name;
    private final Type returnType;

    public Procedure(Symbol name, Type returnType) {
        this.name = name;
        this.returnType = returnType;
    }

    public Symbol getName() {
        return name;
    }

    public Type getReturnType() {
        return returnType;
    }
}
