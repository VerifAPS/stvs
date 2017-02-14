package edu.kit.iti.formal.stvs.view.editor;

import edu.kit.iti.formal.stvs.model.code.SyntaxError;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.richtext.StyleSpans;

import java.util.Collection;

/**
 * Created by csicar on 09.01.17.
 */
public class EditorPane extends SplitPane {

  /**
   * Contains ButtonList and CodeArea
   */
  private CodeArea codeArea;
  private ListView<SyntaxError> syntaxErrorListView;

  private Pane syntaxErrorPane;

  public EditorPane(String code, ObservableList<SyntaxError> syntaxErrors) {
    this(code, syntaxErrors, true);
  }

  public EditorPane(String code, ObservableList<SyntaxError> syntaxErrors, boolean
      showLineNumbers) {
    super();
    this.getStylesheets().add(EditorPane.class.getResource("style.css").toExternalForm());

    codeArea = new CodeArea(code);
    System.out.println("Setting line numbers to " + showLineNumbers);
    if (showLineNumbers) {
      codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
    }
    syntaxErrorListView = new ListView<>(syntaxErrors);
    syntaxErrorListView.getStyleClass().addAll("model-text-area");
    syntaxErrorPane  = new AnchorPane(syntaxErrorListView);
    AnchorPane.setBottomAnchor(syntaxErrorListView, 0.0);
    AnchorPane.setTopAnchor(syntaxErrorListView, 0.0);
    AnchorPane.setLeftAnchor(syntaxErrorListView, 0.0);
    AnchorPane.setRightAnchor(syntaxErrorListView, 0.0);
    this.getItems().addAll(codeArea, syntaxErrorPane);
    this.setOrientation(Orientation.VERTICAL);
    this.setDividerPositions(0.8);
  }

  public ListView<SyntaxError> getSyntaxErrorListView() {
    return syntaxErrorListView;
  }

  public Pane getSyntaxErrorPane() {
    return syntaxErrorPane;
  }

  public StringProperty getCodeProperty() {
    return null;
  }

  public String getCode() {
    return this.codeArea.getText();
  }

  public void setCode(String code) {
    codeArea = new CodeArea(code);
  }

  public void setStyleSpans(StyleSpans<Collection<String>> style) {
    codeArea.setStyleSpans(0, style);
  }

  public CodeArea getCodeArea() {
    return codeArea;
  }

  public void setShowLineNumbers(Boolean showLineNumbers) {
    if (showLineNumbers) {
      codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
    } else {
      codeArea.setParagraphGraphicFactory(null);
    }
  }
}
