package edu.kit.iti.formal.stvs.model.table.constraint.problems;

import edu.kit.iti.formal.stvs.model.common.IOVariable;

import java.util.function.Function;

/**
 * Created by philipp on 09.01.17.
 */
public class ParseErrorProblem extends SpecProblem {

    // TODO: Give Parse Error information
    private final IOVariable column;
    private final int row;

    public ParseErrorProblem(IOVariable column, int row) {
        this.column = column;
        this.row = row;
    }


    @Override
    public <R> R match(
            Function<TypeErrorProblem, R> matchTypeError,
            Function<InvalidIOVarProblem, R> matchInvalidIOVar,
            Function<CyclicDependencyProblem, R> matchCyclicDependency,
            Function<ParseErrorProblem, R> matchParseError) {
        return matchParseError.apply(this);
    }

    public IOVariable getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
