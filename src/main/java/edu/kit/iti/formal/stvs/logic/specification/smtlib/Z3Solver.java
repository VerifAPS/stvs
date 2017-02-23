package edu.kit.iti.formal.stvs.logic.specification.smtlib;

import de.tudresden.inf.lat.jsexp.Sexp;
import edu.kit.iti.formal.stvs.model.common.ValidIoVariable;
import edu.kit.iti.formal.stvs.model.config.GlobalConfig;
import edu.kit.iti.formal.stvs.model.expressions.Type;
import edu.kit.iti.formal.stvs.model.expressions.Value;
import edu.kit.iti.formal.stvs.model.expressions.ValueBool;
import edu.kit.iti.formal.stvs.model.expressions.ValueInt;
import edu.kit.iti.formal.stvs.model.table.ConcreteCell;
import edu.kit.iti.formal.stvs.model.table.ConcreteDuration;
import edu.kit.iti.formal.stvs.model.table.ConcreteSpecification;
import edu.kit.iti.formal.stvs.model.table.SpecificationRow;
import edu.kit.iti.formal.stvs.util.ProcessOutputAsyncTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by leonk on 09.02.2017.
 * @author Leon Kaucher
 */
public class Z3Solver {

  private final int timeout;
  private String z3Path;

  public Z3Solver(GlobalConfig config) {
    this.z3Path = config.getZ3Path();
    this.timeout = config.getSimulationTimeout();
  }

  public String getZ3Path() {
    return z3Path;
  }

  public void setZ3Path(String z3Path) {
    this.z3Path = z3Path;
  }

  private ProcessOutputAsyncTask concretize(String smtString, Consumer<Optional<String>> handler) {
    ProcessBuilder processBuilder = new ProcessBuilder(z3Path, "-in", "-smt2", "-T:" + timeout);
    return new ProcessOutputAsyncTask(processBuilder, smtString, handler);
  }

  private ProcessOutputAsyncTask concretizeSExpr(String smtString, Consumer<Optional<SExpr>> handler) {
    return concretize(smtString, stringOptional -> handler.accept(optionalSolverOutputToSexp(stringOptional)));
  }

  private ProcessOutputAsyncTask concretizeSmtString(String smtString, List<ValidIoVariable> validIoVariables,
                                                     OptionalConcreteSpecificationHandler handler) {
    return concretizeSExpr(smtString, sexpOptional ->
        handler.accept(optionalSpecFromOptionalSExp(validIoVariables, sexpOptional)));
  }

  public ProcessOutputAsyncTask concretizeSConstraint(SConstraint sConstraint,
                                                      List<ValidIoVariable> validIoVariables,
                                                      OptionalConcreteSpecificationHandler handler) {
    String constraintString = sConstraint.globalConstraintsToText();
    String headerString = sConstraint.headerToText();
    String commands = "(check-sat)\n(get-model)";
    String z3Input = headerString + "\n" + constraintString + "\n" + commands;
    return concretizeSmtString(z3Input, validIoVariables, handler);
  }

  private Optional<SExpr> optionalSolverOutputToSexp(Optional<String> stringOptional) {
    if (stringOptional.isPresent() && stringOptional.get().startsWith("sat")) {
      String output = stringOptional.get();
      output = output.substring(output.indexOf('\n') + 1);
       return (Optional.of(SExpr.fromString(output)));
    }
    return Optional.empty();
  }

  private Optional<ConcreteSpecification> optionalSpecFromOptionalSExp(List<ValidIoVariable> validIoVariables, Optional<SExpr> sexpOptional) {
    if (sexpOptional.isPresent()) {
      return Optional.of(buildConcreteSpecFromSExp(sexpOptional.get().toSexpr(), validIoVariables));
    }
    return Optional.empty();
  }

  private static ConcreteSpecification buildConcreteSpecFromSExp(Sexp sExpr, List<ValidIoVariable> validIoVariables){
    Map<String, Type> typeContext = validIoVariables.stream().collect(Collectors.toMap(
        ValidIoVariable::getName, ValidIoVariable::getValidType
    ));
    Map<Integer, Integer> rawDurations = extractRawDurations(sExpr);
    //convert raw durations into duration list
    List<ConcreteDuration> durations = buildConcreteDurations(rawDurations);
    Map<Integer, Map<String, String>> rawRows = extractRawRows(sExpr, durations);
    //convert raw rows into specificationRows
    List<SpecificationRow<ConcreteCell>> specificationRows =
        buildSpecificationRows(validIoVariables, durations, rawRows);
    return new ConcreteSpecification(validIoVariables, specificationRows, durations, false);
  }

  private static List<SpecificationRow<ConcreteCell>> buildSpecificationRows(List<ValidIoVariable> validIoVariables,
                                                                      List<ConcreteDuration> durations,
                                                                      Map<Integer, Map<String, String>> rawRows) {
    List<SpecificationRow<ConcreteCell>> specificationRows = new ArrayList<>();
    durations.forEach(duration -> {
      for (int cycle = 0; cycle < duration.getDuration(); cycle++) {
        Map<String, String> rawRow = rawRows.get(duration.getBeginCycle() + cycle);
        Map<String, ConcreteCell> newRow = new HashMap<>();
        validIoVariables.forEach(validIoVariable -> {
          if (rawRow == null) {
            newRow.put(validIoVariable.getName(),
                new ConcreteCell(validIoVariable.getValidType().generateDefaultValue()));
            return;
          }
          String solvedValue = rawRow.get(validIoVariable.getName());
          if (solvedValue == null) {
            newRow.put(validIoVariable.getName(),
                new ConcreteCell(validIoVariable.getValidType().generateDefaultValue()));
            return;
          }
          Value value = validIoVariable.getValidType().match(
              () -> new ValueInt(BitvectorUtils.intFromHex(solvedValue, true)),
              () -> solvedValue.equals("true") ? ValueBool.TRUE : ValueBool.FALSE,
              typeEnum -> typeEnum.getValues().get(BitvectorUtils.intFromHex(solvedValue, false))
          );
          newRow.put(validIoVariable.getName(), new ConcreteCell(value));
        });
        specificationRows.add(SpecificationRow.createUnobservableRow(newRow));
      }
    });
    return specificationRows;
  }

  private static List<ConcreteDuration> buildConcreteDurations(Map<Integer, Integer> rawDurations) {
    List<ConcreteDuration> durations = new ArrayList<>();
    int aggregator = 0;
    for (int i = 0; i < rawDurations.size(); i++) {
      Integer duration = rawDurations.get(i);
      durations.add(i, new ConcreteDuration(aggregator, duration));
      aggregator += duration;
    }
    return durations;
  }

  private static Map<Integer, Map<String, String>> extractRawRows(Sexp sExpr, List<ConcreteDuration> durations) {
    Map<Integer, Map<String, String>> rawRows = new HashMap<>();
    sExpr.forEach(varAsign -> {
      if (varAsign.getLength() == 0 || !varAsign.get(0).toIndentedString().equals("define-fun")) return;
      String[] varSplit = varAsign.get(1).toIndentedString().split("_");
      if (varAsign.get(1).toIndentedString().matches(".*?_\\d+_\\d+")) {
        //is variable
        int cycleCount = Integer.valueOf(varSplit[2]);
        //ignore variables if iteration > n_z
        int nz = Integer.valueOf(varSplit[1]);
        ConcreteDuration concreteDuration = durations.get(nz);
        if (cycleCount >= concreteDuration.getDuration()) {
          return;
        }
        int absoluteIndex = concreteDuration.getBeginCycle() + cycleCount;
        rawRows.putIfAbsent(absoluteIndex, new HashMap<>());
        rawRows.get(absoluteIndex).put(varSplit[0], varAsign.get(4).toIndentedString());
      }
    });
    return rawRows;
  }

  private static Map<Integer, Integer> extractRawDurations(Sexp sExpr) {
    Map<Integer, Integer> rawDurations = new HashMap<>();
    sExpr.forEach(varAsign -> {
      if (varAsign.getLength() == 0 || !varAsign.get(0).toIndentedString().equals("define-fun")) return;
      String[] varSplit = varAsign.get(1).toIndentedString().split("_");
      if (varAsign.get(1).toIndentedString().matches("n_\\d+")) {
        //is duration
        rawDurations.put(Integer.valueOf(varSplit[1]), BitvectorUtils.intFromHex(varAsign.get(4).toIndentedString(), false));
      }
    });
    return rawDurations;
  }
}
