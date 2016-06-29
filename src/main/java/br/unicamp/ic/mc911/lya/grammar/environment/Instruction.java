package br.unicamp.ic.mc911.lya.grammar.environment;

/**
 * Created by Diego Rocha (diego.rocha@movile.com)
 */
public class Instruction {

    private final String mnemonic;
    private final Integer firstArg, secondArg;

    public Instruction(String mnemonic) {
        this(mnemonic, null, null);
    }

    public Instruction(String mnemonic, Integer firstArg) {
        this(mnemonic, firstArg, null);
    }

    public Instruction(String mnemonic, Integer firstArg, Integer secondArg) {
        this.mnemonic = mnemonic;
        this.firstArg = firstArg;
        this.secondArg = secondArg;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    public Integer getFirstArg() {
        return firstArg;
    }

    public Integer getSecondArg() {
        return secondArg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Instruction that = (Instruction) o;

        if (mnemonic != null ? !mnemonic.equals(that.mnemonic) : that.mnemonic != null) return false;
        if (firstArg != null ? !firstArg.equals(that.firstArg) : that.firstArg != null) return false;
        return secondArg != null ? secondArg.equals(that.secondArg) : that.secondArg == null;

    }

    @Override
    public int hashCode() {
        int result = mnemonic != null ? mnemonic.hashCode() : 0;
        result = 31 * result + (firstArg != null ? firstArg.hashCode() : 0);
        result = 31 * result + (secondArg != null ? secondArg.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String stringValue = "('" + mnemonic + "', ";

        if (firstArg != null) {
            stringValue += firstArg;
        }

        if (secondArg != null) {
            stringValue += ", " + secondArg;
        }

        stringValue += ")";

        return stringValue;
    }
}
