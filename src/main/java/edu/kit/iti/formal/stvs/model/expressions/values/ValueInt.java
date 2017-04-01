package edu.kit.iti.formal.stvs.model.expressions;

/**
 * Runtime-representation for integer values of {@link Expression}s.
 * This is not a singleton (in contrast to {@link ValueBool}), since many different instances can be
 * created at runtime.
 *
 * @author Philipp
 */
public class ValueInt extends AbstractValue.AnyIntValue {

    /**
     * @param value the integer this value should represent.
     */
    public ValueInt(int value) {
        super(value, type);
    }

    @Override public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override public TypeInt getType() {
        return TypeInt.INT;
    }
}
