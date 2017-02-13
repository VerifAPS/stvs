package edu.kit.iti.formal.stvs.view;

import edu.kit.iti.formal.stvs.model.StvsRootModel;
import edu.kit.iti.formal.stvs.view.menu.StvsMenuBarController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * Created by csicar on 09.01.17.
 */
public class StvsMainScene {

  private StvsMenuBarController menuBarController;
  private StvsRootController rootController;
  private ObjectProperty<StvsRootModel> rootModelProperty;
  private ContextMenu contextMenu;
  private final Scene scene;

  public StvsMainScene() {
    this(new StvsRootModel());
  }

  public StvsMainScene(StvsRootModel rootModel) {
    this.rootModelProperty = new SimpleObjectProperty<>(rootModel);
    this.rootController = new StvsRootController(rootModelProperty.get());
    this.menuBarController = new StvsMenuBarController(rootModelProperty);
    rootModelProperty.addListener(this::rootModelChanged);

    this.scene = new Scene(createVBox(), rootModel.getGlobalConfig().getWindowWidth(), rootModel.getGlobalConfig().getWindowHeight());
  }

  private VBox createVBox() {
    VBox vBox = new VBox();
    vBox.getChildren().addAll(menuBarController.getView(), rootController.getView());
    VBox.setVgrow(rootController.getView(), Priority.ALWAYS);

    return vBox;
  }

  private void rootModelChanged(
      ObservableValue<? extends StvsRootModel> obs,
      StvsRootModel oldModel,
      StvsRootModel rootModel) {
    this.rootController = new StvsRootController(rootModel);
    scene.setRoot(createVBox());
  }

  public StvsRootController getRootController() {
    return rootController;
  }

  public void setRootController(StvsRootController rootController) {
    this.rootController = rootController;
  }

  public Scene getScene() {
    return scene;
  }
}
