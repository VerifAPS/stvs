package edu.kit.iti.formal.stvs.model.expressions.types;

import edu.kit.iti.formal.stvs.model.expressions.values.ValueBool;
import edu.kit.iti.formal.stvs.model.expressions.values.ValueEnum;
import edu.kit.iti.formal.stvs.model.expressions.values.ValueInt;
import edu.kit.iti.formal.stvs.model.expressions.values.ValueVisitor;

import java.util.function.Function;

/**
 * @author Alexander Weigl
 * @version 1 (01.04.17)
 */
public class TypeLambdaVisitor<T> implements TypeVisitor<T> {
    private Function<AnyIntType, T> valueIntFunction;
    private Function<TypeEnum, T> valueEnumFunction;
    private Function<TypeBool, T> valueBoolFunction;

    public TypeLambdaVisitor() {
    }

    public TypeLambdaVisitor(Function<AnyIntType, T> valueIntFunction,
            Function<TypeEnum, T> valueEnumFunction,
            Function<TypeBool, T> valueBoolFunction) {
        this.valueIntFunction = valueIntFunction;
        this.valueEnumFunction = valueEnumFunction;
        this.valueBoolFunction = valueBoolFunction;
    }

    public TypeLambdaVisitor setValueIntFunction(
            Function<AnyIntType, T> valueIntFunction) {
        this.valueIntFunction = valueIntFunction;
        return this;
    }

    public TypeLambdaVisitor setValueEnumFunction(
            Function<TypeEnum, T> valueEnumFunction) {
        this.valueEnumFunction = valueEnumFunction;
        return this;
    }

    public TypeLambdaVisitor setValueBoolFunction(
            Function<TypeBool, T> valueBoolFunction) {
        this.valueBoolFunction = valueBoolFunction;
        return this;
    }

    @Override public T visit(AnyIntType type) {
        if (valueIntFunction != null)
            return valueIntFunction.apply(type);
        return null;
    }

    @Override public T visit(TypeEnum typeEnum) {
        if (valueEnumFunction != null)
            return valueEnumFunction.apply(typeEnum);
        return null;
    }

    @Override public T visit(TypeBool typeBool) {
        if (valueBoolFunction != null)
            return valueBoolFunction.apply(typeBool);
        return null;
    }
}
