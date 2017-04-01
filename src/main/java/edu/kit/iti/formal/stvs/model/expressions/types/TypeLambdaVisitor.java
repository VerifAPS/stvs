package edu.kit.iti.formal.stvs.model.expressions.values;

import java.util.function.Function;

/**
 * @author Alexander Weigl
 * @version 1 (01.04.17)
 */
public class ValueLambdaVisitor<T> implements ValueVisitor<T> {
    private Function<ValueInt, T> valueIntFunction;
    private Function<ValueEnum, T> valueEnumFunction;
    private Function<ValueBool, T> valueBoolFunction;

    public ValueLambdaVisitor() {
    }

    public ValueLambdaVisitor(Function<ValueInt, T> valueIntFunction,
            Function<ValueEnum, T> valueEnumFunction,
            Function<ValueBool, T> valueBoolFunction) {
        this.valueIntFunction = valueIntFunction;
        this.valueEnumFunction = valueEnumFunction;
        this.valueBoolFunction = valueBoolFunction;
    }

    public ValueLambdaVisitor setValueIntFunction(
            Function<ValueInt, T> valueIntFunction) {
        this.valueIntFunction = valueIntFunction;
        return this;
    }

    public ValueLambdaVisitor setValueEnumFunction(
            Function<ValueEnum, T> valueEnumFunction) {
        this.valueEnumFunction = valueEnumFunction;
        return this;
    }

    public ValueLambdaVisitor setValueBoolFunction(
            Function<ValueBool, T> valueBoolFunction) {
        this.valueBoolFunction = valueBoolFunction;
        return this;
    }

    @Override public T visit(ValueInt value) {
        if (valueIntFunction != null)
            return valueIntFunction.apply(value);
        return null;
    }

    @Override public T visit(ValueBool value) {
        if (valueBoolFunction != null)
            return valueBoolFunction.apply(value);
        return null;
    }

    @Override public T visit(ValueEnum value) {
        if (valueEnumFunction != null)
            return valueEnumFunction.apply(value);
        return null;
    }

}
