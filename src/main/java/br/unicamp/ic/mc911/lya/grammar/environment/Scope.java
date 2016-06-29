package br.unicamp.ic.mc911.lya.grammar.environment;

import java.util.HashMap;

/**
 * @author Diego Rocha (diego.rocha@movile.com)
 */
public class Scope extends HashMap<String, Symbol> {

    private final int index;
    private int nextPosition = 0;
    private int returnDisplacement = -1;

    public Scope(int index) {
        super();
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public int getAndIncrementNextPosition(int increment) {
        int position = nextPosition;

        nextPosition += increment;

        return position;
    }

    public void setReturnDisplacement(int returnDisplacement) {
        this.returnDisplacement = returnDisplacement;
    }

    public int getReturnDisplacement() {
        return returnDisplacement;
    }
}
