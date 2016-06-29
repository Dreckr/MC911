package br.unicamp.ic.mc911.lya.grammar.environment;

/**
 * Created by Diego Rocha (diego.rocha@movile.com)
 */
public class Constant {

    private final Type type;
    private final Object value;

    public Constant(Type type, Object value) {
        this.type = type;
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Constant constant = (Constant) o;

        if (type != null ? !type.equals(constant.type) : constant.type != null) return false;
        return value != null ? value.equals(constant.value) : constant.value == null;

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Constant{" +
                "type=" + type +
                ", value=" + value +
                '}';
    }
}
