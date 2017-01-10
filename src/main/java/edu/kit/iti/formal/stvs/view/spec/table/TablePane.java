package edu.kit.iti.formal.stvs.view.spec.table;

import edu.kit.iti.formal.stvs.view.spec.table.rowActions.AddButtonColumn;
import edu.kit.iti.formal.stvs.view.spec.table.rowActions.CommentButtonColumn;
import edu.kit.iti.formal.stvs.view.spec.table.rowActions.RemoveButtonColumn;
import javafx.beans.property.BooleanProperty;
import javafx.scene.layout.HBox;

public class TablePane extends HBox {
    private CategoryTable inputTable;
    private CategoryTable outputTable;
    private DurationsColumn durations;
    private AddButtonColumn addButtons;
    private RemoveButtonColumn removeButtonColumn;
    private CommentButtonColumn commentButtonColumn;

    public CategoryTable getInputTable() {
        return inputTable;
    }

    public void setInputTable(CategoryTable inputTable) {
        this.inputTable = inputTable;
    }

    public CategoryTable getOutputTable() {
        return outputTable;
    }

    public void setOutputTable(CategoryTable outputTable) {
        this.outputTable = outputTable;
    }

    public DurationsColumn getDurations() {
        return durations;
    }

    public void setDurations(DurationsColumn durations) {
        this.durations = durations;
    }

    public AddButtonColumn getAddButtons() {
        return addButtons;
    }

    public void setAddButtons(AddButtonColumn addButtons) {
        this.addButtons = addButtons;
    }

    public RemoveButtonColumn getRemoveButtonColumn() {
        return removeButtonColumn;
    }

    public void setRemoveButtonColumn(RemoveButtonColumn removeButtonColumn) {
        this.removeButtonColumn = removeButtonColumn;
    }

    public CommentButtonColumn getCommentButtonColumn() {
        return commentButtonColumn;
    }

    public void setCommentButtonColumn(CommentButtonColumn commentButtonColumn) {
        this.commentButtonColumn = commentButtonColumn;
    }

    public boolean isEditableProperty() {
        return editableProperty.get();
    }

    public BooleanProperty editablePropertyProperty() {
        return editableProperty;
    }

    public void setEditableProperty(boolean editableProperty) {
        this.editableProperty.set(editableProperty);
    }

    private BooleanProperty editableProperty;

    public BooleanProperty getEditableProperty() {
        return editableProperty;
    }

    public void setEditable(boolean b) {

    }

    public boolean getEditable() {
        return editableProperty.get();
    }
}
