package edu.kit.iti.formal.stvs.view.spec.table.cells;

import edu.kit.iti.formal.stvs.view.Controller;

public class CounterexampleCellController implements Controller {
    private String text;
    private CounterexampleCell counterexampleCell;

    public CounterexampleCellController(String string) {
    }

    @Override
    public CounterexampleCell getView() {
        return counterexampleCell;
    }
}