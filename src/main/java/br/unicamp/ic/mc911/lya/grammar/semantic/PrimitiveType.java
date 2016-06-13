package br.unicamp.ic.mc911.lya.grammar.semantic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static br.unicamp.ic.mc911.lya.grammar.semantic.BinaryOperator.*;
import static br.unicamp.ic.mc911.lya.grammar.semantic.UnaryOperator.*;

/**
 * @author Diego Rocha (diego.rocha@movile.com)
 */
public enum PrimitiveType implements Type {

    INT(new Symbol(SymbolType.Mode, "int"), false, Arrays.asList(PLUS, MINUS, MULT, DIV, MOD, EQ, DIFF, GT, GTE, LT, LTE), Arrays.asList(POSITIVE, NEGATIVE), null),
    CHAR(new Symbol(SymbolType.Mode, "char"), false, Arrays.asList(EQ, DIFF, GT, GTE, LT, LTE), Collections.<UnaryOperator>emptyList(), null),
    BOOL(new Symbol(SymbolType.Mode, "bool"), false, Arrays.asList(EQ, DIFF, AND, OR), Collections.singletonList(NEGATION), null),
    STRING(new Symbol(SymbolType.Mode, "string"), true, Arrays.asList(PLUS, EQ, DIFF), Collections.<UnaryOperator>emptyList(), CHAR);

    private Symbol name;
    private Boolean isComposite;
    private Type typeParameter;
    private List<BinaryOperator> supportedBinaryOperators;
    private List<UnaryOperator> supportedUnaryOperators;

    PrimitiveType(Symbol name,
                  Boolean isComposite,
                  List<BinaryOperator> supportedBinaryOperators,
                  List<UnaryOperator> supportedUnaryOperators,
                  Type typeParameter) {
        this.name = name;
        this.isComposite = isComposite;
        this.supportedBinaryOperators = supportedBinaryOperators;
        this.supportedUnaryOperators = supportedUnaryOperators;
        this.typeParameter = typeParameter;
    }

    public Symbol getName() {
        return name;
    }

    public List<BinaryOperator> getSupportedBinaryOperators() {
        return supportedBinaryOperators;
    }

    public List<UnaryOperator> getSupportedUnaryOperators() {
        return supportedUnaryOperators;
    }

    public Boolean isReference() {
        return false;
    }

    public Boolean isComposite() {
        return isComposite;
    }

    public Type getReferencedType() {
        return this;
    }

    public Type getTypeParameter() {
        return typeParameter;
    }

}
