package br.unicamp.ic.mc911.lya.grammar.environment;

/**
 * Created by Diego Rocha (diego.rocha@movile.com)
 */
public class StringConstant {

    private final int index;
    private final String string;

    public StringConstant(int index, String string) {
        this.index = index;
        this.string = string;
    }

    public int getIndex() {
        return index;
    }

    public String getString() {
        return string;
    }
}
