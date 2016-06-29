package br.unicamp.ic.mc911.lya.grammar.environment;

/**
 * Created by Diego Rocha (diego.rocha@movile.com)
 */
public class Variable {

    private final Symbol name;
    private final Type type;
    private final int size;
    private final int scope;
    private final int displacement;

    public Variable(Symbol name, Type type, int size, int scope, int displacement) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.scope = scope;
        this.displacement = displacement;
    }

    public Symbol getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public int getScope() {
        return scope;
    }

    public int getDisplacement() {
        return displacement;
    }
}
