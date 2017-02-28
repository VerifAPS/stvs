package edu.kit.iti.formal.stvs.logic.verification;

import edu.kit.iti.formal.stvs.logic.io.ExportException;
import edu.kit.iti.formal.stvs.model.common.NullableProperty;
import edu.kit.iti.formal.stvs.model.table.ConstraintSpecification;
import edu.kit.iti.formal.stvs.model.verification.VerificationError;
import edu.kit.iti.formal.stvs.model.verification.VerificationResult;
import edu.kit.iti.formal.stvs.model.verification.VerificationScenario;

import java.io.IOException;

/**
 * Strategy for Verification of the VerificationScenario.
 *
 * @author Benjamin Alt
 */
public interface VerificationEngine {

  /**
   * Starts a verification in its own thread.
   *
   * @param scenario scenario that hold the code to be checked
   * @param spec     specification that should be checked
   * @throws IOException       exception while creating process
   * @throws ExportException   exception while exporting
   * @throws VerificationError exception while verifying
   */
  public void startVerification(VerificationScenario scenario,
                                ConstraintSpecification spec) throws
      IOException, ExportException, VerificationError;

  public NullableProperty<VerificationResult> verificationResultProperty();

  public VerificationResult getVerificationResult();

  /**
   * cancels a running verification.
   */
  public void cancelVerification();
}
