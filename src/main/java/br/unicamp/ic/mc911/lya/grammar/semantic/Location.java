package br.unicamp.ic.mc911.lya.grammar.semantic;

/**
 * @author Diego Rocha (diego.rocha@movile.com)
 */
public class Location {

    private final Symbol name;
    private final Type type;

    public Location(Symbol name, Type type) {
        this.name = name;
        this.type = type;
    }

    public Symbol getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
}
