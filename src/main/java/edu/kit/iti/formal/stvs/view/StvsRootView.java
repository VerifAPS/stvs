package edu.kit.iti.formal.stvs.view;

import edu.kit.iti.formal.stvs.view.editor.EditorPane;
import edu.kit.iti.formal.stvs.view.spec.SpecificationsPane;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.controlsfx.control.NotificationPane;
import org.controlsfx.control.action.Action;

/**
 * This view holds the editor and the specifications notificationPane.
 *
 * @author Carsten Csiky
 */
public class StvsRootView extends VBox {

    private EditorPane editor;
    private SpecificationsPane specifications;
    private SplitPane splitPane = new SplitPane();
    private NotificationPane notificationPane = new NotificationPane(splitPane);
    private HBox statusPane = new HBox();
    private Label lblStatus = new Label();

    /**
     * This creates an instance that holds an editor and the specifications notificationPane.
     *
     * @param editor         Editor to display
     * @param specifications Pane to display
     */
    public StvsRootView(EditorPane editor, SpecificationsPane specifications) {
        this.editor = editor;
        this.specifications = specifications;
        ViewUtils.setupId(this);

        // for presentations
        //this.setStyle("-fx-font-size: 16pt");
        notificationPane.setGraphic(new Label("blubb"));
        notificationPane.getActions().addAll(new Action("blubb"));
        notificationPane.setOnShown(System.out::print);

        splitPane.getItems().addAll(editor, specifications);
        getChildren().addAll(notificationPane, splitPane, statusPane);
        statusPane.getChildren().addAll(lblStatus);
    }

    public EditorPane getEditor() {
        return editor;
    }

    public SpecificationsPane getSpecifications() {
        return specifications;
    }

    public void setEditor(EditorPane editor) {
        this.editor = editor;
        splitPane.getItems().set(0, editor);
    }

    public void setSpecifications(SpecificationsPane specifications) {
        this.specifications = specifications;
        splitPane.getItems().set(1, specifications);
    }

    public NotificationPane getNotificationPane() {
        return notificationPane;
    }
}
