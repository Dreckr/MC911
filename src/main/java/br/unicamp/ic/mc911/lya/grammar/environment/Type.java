package br.unicamp.ic.mc911.lya.grammar.environment;

import java.util.List;

/**
 * @author Diego Rocha (diego.rocha@movile.com)
 */
public interface Type {

    Symbol getName();
    List<BinaryOperator> getSupportedBinaryOperators();
    List<UnaryOperator> getSupportedUnaryOperators();

    Boolean isReference();
    Boolean isComposite();
    Type getReferencedType();
    Type getTypeParameter();

}
