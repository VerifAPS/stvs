package edu.kit.iti.formal.stvs.model.expressions;

import java.util.function.Function;
import java.util.function.Supplier;

public class TypeBool implements Type {

	@Override
	public <R> R match(
			Supplier<R> matchIntType, 
			Supplier<R> matchBoolType, 
			Function<TypeEnum, R> matchEnumType) {
		return matchBoolType.get();
	}

	@Override
	public boolean checksAgainst(Type other) {
		return other.match(
					() -> false, 
					() -> true, 
					(otherEnum) -> false);
	}
	
	public String toString() {
		return "TypeBool";
	}

}
