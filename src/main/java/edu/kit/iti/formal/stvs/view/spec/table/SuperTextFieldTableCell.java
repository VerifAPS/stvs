package edu.kit.iti.formal.stvs.view.spec.table;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.DefaultStringConverter;

/**
 * Created by Lukas on 04.07.2017.
 */
public class SuperTextFieldTableCell<S,T> extends TableCell<S,T>{



    //TextField is public now
    public TextField textField;


    public SuperTextFieldTableCell() {
        this.getStyleClass().add("text-field-table-cell");
        textField = new TextField();
        itemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                //setGraphic(null);
                textField.setText("hi");
            } else {
                textField.setText(newValue.toString());
            }
            setGraphic(textField);
        });
        indexProperty().addListener((observable, oldValue, newValue) -> {
            setGraphic(textField);
            //getTableView().refresh();
        });
        Platform.runLater(() -> {
            setGraphic(textField);
        });
    }

    /***************************************************************************
     *                                                                         *
     * Public API                                                              *
     *                                                                         *
     **************************************************************************/

    /** {@inheritDoc} */
    @Override public void startEdit() {
        if (! isEditable()
                || ! getTableView().isEditable()
                || ! getTableColumn().isEditable()) {
            return;
        }
        super.startEdit();

        if (isEditing()) {
            if (textField == null) {
                textField = new TextField();
            }
            this.setGraphic(textField);
        }
    }

    /** {@inheritDoc} */
    @Override public void cancelEdit() {
        super.cancelEdit();
        this.setGraphic(textField);
    }

    /** {@inheritDoc} */
    @Override public void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        if(empty) {
            this.setGraphic(null);
        }
        else {
            this.setGraphic(textField);
        }
    }

    @Override public void commitEdit(T newValue) {
        super.commitEdit(newValue);
        setGraphic(textField);
    }



}
