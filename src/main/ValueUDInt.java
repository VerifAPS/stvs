package edu.kit.iti.formal.stvs.model.expressions.values;

import edu.kit.iti.formal.stvs.model.expressions.types.AnyIntType;

/**
 * @author Alexander Weigl
 * @version 1 (31.03.17)
 */
public class ValueUDInt extends AbstractValue.AnyIntValue {
    public ValueUDInt(int value) {
        super(value, AnyIntType.UDINT);
    }

    @Override public <T> T accept(ValueVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
