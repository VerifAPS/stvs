package edu.kit.iti.formal.stvs.model.expressions.values;

import edu.kit.iti.formal.stvs.model.expressions.types.AnyIntType;

/**
 * @author Alexander Weigl
 * @version 1 (31.03.17)
 */
public class ValueDInt extends AbstractValue.AnyIntValue {
    public ValueDInt(int value) {
        super(value, AnyIntType.DINT);
    }

    @Override public <T> T accept(ValueVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
