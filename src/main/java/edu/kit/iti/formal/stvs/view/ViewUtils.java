package edu.kit.iti.formal.stvs.view;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Transform;

/**
 * Created by leonk on 05.02.2017.
 */
public class ViewUtils {
  /**
   * @param rootOfCalculation Any node in a scene graph
   * @param child A direct/indirect child of rootOfCalculation
   * @return A Transformation between coordinates of child and rootOfCalculation
   */
  public static Transform calculateTransformRelativeTo(Node rootOfCalculation, Node child){
    if(child.getScene() == null){
      throw new IllegalStateException("Child is not displayed in any scene currently.");
    }
    if(child.getParent() == null){
      throw new IllegalStateException("rootOfCalculation is not in the scenegraph between root node and child.");
    }
    if(child == rootOfCalculation) return new Affine();
    Transform parentTransform = calculateTransformRelativeTo(rootOfCalculation, child.getParent());
    return child.getLocalToParentTransform().createConcatenation(parentTransform);
  }


 
}