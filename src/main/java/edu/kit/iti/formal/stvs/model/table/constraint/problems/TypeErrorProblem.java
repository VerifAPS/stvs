package edu.kit.iti.formal.stvs.model.table.constraint.problems;

import edu.kit.iti.formal.stvs.model.common.IOVariable;
import edu.kit.iti.formal.stvs.model.common.VariableIdentifier;

import java.util.function.Function;

/**
 * Created by philipp on 09.01.17.
 */
public class TypeErrorProblem extends SpecProblem {

    private final VariableIdentifier column;
    private final int row;

    public TypeErrorProblem(VariableIdentifier column, int row) {
        this.column = column;
        this.row = row;
    }

    @Override
    public <R> R match(
            Function<TypeErrorProblem, R> matchTypeError,
            Function<InvalidIOVarProblem, R> matchInvalidIOVar,
            Function<CyclicDependencyProblem, R> matchCyclicDependency,
            Function<ParseErrorProblem, R> matchParseError) {
        return matchTypeError.apply(this);
    }

    public VariableIdentifier getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
