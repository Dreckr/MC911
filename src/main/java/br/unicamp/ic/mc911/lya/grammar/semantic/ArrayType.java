package br.unicamp.ic.mc911.lya.grammar.semantic;

import java.util.Collections;
import java.util.List;

/**
 * @author Diego Rocha (diego.rocha@movile.com)
 */
public class ArrayType implements Type {

    private final Type typeParameter;

    public ArrayType(Type typeParameter) {
        this.typeParameter = typeParameter;
    }

    @Override
    public Symbol getName() {
        return new Symbol(SymbolType.Mode, "array[" + typeParameter.getName().getValue() + "]");
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
        return false;
    }

    @Override
    public Boolean isComposite() {
        return true;
    }

    @Override
    public Type getReferencedType() {
        return this;
    }

    @Override
    public Type getTypeParameter() {
        return typeParameter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArrayType arrayType = (ArrayType) o;

        return typeParameter != null ? typeParameter.equals(arrayType.typeParameter) : arrayType.typeParameter == null;

    }

    @Override
    public int hashCode() {
        return typeParameter != null ? typeParameter.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ArrayType{" +
                "typeParameter=" + typeParameter +
                '}';
    }
}
