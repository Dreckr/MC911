package br.unicamp.ic.mc911.lya.grammar.semantic;

import java.util.Collections;
import java.util.List;

/**
 * @author Diego Rocha (diego.rocha@movile.com)
 */
public class ReferenceType implements Type {

    private final Symbol name;
    private final Type referencedType;

    public ReferenceType(Type referencedType) {
        this.name = new Symbol(SymbolType.Mode, "ref " + referencedType.getName().getValue());
        this.referencedType = referencedType;
    }

    @Override
    public Symbol getName() {
        return name;
    }

    @Override
    public List<BinaryOperator> getSupportedBinaryOperators() {
        return Collections.emptyList();
    }

    @Override
    public List<UnaryOperator> getSupportedUnaryOperators() {
        return Collections.emptyList();
    }

    @Override
    public Boolean isReference() {
        return true;
    }

    @Override
    public Boolean isComposite() {
        return false;
    }

    @Override
    public Type getReferencedType() {
        return referencedType;
    }

    @Override
    public Type getTypeParameter() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReferenceType that = (ReferenceType) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return referencedType != null ? referencedType.equals(that.referencedType) : that.referencedType == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (referencedType != null ? referencedType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ReferenceType{" +
                "name=" + name +
                ", referencedType=" + referencedType +
                '}';
    }
}
