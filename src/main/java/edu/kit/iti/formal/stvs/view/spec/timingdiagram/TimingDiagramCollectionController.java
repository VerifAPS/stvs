package edu.kit.iti.formal.stvs.view.spec.timingdiagram;

import edu.kit.iti.formal.stvs.ViewUtils;
import edu.kit.iti.formal.stvs.model.common.Selection;
import edu.kit.iti.formal.stvs.model.common.SpecIoVariable;
import edu.kit.iti.formal.stvs.model.common.ValidIoVariable;
import edu.kit.iti.formal.stvs.model.config.GlobalConfig;
import edu.kit.iti.formal.stvs.model.expressions.TypeEnum;
import edu.kit.iti.formal.stvs.model.expressions.ValueEnum;
import edu.kit.iti.formal.stvs.model.table.ConcreteSpecification;
import edu.kit.iti.formal.stvs.model.table.HybridSpecification;
import edu.kit.iti.formal.stvs.view.Controller;
import edu.kit.iti.formal.stvs.view.spec.timingdiagram.renderer.TimingDiagramController;
import edu.kit.iti.formal.stvs.view.spec.timingdiagram.renderer.TimingDiagramView;
import edu.kit.iti.formal.stvs.view.spec.timingdiagram.renderer.VerticalResizeContainerController;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.geometry.Side;
import javafx.scene.chart.Axis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.ScrollBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.transform.Transform;
import javafx.util.Pair;

/**
 * Created by csicar on 09.01.17.
 * creates TimingDiagramCollectionView
 * gets created by SpecificationTabController; is toplevel class for timingdiagram-package
 */
public class TimingDiagramCollectionController implements Controller {
  private final int totalCycleCount;
  private HybridSpecification spec;
  private GlobalConfig globalConfig;
  private ObservableList<SpecIoVariable> definedVariables;
  private TimingDiagramCollectionView view;
  private Selection selection;
  private DoubleProperty visibleRange = new SimpleDoubleProperty();

  private double startXPosition;
  private double startLowerBound;
  private double startUpperBound;
  private double screenDistanceToAxisRatio;

  /**
   * creates VariableTimingDiagram for each given Variable
   */
  /*public TimingDiagramCollectionController(HybridSpecification spec, ObservableList<SpecIoVariable> definedVariables, GlobalConfig globalConfig) {

    this.globalConfig = globalConfig;
  }*/
  public TimingDiagramCollectionController(ConcreteSpecification concreteSpec, Selection selection) {
    this.selection = selection;
    this.totalCycleCount = concreteSpec.getRows().size();
    view = new TimingDiagramCollectionView();
    view.onMouseDraggedProperty().setValue(this::mouseDraggedHandler);
    view.onMousePressedProperty().setValue(this::mousePressedHandler);
    concreteSpec.getColumnHeaders().forEach(validIoVariable -> {
      Pair<TimingDiagramController, Axis> diagramAxisPair = validIoVariable.getValidType().match(
          () -> addIntegerTimingDiagram(concreteSpec, validIoVariable),
          () -> addBoolTimingDiagram(concreteSpec, validIoVariable),
          (e) -> addEnumTimingDiagram(concreteSpec, validIoVariable, e)
      );
      TimingDiagramView timingDiagramView = diagramAxisPair.getKey().getView();
      Axis externalYAxis = diagramAxisPair.getValue();
      VerticalResizeContainerController verticalResizeContainerController = new VerticalResizeContainerController(timingDiagramView);

      this.view.getDiagramContainer().getChildren().add(verticalResizeContainerController.getView());
      this.view.getyAxisContainer().getChildren().add(externalYAxis);
      timingDiagramView.getyAxis().layoutBoundsProperty().addListener(
          change -> updateAxisExternalPosition(timingDiagramView, externalYAxis)
      );
      verticalResizeContainerController.getView().layoutYProperty().addListener(
          change -> updateAxisExternalPosition(timingDiagramView, externalYAxis)
      );
      AnchorPane.setRightAnchor(diagramAxisPair.getValue(), 0.0);

      Text label = new Text(validIoVariable.getName());
      this.view.getLabelContainer().getChildren().add(label);
      label.yProperty().bind(
          diagramAxisPair.getValue().layoutYProperty().add(
              diagramAxisPair.getValue().heightProperty().divide(2)
          )
      );
    });
    initxScrollbar();

  }

  private void initxScrollbar() {
    ScrollBar scrollBar = view.getxScrollBar();
    NumberAxis globalxAxis = view.getxAxis();
    scrollBar.setMin(0);
    visibleRange.bind(globalxAxis.upperBoundProperty()
        .subtract(globalxAxis.lowerBoundProperty()));
    scrollBar.maxProperty().bind(visibleRange.multiply(-1).add(totalCycleCount));

    globalxAxis.lowerBoundProperty().addListener(change -> {
      scrollBar.setValue(globalxAxis.getLowerBound());
    });

    scrollBar.valueProperty().addListener(change -> {
      globalxAxis.setUpperBound(scrollBar.getValue() + visibleRange.get());
      globalxAxis.setLowerBound(scrollBar.getValue());
    });
  }

  private void updateAxisExternalPosition(TimingDiagramView timingDiagramView, Axis externalYAxis) {
    Transform transformation = ViewUtils.calculateTransformRelativeTo(view.getDiagramContainer(), timingDiagramView.getyAxis());
    double yAxisPosition = transformation.transform(timingDiagramView.getyAxis().getLayoutBounds()).getMinY();
    externalYAxis.layoutYProperty().set(yAxisPosition);
  }

  private javafx.util.Pair<TimingDiagramController, Axis> addIntegerTimingDiagram(ConcreteSpecification concreteSpec, ValidIoVariable specIoVar) {
    NumberAxis yAxis = new NumberAxis(0, 10, 1);
    yAxis.setPrefWidth(30);
    yAxis.setSide(Side.LEFT);
    TimingDiagramController timingDiagramController = new TimingDiagramController(view.getxAxis(), yAxis, concreteSpec, specIoVar, selection);
    return new javafx.util.Pair<>(timingDiagramController, yAxis);
  }

  private javafx.util.Pair<TimingDiagramController, Axis> addBoolTimingDiagram(ConcreteSpecification concreteSpec, ValidIoVariable specIoVar) {
    ObservableList<String> categories = FXCollections.observableArrayList();
    categories.addAll("FALSE", "TRUE");
    CategoryAxis boolCategoryAxis = new CategoryAxis(categories);
    boolCategoryAxis.setPrefWidth(30);
    boolCategoryAxis.setSide(Side.LEFT);
    boolCategoryAxis.setAutoRanging(true);
    TimingDiagramController timingDiagramController = new TimingDiagramController(view.getxAxis(), boolCategoryAxis, concreteSpec, specIoVar, selection);
    return new javafx.util.Pair<>(timingDiagramController, boolCategoryAxis);
  }

  private Pair<TimingDiagramController, Axis> addEnumTimingDiagram(ConcreteSpecification concreteSpec, ValidIoVariable specIoVar, TypeEnum typeEnum) {
    ObservableList<String> categories = FXCollections.observableArrayList();
    typeEnum.getValues().stream()
        .map(ValueEnum::getEnumValue)
        .forEach(categories::add);
    CategoryAxis categoryAxis = new CategoryAxis(categories);
    categoryAxis.setSide(Side.LEFT);
    categoryAxis.setPrefWidth(30);
    categoryAxis.setAutoRanging(true);
    TimingDiagramController timingDiagramController = new TimingDiagramController(view.getxAxis(), categoryAxis, concreteSpec, specIoVar, selection);
    return new javafx.util.Pair<>(timingDiagramController, categoryAxis);
  }

  private void mouseDraggedHandler(MouseEvent event) {
    Point2D point2D = getView().sceneToLocal(event.getSceneX(), event.getScreenY());
    double newXPosition = point2D.getX();
    double delta = newXPosition - startXPosition;
    double deltaAsAxis = delta * screenDistanceToAxisRatio;
    if (startLowerBound - deltaAsAxis < 0) {
      deltaAsAxis = startLowerBound;
    }
    getView().getxAxis().setLowerBound(Math.min(startLowerBound - deltaAsAxis, totalCycleCount - visibleRange.get()));
    getView().getxAxis().setUpperBound(Math.min(startUpperBound - deltaAsAxis, totalCycleCount));
    //System.out.println(point2D);
  }

  private void mousePressedHandler(MouseEvent event) {
    Point2D point2D = getView().sceneToLocal(event.getSceneX(), event.getScreenY());
    double displayForAxis = getView().getxAxis().getValueForDisplay(point2D.getX()).doubleValue();
    double displayForAxisPlus100 = getView().getxAxis().getValueForDisplay(point2D.getX() + 100).doubleValue();
    screenDistanceToAxisRatio = (displayForAxisPlus100 - displayForAxis) / 100;
    startXPosition = point2D.getX();
    startLowerBound = getView().getxAxis().getLowerBound();
    startUpperBound = getView().getxAxis().getUpperBound();
    System.out.println(point2D);
  }

  public TimingDiagramCollectionView getView() {
    return view;
  }

}
