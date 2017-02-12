package edu.kit.iti.formal.stvs.view.spec.timingdiagram.renderer;

import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

/**
 * Created by leonk on 09.02.2017.
 */
public class VerticalResizeContainerView extends AnchorPane {
  private VBox container = new VBox();
  private AnchorPane content = new AnchorPane();
  private VBox contentContainer = new VBox();
  private Rectangle dragLine = new Rectangle(10, 5, Color.BEIGE);

  public VerticalResizeContainerView() {
    this.getChildren().add(container);
    container.getChildren().addAll(contentContainer);
    contentContainer.getChildren().addAll(content, dragLine);
    AnchorPane.setLeftAnchor(container, 0.0);
    AnchorPane.setRightAnchor(container, 0.0);
    AnchorPane.setTopAnchor(container, 0.0);
    dragLine.widthProperty().bind(container.widthProperty());
    //AnchorPane.setBottomAnchor(dragLine, 0.0);
    this.getStylesheets().add(
        TimingDiagramView.class.getResource("resizeContainer.css").toExternalForm()
    );
    this.getStyleClass().add("resizeContainer");
    dragLine.getStyleClass().add("dragLine");
  }

  public VBox getContainer() {
    return container;
  }

  public AnchorPane getContent() {
    return content;
  }

  public VBox getContentContainer() {
    return contentContainer;
  }

  public Rectangle getDragLine() {
    return dragLine;
  }
}