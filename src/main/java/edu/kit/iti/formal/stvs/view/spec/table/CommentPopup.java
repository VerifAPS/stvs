package edu.kit.iti.formal.stvs.view.spec.table;

import edu.kit.iti.formal.stvs.model.table.Commentable;
import edu.kit.iti.formal.stvs.view.spec.Lockable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import org.controlsfx.control.PopOver;

/**
 * <p>
 * The popup dialog for editing comments on table cells, rows or tables as a whole.
 * </p>
 *
 * @author Carsten Csiky
 */
public class CommentPopup extends PopOver implements Lockable {
    private TextArea commentField;
    private final BooleanProperty editable;

    /**
     * <p>
     * Creates a javafx dialog with a text area for a comment that can be edited, if this class has
     * not been locked (see {@link Lockable}).
     * </p>
     *
     * @param commentContent the initial comment content of the dialog.
     */
    public CommentPopup(String commentContent) {
        super();
        this.setTitle("Edit Comment");
        //this.setContentText("Comment");
        this.commentField = new TextArea(commentContent);
        editable = new SimpleBooleanProperty();
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        //grid.setPadding(new Insets(20, 150, 10, 10));
        grid.add(commentField, 0, 0);
        commentField.setOnKeyPressed((KeyEvent event) -> {
            if (event.isShiftDown() && event.getCode() == KeyCode.ENTER) {
                //setResult(commentField.getText());
                hide();
            }

            if (event.getCode() == KeyCode.ESCAPE) {
                //setResult(commentContent);
                hide();
            }
        });

        //this.getDialogPane().getButtonTypes().addAll(ButtonType.APPLY, ButtonType.CANCEL);
        getRoot().getChildren().addAll(grid);
        getRoot().setId("CommentPopupPane");
    }

    public TextArea getCommentField() {
        return commentField;
    }

    @Override public boolean getEditable() {
        return editable.get();
    }

    @Override public void setEditable(boolean editable) {
        this.editable.set(editable);
    }

    @Override public BooleanProperty getEditableProperty() {
        return editable;
    }

    public static void show(Node source, Commentable commentable,
            boolean editable, double x, double y) {
        CommentPopup popup = new CommentPopup(commentable.getComment());
        popup.setArrowLocation(ArrowLocation.BOTTOM_CENTER);
        popup.setEditable(editable);
        popup.show(source, x, y);
    }
}
