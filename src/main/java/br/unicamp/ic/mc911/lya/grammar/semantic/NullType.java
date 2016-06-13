package br.unicamp.ic.mc911.lya.grammar.semantic;

import java.util.Collections;
import java.util.List;

/**
 * @author Diego Rocha (diego.rocha@movile.com)
 */
public enum NullType implements Type {
    NULL;

    @Override
    public Symbol getName() {
        return new Symbol(SymbolType.Mode, "null");
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
        return false;
    }

    @Override
    public Type getReferencedType() {
        return this;
    }

    @Override
    public Type getTypeParameter() {
        return null;
    }

}
