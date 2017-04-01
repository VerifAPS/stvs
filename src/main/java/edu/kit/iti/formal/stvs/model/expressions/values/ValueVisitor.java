package edu.kit.iti.formal.stvs.model.expressions.values;

/**
 * @author Alexander Weigl
 * @version 1 (31.03.17)
 */
public interface ValueVisitor<T> {
    T visit(ValueInt value);

    /*
        T visit(ValueSInt value);

        T visit(ValueDInt value);

        T visit(ValueLInt value);

        T visit(ValueUInt value);

        T visit(ValueUSInt value);

        T visit(ValueUDInt value);

        T visit(ValueULInt value);
    */
    T visit(ValueBool value);

    T visit(ValueEnum value);
}
