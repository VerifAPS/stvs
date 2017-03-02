package edu.kit.iti.formal.stvs.view.spec;

import edu.kit.iti.formal.stvs.logic.specification.ConcretizationException;
import edu.kit.iti.formal.stvs.logic.specification.smtlib.SmtConcretizer;
import edu.kit.iti.formal.stvs.model.common.CodeIoVariable;
import edu.kit.iti.formal.stvs.model.common.Selection;
import edu.kit.iti.formal.stvs.model.config.GlobalConfig;
import edu.kit.iti.formal.stvs.model.expressions.Type;
import edu.kit.iti.formal.stvs.model.table.ConcreteSpecification;
import edu.kit.iti.formal.stvs.model.table.HybridSpecification;
import edu.kit.iti.formal.stvs.model.verification.VerificationState;
import edu.kit.iti.formal.stvs.util.AsyncTaskCompletedHandler;
import edu.kit.iti.formal.stvs.util.JavaFxAsyncTask;
import edu.kit.iti.formal.stvs.view.Controller;
import edu.kit.iti.formal.stvs.view.common.AlertFactory;
import edu.kit.iti.formal.stvs.view.spec.table.SpecificationTableController;
import edu.kit.iti.formal.stvs.view.spec.timingdiagram.TimingDiagramCollectionController;
import edu.kit.iti.formal.stvs.view.spec.variables.VariableCollectionController;

import java.util.List;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;

/**
 * @author Carsten Csiky
 */
public class SpecificationController implements Controller {

  private final GlobalConfig globalConfig;

  private HybridSpecification spec;

  private ObjectProperty<VerificationState> stateProperty;
  private ContextMenu contextMenu;
  private SpecificationView view;
  private VariableCollectionController variableCollectionController;
  private SpecificationTableController tableController;
  private TimingDiagramCollectionController timingDiagramCollectionController;
  private Selection selection;
  private HybridSpecification hybridSpecification;
  private BooleanProperty specificationInvalid;
  private JavaFxAsyncTask<ConcreteSpecification> concretizingTask;
  private final ConcretizationTaskHandler concretizationHandler;

  public SpecificationController(ObjectProperty<List<Type>> typeContext,
      ObjectProperty<List<CodeIoVariable>> codeIoVariables, HybridSpecification hybridSpecification,
      ObjectProperty<VerificationState> stateProperty, BooleanBinding codeInvalid,
      GlobalConfig globalConfig) {
    this.spec = hybridSpecification;
    this.hybridSpecification = hybridSpecification;
    this.stateProperty = stateProperty;
    this.stateProperty.addListener(this::onVerificationStateChanged);
    this.view = new SpecificationView();
    this.selection = hybridSpecification.getSelection();
    this.globalConfig = globalConfig;
    this.variableCollectionController =
        new VariableCollectionController(typeContext, hybridSpecification.getFreeVariableList());
    this.tableController = new SpecificationTableController(globalConfig, typeContext,
        codeIoVariables, variableCollectionController.getValidator().validFreeVariablesProperty(),
        hybridSpecification);
    this.specificationInvalid = new SimpleBooleanProperty(true);
    specificationInvalid.bind(variableCollectionController.getValidator().validProperty().not()
        .or(tableController.getValidator().validProperty().not()).or(codeInvalid));
    this.concretizationHandler = new ConcretizationTaskHandler();

    // use event trigger to generate timing-diagram, to minimize code-duplication
    onConcreteInstanceChanged(getConcreteSpecification());

    view.setVariableCollection(variableCollectionController.getView());
    view.getVariableCollection().getFreeVariableTableView()
        .setEditable(this.hybridSpecification.isEditable());
    List<MenuItem> freeVarMenuItems =
        view.getVariableCollection().getFreeVariableTableView().getContextMenu().getItems();
    for (MenuItem menuItem : freeVarMenuItems) {
      menuItem.setDisable(!this.hybridSpecification.isEditable());
    }
    view.setTable(tableController.getView());
    view.getStartButton().setOnAction(this::onVerificationButtonClicked);
    view.getStartButton().disableProperty().bind(specificationInvalid);
    view.getStartConcretizerButton().disableProperty().bind(specificationInvalid);

    view.getStartConcretizerButton().setOnAction(this::startConcretizer);

    hybridSpecification.concreteInstanceProperty()
        .addListener((observable, old, newVal) -> this.onConcreteInstanceChanged(newVal));
    registerTimingDiagramDeactivationHandler();
  }

  private void onVerificationStateChanged(
      ObservableValue<? extends VerificationState> observableValue, VerificationState oldState,
      VerificationState newState) {
    switch (newState) {
      case RUNNING:
        getView().setVerificationButtonStop();
        break;
      default:
        getView().setVerificationButtonPlay();
    }
  }

  private void registerTimingDiagramDeactivationHandler() {
    hybridSpecification.getDurations().addListener(this::specChanged);
    hybridSpecification.getColumnHeaders().addListener(this::specChanged);
    hybridSpecification.getRows().addListener(this::specChanged);
    hybridSpecification.getFreeVariableList().getVariables().addListener(this::specChanged);
    hybridSpecification.setConcreteInstance(null);
  }

  private void specChanged(ListChangeListener.Change change) {
    if (timingDiagramCollectionController != null) {
      timingDiagramCollectionController.setActivated(false);
    }
  }

  private void onConcreteInstanceChanged(ConcreteSpecification newVal) {
    if (getConcreteSpecification() == null) {
      view.setEmptyDiagram();
    } else {
      this.timingDiagramCollectionController =
          new TimingDiagramCollectionController(getConcreteSpecification(), selection);
      view.setDiagram(timingDiagramCollectionController.getView());

    }
  }

  private void onConcretizationActive() {
    view.setConcretizerButtonStop();
    view.getStartConcretizerButton().setOnAction(this::stopConcretizer);
  }

  private void onConcretizationInactive() {
    view.setConcretizerButtonStart();
    view.getStartConcretizerButton().setOnAction(this::startConcretizer);
  }

  private void startConcretizer(ActionEvent actionEvent) {
    this.concretizingTask = new JavaFxAsyncTask<>(
        this::runConcretizationSynchronously, this.concretizationHandler);
    concretizingTask.start();

    onConcretizationActive();
  }

  private ConcreteSpecification runConcretizationSynchronously()
      throws ConcretizationException {
    return new SmtConcretizer(globalConfig).calculateConcreteSpecification(
        tableController.getValidator().getValidSpecification(),
        variableCollectionController.getValidator().getValidFreeVariables());
  }

  private void stopConcretizer(ActionEvent actionEvent) {
    if (concretizingTask != null) {
      concretizingTask.terminate();
      concretizingTask = null;
    }
    onConcretizationInactive();
  }

  private ConcreteSpecification getConcreteSpecification() {
    return hybridSpecification.getCounterExample()
        .orElse(hybridSpecification.getConcreteInstance().orElse(null));
  }

  public SpecificationView getView() {
    return view;
  }

  private void onVerificationButtonClicked(ActionEvent actionEvent) {
    switch (stateProperty.get()) {
      case RUNNING:
        view.onVerificationButtonClicked(hybridSpecification, VerificationEvent.Type.STOP);
        break;
      default:
        view.onVerificationButtonClicked(hybridSpecification, VerificationEvent.Type.START);
    }
  }

  public HybridSpecification getSpec() {
    return spec;
  }

  private class ConcretizationTaskHandler implements AsyncTaskCompletedHandler<ConcreteSpecification> {
    @Override
    public void onSuccess(ConcreteSpecification concreteSpec) {
      hybridSpecification.setConcreteInstance(concreteSpec);
      timingDiagramCollectionController.setActivated(true);
      onConcretizationInactive();
    }

    @Override
    public void onException(Exception exception) {
      AlertFactory.createAlert(exception);
      onConcretizationInactive();
    }
  }
}
