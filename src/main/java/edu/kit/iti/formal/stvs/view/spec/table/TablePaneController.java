package edu.kit.iti.formal.stvs.view.spec.table;

import edu.kit.iti.formal.stvs.model.common.IOVariable;
import edu.kit.iti.formal.stvs.model.expressions.Type;
import edu.kit.iti.formal.stvs.model.table.SpecificationTable;
import edu.kit.iti.formal.stvs.model.table.constraint.ConstraintCell;
import edu.kit.iti.formal.stvs.model.table.constraint.ConstraintDuration;
import edu.kit.iti.formal.stvs.model.table.hybrid.HybridSpecification;
import edu.kit.iti.formal.stvs.view.spec.table.rowActions.RowEvent;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.collections.ObservableSet;
import javafx.event.EventHandler;

import java.util.function.Consumer;

public class TablePaneController {
    private EventHandler<RowEvent> addRowHandler;
    private EventHandler<RowEvent> removeRowHandler;
    private EventHandler<RowEvent> commentRowHandler;
    private HybridSpecification spec;
    private ObservableSet<String> definedVars;
    private ObservableList<Type> types;
    private ObservableMap<IOVariable, TableColumnController> columns;
    private DurationsColumnController durationColumn;
    /**
     * Listens on changed rows in Specification and adds cells or remove cells in durationColumn
     */
    private Consumer<SpecificationTable.RowChangeInfo<ConstraintCell, ConstraintDuration>> rowChangeInfoConsumer;

    public TablePaneController(HybridSpecification spec, ObservableSet<String> definedVars, ObservableList<Type> types, ObservableList<IOVariable> ioVars) {
    }

    public void addIOVariable(IOVariable ioVar) {
    }
}
