package edu.kit.iti.formal.stvs.view.spec.timingdiagram.renderer;

import edu.kit.iti.formal.stvs.view.JavaFxTest;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.Pane;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by leonk on 02.02.2017.
 */
public class TimingDiagramViewTest {
  @Ignore
  @Test
  public void javaFxTest() {
    JavaFxTest.runView(this::simpleScene);
  }

  private Scene simpleScene() {
    /*TimingDiagramController controller = new TimingDiagramController(new NumberAxis(),new NumberAxis());
    Pane pane = new Pane();
    pane.getChildren().add(controller.getView());
    Scene scene = new Scene(pane, 800, 600);
    //scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
    return scene;*/
    return null;
  }
}