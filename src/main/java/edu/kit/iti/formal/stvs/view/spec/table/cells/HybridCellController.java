package edu.kit.iti.formal.stvs.view.spec.table.cells;

import edu.kit.iti.formal.stvs.model.table.CellOperationProvider;
import edu.kit.iti.formal.stvs.view.Controller;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class HybridCellController implements Controller {
    private StringProperty comment;
    private ObservableList<String> counterexamples;
    private ValueCellController valueCellController;

    public ObservableList<String> getCounterexamples() {
        return null;
    }

    public StringProperty getValueProperty() {
        return null;
    }

    public StringProperty getCommentProperty() {
        return null;
    }

    private void onAddUserInputStringChanged(String string){}

    public HybridCellController(CellOperationProvider cell, ObservableList<String> counterexamples) {
    }

    public HybridCell getView() {
        return null;
    }
}
