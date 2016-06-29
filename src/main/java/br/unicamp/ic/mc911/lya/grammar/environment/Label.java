package br.unicamp.ic.mc911.lya.grammar.environment;

/**
 * Created by Diego Rocha (diego.rocha@movile.com)
 */
public class Label {

    private final Integer index;
    private final Symbol name;

    public Label(Integer index, Symbol name) {
        this.index = index;
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public Symbol getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Label label = (Label) o;

        if (index != null ? !index.equals(label.index) : label.index != null) return false;
        return name != null ? name.equals(label.name) : label.name == null;

    }

    @Override
    public int hashCode() {
        int result = index != null ? index.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Label{" +
                "index=" + index +
                ", name=" + name +
                '}';
    }
}
