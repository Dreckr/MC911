package br.unicamp.ic.mc911.lya.grammar.environment;

import java.util.Collections;
import java.util.List;

/**
 * Created by Diego Rocha (diego.rocha@movile.com)
 */
public class Variable {

    private final Symbol name;
    private final Type type;
    private final int size;
    private final int scope;
    private final int displacement;
    private final List<Integer> indexesSizes;

    public Variable(Symbol name, Type type, int size, int scope, int displacement) {
        this(name, type, size, scope, displacement, Collections.<Integer>emptyList());
    }

    public Variable(Symbol name, Type type, int size, int scope, int displacement, List<Integer> indexesSizes) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.scope = scope;
        this.displacement = displacement;
        this.indexesSizes = indexesSizes;
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

    public List<Integer> getIndexesSizes() {
        return indexesSizes;
    }
}
