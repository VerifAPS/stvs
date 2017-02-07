package edu.kit.iti.formal.stvs.view.spec.table;

import edu.kit.iti.formal.stvs.logic.io.ExporterFacade;
import edu.kit.iti.formal.stvs.model.common.CodeIoVariable;
import edu.kit.iti.formal.stvs.model.common.FreeVariableSet;
import edu.kit.iti.formal.stvs.model.common.VariableCategory;
import edu.kit.iti.formal.stvs.model.expressions.Type;
import edu.kit.iti.formal.stvs.model.expressions.TypeBool;
import edu.kit.iti.formal.stvs.model.expressions.TypeInt;
import edu.kit.iti.formal.stvs.model.table.ConstraintSpecification;
import edu.kit.iti.formal.stvs.view.JavaFxTest;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableMap;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Philipp on 01.02.2017.
 */
public class SpecificationTableTest {

  @Test
  public void testTable() {
    JavaFxTest.runSplitView(this::simpleTableScene);
  }

  private List<Node> simpleTableScene() {
    List<Type> types = Arrays.asList(TypeInt.INT, TypeBool.BOOL);
    List<CodeIoVariable> codeIoVariables = Arrays.asList(
        new CodeIoVariable(VariableCategory.INPUT, TypeBool.BOOL, "InputA"),
        new CodeIoVariable(VariableCategory.INPUT, TypeInt.INT, "InputB"),
        new CodeIoVariable(VariableCategory.OUTPUT, TypeInt.INT, "OutputA")
    );
    SpecificationTableController table = new SpecificationTableController(
        new SimpleObjectProperty<>(types),
        new SimpleObjectProperty<>(codeIoVariables),
        new FreeVariableSet());

    Pane extractedTablePane = createExtractedTableTextArea(table.getHybridSpecification());

    return Arrays.asList(table.getView(), extractedTablePane);
  }

  private Pane createExtractedTableTextArea(ConstraintSpecification spec) {
    final TextArea textArea = new TextArea();
    textArea.getStyleClass().addAll("model-text-area");
    textArea.setEditable(false);
    VBox.setVgrow(textArea, Priority.ALWAYS);

    updateText(textArea, spec);

    final Button updateButton = new Button("Refresh");
    updateButton.setOnAction(event -> updateText(textArea, spec));

    return new VBox(updateButton, textArea);
  }

  private void updateText(TextArea textArea, ConstraintSpecification spec) {
    try {
      ByteArrayOutputStream stream = ExporterFacade.exportSpec(spec, ExporterFacade.ExportFormat.XML);
      String output = IOUtils.toString(stream.toByteArray(), "UTF-8");
      textArea.setText(output);
    } catch (Exception e) {
      StringWriter writeString = new StringWriter();
      e.printStackTrace(new PrintWriter(writeString));
      e.printStackTrace();
      textArea.setText(writeString.toString());
    }
  }
}