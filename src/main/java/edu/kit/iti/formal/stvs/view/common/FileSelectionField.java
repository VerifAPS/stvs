package edu.kit.iti.formal.stvs.view.common;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import edu.kit.iti.formal.stvs.view.ViewUtils;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;

import java.io.File;

/**
 * A text field with a button for choosing a file and displaying their path.
 *
 * @author Benjamin Alt
 */
public class FileSelectionField extends HBox {
  private TextField textField;

  public FileSelectionField() {
    super();
    setSpacing(10);
    ViewUtils.setupId(this);
    textField = new TextField();
    Button fileSelectButton = GlyphsDude.createIconButton(FontAwesomeIcon.FOLDER_OPEN);
    getChildren().add(textField);
    getChildren().add(fileSelectButton);
    fileSelectButton.setOnAction(this::onFileSelectButtonClicked);

  }

  private void onFileSelectButtonClicked(ActionEvent actionEvent) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Select Executable");
    File selectedFile = fileChooser.showOpenDialog(this.getScene().getWindow());
    if (selectedFile != null) {
      textField.setText(selectedFile.getAbsolutePath());
    }
  }

  public TextField getTextField() {
    return textField;
  }
}
