package edu.kit.iti.formal.stvs.view;

import edu.kit.iti.formal.stvs.view.editor.EditorPane;
import edu.kit.iti.formal.stvs.view.spec.SpecificationsPane;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;

/**
 * This view holds the editor and the specifications pane.
 *
 * @author Carsten Csiky
 */
public class StvsRootView extends VBox {
  private SplitPane globalPane;
  private EditorPane editor;
  private SpecificationsPane specifications;
  private SpecificationsPane specifications2;
  private ToolBar toolBar;
  //2. SpecView

  /**
   * This creates an instance that holds an editor and the specifications pane.
   *
   * @param editor Editor to display
   * @param specifications Pane to display
   */
  public StvsRootView(EditorPane editor, SpecificationsPane specifications, SpecificationsPane specifications2) {
    this.globalPane = new SplitPane();
    this.editor = editor;
    this.specifications = specifications;
    this.specifications2 = specifications2;
    Button concretize = new Button("Concretize");
    Button verify = new Button ("Verify");
    this.toolBar = new ToolBar(
            concretize,
            verify
    );



    //ViewUtils.setupClass(this);

    // for presentations
    //this.setStyle("-fx-font-size: 16pt");

    globalPane.getItems().addAll(editor, specifications, specifications2);
    this.getChildren().addAll(toolBar,globalPane);
  }

  public EditorPane getEditor() {
    return editor;
  }

  public SpecificationsPane getSpecifications() {
    return specifications;
  }

  public void setEditor(EditorPane editor) {
    this.editor = editor;
    globalPane.getItems().set(0, editor);
  }

  public void setSpecifications(SpecificationsPane specifications) {
    this.specifications = specifications;
  }
}
