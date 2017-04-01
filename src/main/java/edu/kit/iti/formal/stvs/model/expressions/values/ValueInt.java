package edu.kit.iti.formal.stvs.model.expressions.values;

import edu.kit.iti.formal.stvs.logic.specification.smtlib.BitvectorUtils;
import edu.kit.iti.formal.stvs.model.expressions.Expression;
import edu.kit.iti.formal.stvs.model.expressions.types.AnyIntType;

import java.math.BigInteger;
import java.nio.charset.Charset;

/**
 * Runtime-representation for integer values of {@link Expression}s.
 * This is not a singleton (in contrast to {@link ValueBool}),
 * since many different instances can be created at runtime.
 *
 * @author Philipp
 * @author Alexander Weigl
 */
public class ValueInt implements Value {
    protected final BigInteger value;
    protected final AnyIntType type;

    public ValueInt(BigInteger value) {
        this(value, AnyIntType.getSuitableType(value));
    }

    public ValueInt(BigInteger value, AnyIntType type) {
        assert type!=null;
        this.value = value;
        this.type = type;
    }

    public ValueInt(long value, AnyIntType type) {
        this(BigInteger.valueOf(value), type);
    }

    public ValueInt(long value) {
        this(BigInteger.valueOf(value));
    }

    public String toSMTLiteral() {
       /* byte[] twocompl = value.toByteArray();
        String result = "";
        for (int i = 0; i < twocompl.length; i++) {
            result = Integer.toHexString(twocompl[i]) + result;
        }
        return "#x" + result;*/
        return BitvectorUtils
                .hexFromInt(value.longValue(), type.getBitwidth() / 4);
    }

    public ValueInt fromSMTLiteral(String literal, AnyIntType type) {
        if (literal == null || !literal.matches("\\#x[a-fA-F0-9]+")) {
            throw new IllegalArgumentException("The given literal '" + literal
                    + "' does not match expected format");
        }
        byte[] hex = literal.substring(2).getBytes();
        BigInteger value = new BigInteger(hex);
        return new ValueInt(value, type);
    }

    @Override public <T> T accept(ValueVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public BigInteger getValue() {
        return value;
    }

    @Override public AnyIntType getType() {
        return type;
    }

    @Override public String getValueString() {
        return getValue().toString();
    }

    @Override public String toString() {
        return getClass().getSimpleName() + "(" + getValueString() + ")";
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ValueInt))
            return false;

        ValueInt valueInt = (ValueInt) o;

        if (!value.equals(valueInt.value))
            return false;
        return type.equals(valueInt.type);
    }

    @Override public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}
