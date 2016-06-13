package br.unicamp.ic.mc911.lya.grammar.semantic;

/**
 * @author Diego Rocha (diego.rocha@movile.com)
 */
public class Symbol {

    private final SymbolType type;
    private final String value;

    public Symbol(SymbolType type, String name) {
        this.type = type;
        this.value = name;
    }

    public SymbolType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Symbol symbol = (Symbol) o;

        if (type != symbol.type) return false;
        return value != null ? value.equals(symbol.value) : symbol.value == null;

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }
}
