package edu.kit.iti.formal.stvs.model.table.constraint.problems;

import edu.kit.iti.formal.stvs.model.common.IOVariable;
import edu.kit.iti.formal.stvs.model.common.VariableIdentifier;

import java.util.function.Function;

/**
 * Created by philipp on 09.01.17.
 */
public class InvalidIOVarProblem extends SpecProblem {

    public enum Type {
        INVALID_NAME,
        INVALID_TYPE
    }

    private final VariableIdentifier column;
    private final Type type;

    public InvalidIOVarProblem(VariableIdentifier column, Type type) {
        this.column = column;
        this.type = type;
    }

    @Override
    public <R> R match(
            Function<TypeErrorProblem, R> matchTypeError,
            Function<InvalidIOVarProblem, R> matchInvalidIOVar,
            Function<CyclicDependencyProblem, R> matchCyclicDependency,
            Function<ParseErrorProblem, R> matchParseError) {
        return matchInvalidIOVar.apply(this);
    }

    public VariableIdentifier getVariableIdentifier() {
        return column;
    }

    public Type getType() {
        return type;
    }

}
