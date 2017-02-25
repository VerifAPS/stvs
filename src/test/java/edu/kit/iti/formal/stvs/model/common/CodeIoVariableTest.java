package edu.kit.iti.formal.stvs.model.common;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.*;

/**
 * Created by Lukas on 22.02.2017.
 * @author Lukas
 */
public class CodeIoVariableTest {
  private CodeIoVariable var1 = new CodeIoVariable(VariableCategory.INPUT, "BOOL", "var");
  private CodeIoVariable var2 = new CodeIoVariable(VariableCategory.INPUT, "BOOL", "var");
  private Object object = new Object();

  @Test
  public void equalsCodeIOVariable() throws Exception {
    assertTrue(var1.equals(var2));
  }

  @Test
  public void equalsObject() throws Exception {
    assertTrue(!var1.equals(object));

  }

}