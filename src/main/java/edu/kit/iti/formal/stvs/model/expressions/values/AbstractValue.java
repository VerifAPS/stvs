package edu.kit.iti.formal.stvs.model.expressions;

import edu.kit.iti.formal.stvs.model.expressions.types.TypeInt;
import edu.kit.iti.formal.stvs.model.expressions.values.Value;
import edu.kit.iti.formal.stvs.model.expressions.values.ValueVisitor;

import java.math.BigInteger;

/**
 * @author Alexander Weigl
 * @version 1 (31.03.17)
 */
public abstract class AbstractValue implements Value {

    public static abstract class AnyIntValue extends AbstractValue {
        protected final BigInteger value;
        private final TypeInt type;

        public AnyIntValue(BigInteger value, TypeInt type) {
            this.value = value;
            this.type = type;
        }

        public AnyIntValue(int value, TypeInt type) {
            this(BigInteger.valueOf(value), type);
        }

        public BigInteger getValue() {
            return value;
        }

        @Override public TypeInt getType() {
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
            if (!(o instanceof AnyIntValue))
                return false;

            AnyIntValue that = (AnyIntValue) o;

            return value.equals(that.value);
        }

        @Override public int hashCode() {
            return value.hashCode();
        }
    }

    public static class ValueSInt extends AbstractValue.AnyIntValue {
        public ValueSInt(int value) {
            super(value, TypeInt.SINT);
        }

        @Override public <T> T accept(ValueVisitor<T> visitor) {
            return visitor.visit(this);
        }

    }

    public class ValueDInt extends AbstractValue.AnyIntValue {
        public ValueDInt(int value) {
            super(value, TypeInt.SINT);
        }

        @Override public <T> T accept(ValueVisitor<T> visitor) {
            return visitor.visit(this);
        }

    }

    public class ValueLInt extends AbstractValue.AnyIntValue {
        public ValueLInt(int value) {
            super(value, TypeInt.LINT);
        }

        @Override public <T> T accept(ValueVisitor<T> visitor) {
            return visitor.visit(this);
        }

    }

    public class ValueUInt extends AbstractValue.AnyIntValue {
        public ValueUInt(int value) {
            super(value, TypeInt.UINT);
        }

        @Override public <T> T accept(ValueVisitor<T> visitor) {
            return visitor.visit(this);
        }

    }

    public class ValueUSInt extends AbstractValue.AnyIntValue {
        public ValueUSInt(int value) {
            super(value, TypeInt.USINT);
        }

        @Override public <T> T accept(ValueVisitor<T> visitor) {
            return visitor.visit(this);
        }

    }

    public class ValueUDInt extends AbstractValue.AnyIntValue {
        public ValueUDInt(int value) {
            super(value, TypeInt.UDINT);
        }

        @Override public <T> T accept(ValueVisitor<T> visitor) {
            return visitor.visit(this);
        }

    }

    public class ValueULInt extends AbstractValue.AnyIntValue {
        public ValueULInt(int value) {
            super(value, TypeInt.SINT);
        }

        @Override public <T> T accept(ValueVisitor<T> visitor) {
            return visitor.visit(this);
        }
    }
}
