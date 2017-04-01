package edu.kit.iti.formal.stvs.model.common;

import edu.kit.iti.formal.stvs.model.expressions.types.Type;
import edu.kit.iti.formal.stvs.model.expressions.values.Value;
import edu.kit.iti.formal.stvs.model.expressions.VariableExpr;

import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * <p>A problem that is generated by the {@link FreeVariableListValidator} if
 * a free variable cannot be validated, that is, it has a name that is not a valid
 * identifier, a type that has never been defined or a default value that does not
 * fit the type or is not a valid literal.</p>
 *
 * @author Philipp
 */
public class InvalidFreeVariableProblem extends FreeVariableProblem {

  /**
   * Tries to validate the given {@link FreeVariable} (effective model) to the formal model
   * {@link ValidFreeVariable}. If that cannot be done successfully it throws a problem.
   *
   * @param freeVariable the effective model to validate
   * @param typesByName a type context valdiation
   * @return the formal model, if successfully validated
   * @throws InvalidFreeVariableProblem if this free variable is not input-valid
   */
  public static ValidFreeVariable tryToConvertToValid(
      FreeVariable freeVariable, Map<String, Type> typesByName)
      throws InvalidFreeVariableProblem {
    String validName = tryToGetValidName(freeVariable);
    Type validType = tryToGetValidType(freeVariable, typesByName);
    Value validDefaultValue = tryToGetValidDefaultValue(freeVariable, validType);
    return new ValidFreeVariable(validName, validType, validDefaultValue);
  }

  private static String tryToGetValidName(FreeVariable freeVariable)
      throws InvalidFreeVariableProblem {
    String varName = freeVariable.getName();
    if (VariableExpr.IDENTIFIER_PATTERN.matcher(varName).matches()) {
      return varName;
    } else {
      throw new InvalidFreeVariableProblem(
          "Variable has illegal characters in name: " + StringEscapeUtils.escapeJava(varName));
    }
  }

  private static Type tryToGetValidType(FreeVariable freeVariable, Map<String, Type> typesByName)
      throws InvalidFreeVariableProblem {
    Type foundType = typesByName.get(freeVariable.getType());
    if (foundType == null) {
      throw new InvalidFreeVariableProblem(
          "Variable has unknown type: " + StringEscapeUtils.escapeJava(freeVariable.getType()));
    }
    return foundType;
  }

  private static Value tryToGetValidDefaultValue(
      FreeVariable freeVariable, Type freeVarType) throws InvalidFreeVariableProblem {
    if (freeVariable.getDefaultValue().isEmpty()) {
      return null;
    }
    return freeVarType.parseLiteral(freeVariable.getDefaultValue().trim())
        .orElseThrow(() -> new InvalidFreeVariableProblem("Couldn't parse default value: "
            + StringEscapeUtils.escapeJava(freeVariable.getDefaultValue())));
  }

  protected InvalidFreeVariableProblem(String errorMessage) {
    super(errorMessage);
  }

  @Override
  public String getProblemName() {
    return "invalid free variable";
  }

}
