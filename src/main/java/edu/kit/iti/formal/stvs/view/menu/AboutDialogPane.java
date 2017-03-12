package edu.kit.iti.formal.stvs.view.menu;

import edu.kit.iti.formal.stvs.StvsApplication;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * <p>
 * The Dialog Pane that shows 'About' information.
 * </p>
 *
 * <p>
 * Is created when the user clicks on 'Help' -> 'About' and shows the name and version information,
 * etc.
 * </p>
 *
 * <p>
 * Created by csicar on 16.02.17.
 * </p>
 *
 * @author Carsten Csiky
 */
public class AboutDialogPane extends DialogPane {

  private VBox content;

  /**
   * Creates the Dialog Pane that displays 'About' information.
   */
  public AboutDialogPane() {

    Image logo = new Image(StvsApplication.class.getResourceAsStream("logo.png"));
    this.content = new VBox(
        new ImageView(logo),
        new Label("Structured Text Verification Studio - STVS"),
        new Label("Version: 1.0.1"));
    this.setContent(content);
    this.getButtonTypes().addAll(ButtonType.CLOSE);
    this.getContent().setId("AboutDialogPane");
  }
}
