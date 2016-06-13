package br.unicamp.ic.mc911.lya.grammar.semantic;

import java.util.List;

/**
 * @author Diego Rocha (diego.rocha@movile.com)
 */
public class TypeAlias implements Type {

    private final Symbol name;
    private final Type type;

    public TypeAlias(Symbol name, Type type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public Symbol getName() {
        return name;
    }

    @Override
    public List<BinaryOperator> getSupportedBinaryOperators() {
        return type.getSupportedBinaryOperators();
    }

    @Override
    public List<UnaryOperator> getSupportedUnaryOperators() {
        return type.getSupportedUnaryOperators();
    }

    @Override
    public Boolean isReference() {
        return type.isReference();
    }

    @Override
    public Boolean isComposite() {
        return type.isComposite();
    }

    @Override
    public Type getReferencedType() {
        return type.getReferencedType();
    }

    @Override
    public Type getTypeParameter() {
        return type.getTypeParameter();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeAlias typeAlias = (TypeAlias) o;

        if (name != null ? !name.equals(typeAlias.name) : typeAlias.name != null) return false;
        return type != null ? type.equals(typeAlias.type) : typeAlias.type == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
