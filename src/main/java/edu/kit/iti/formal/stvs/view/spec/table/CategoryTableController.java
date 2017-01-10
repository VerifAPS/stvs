package edu.kit.iti.formal.stvs.view.spec.table;

import edu.kit.iti.formal.stvs.model.common.IOVariable;
import edu.kit.iti.formal.stvs.model.expressions.Type;
import edu.kit.iti.formal.stvs.model.table.SpecificationTable;
import edu.kit.iti.formal.stvs.model.table.constraint.ConstraintCell;
import edu.kit.iti.formal.stvs.model.table.constraint.ConstraintDuration;
import edu.kit.iti.formal.stvs.model.table.hybrid.HybridSpecification;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.Map;
import java.util.function.Consumer;

abstract public class CategoryTableController {
    private String title;
    private HybridSpecification spec;
    private ObservableList<Type> types;
    private ObservableList<IOVariable> ioVars;
    
    private ObservableMap<IOVariable, TableColumnController> columns;
    private Map<TableColumnController, Integer> columnIndices;
    private ObservableList<TableColumnController> sortedColumns;
    /**
     * Gets called if button for new IOVariable is pressed.
     * Creates IOVariableNamePopupController.
     */
    private EventHandler<ActionEvent> onNewIOVariableButton;
    //private TablePaneController parent;
    /**
     * Listens on changed rows in Specification
     */
    private Consumer<SpecificationTable.RowChangeInfo<ConstraintCell, ConstraintDuration>> rowChangeInfoConsumer;

    public CategoryTableController(String title, HybridSpecification spec, ObservableList<Type> types, ObservableList<IOVariable> ioVars, TablePaneController tablePaneController) {
    }

    public ObservableList<TableColumnController> getColumns() {
        return columns;
    }

    /**
     * 
     * Adds a column of an IOVariable that exists in the code or is newly defined.
     * Automatically adds view listeners for drag detected, mouse moved and drag done to column.
     * Automatically adds model listener to spec.rowsListeners to add remove cells on row change.
     * 
     * @param string name of Variable
     */
    abstract public void addIOVariable(String string);

    /**
     * Resorts 
     */
    private void updateSort(){
        
    }
}
