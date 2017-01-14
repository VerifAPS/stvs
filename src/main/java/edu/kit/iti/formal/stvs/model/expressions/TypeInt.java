package edu.kit.iti.formal.stvs.model.expressions;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public class TypeInt implements Type {

    @Override
    public <R> R match(
            Supplier<R> matchIntType,
            Supplier<R> matchBoolType,
            Function<TypeEnum, R> matchEnumType) {
        return matchIntType.get();
    }

    @Override
    public boolean checksAgainst(Type other) {
        return other.match(
                () -> true,
                () -> false,
                (otherEnum) -> false);
    }

    @Override
    public String getTypeName() {
        return null;
    }

    @Override
    public Optional<Value> parseLiteral(String literal) {
        return null;
    }

    @Override
    public Value generateDefaultValue() {
        return null;
    }

    public String toString() {
        return "TypeInt";
    }

}