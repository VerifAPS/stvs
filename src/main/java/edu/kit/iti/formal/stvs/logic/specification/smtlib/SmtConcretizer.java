package edu.kit.iti.formal.stvs.logic.specification.smtlib;

import edu.kit.iti.formal.stvs.logic.specification.SpecificationConcretizer;
import edu.kit.iti.formal.stvs.model.common.ValidFreeVariable;
import edu.kit.iti.formal.stvs.model.config.GlobalConfig;
import edu.kit.iti.formal.stvs.model.table.ConcreteSpecification;
import edu.kit.iti.formal.stvs.model.table.ValidSpecification;
import edu.kit.iti.formal.stvs.util.ProcessOutputAsyncTask;
import edu.kit.iti.formal.stvs.util.ThrowableHandler;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Created by csicar on 08.02.17.
 * @author Leon Kaucher
 */
public class SmtConcretizer implements SpecificationConcretizer {
  private final GlobalConfig config;
  private ProcessOutputAsyncTask task;
  private Z3Solver z3Solver;

  public SmtConcretizer(GlobalConfig config) {
    this.config = config;
    this.z3Solver = new Z3Solver(config);
  }

  @Override
  public void calculateConcreteSpecification(ValidSpecification validSpecification,
                                             List<ValidFreeVariable> freeVariables,
                                             OptionalConcreteSpecificationHandler consumer,
                                             ThrowableHandler exceptionHandler) {
    SmtEncoder encoder = new SmtEncoder(config.getMaxLineRollout(), validSpecification,
        freeVariables);
    this.task = z3Solver.concretizeSConstraint(encoder.getConstrain(), validSpecification.getColumnHeaders(), consumer);
    Thread.UncaughtExceptionHandler handler = (t, exception) -> exceptionHandler.handleThrowable(exception);
    this.task.setUncaughtExceptionHandler(handler);
    this.task.start();
  }

  public void terminate() {
    if (task != null) {
      task.terminate();
    }
  }
}
