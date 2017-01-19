package edu.kit.iti.formal.stvs.model.code;

import edu.kit.iti.formal.stvs.model.common.OptionalProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import org.antlr.v4.runtime.Token;
import org.junit.Test;
import sun.misc.IOUtils;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Philipp on 19.01.2017.
 */
public class CodeTest {

  private final Code code = new Code();
  private final Code exampleCode = new Code("stfile.st", "THIS IS SPARTA");
  private final Code enumDefinition = loadCodeFromFile("define_type.st");

  private static String convertStreamToString(InputStream is) {
    java.util.Scanner s = new java.util.Scanner(is, "UTF-8").useDelimiter("\\A");
    return s.hasNext() ? s.next() : "";
  }

  private static Code loadCodeFromFile(String filename) {
    return new Code(
        filename,
        convertStreamToString(CodeTest.class.getResourceAsStream(filename)));
  }

  @Test
  public void testIsEmptyInitially() {
    assertEquals("", code.sourcecodeProperty().get());
  }

  @Test
  public void testSourcecodeListenable() {
    BooleanProperty sourcecodeChanged = new SimpleBooleanProperty(false);
    code.sourcecodeProperty().addListener(change -> sourcecodeChanged.set(true));
    code.sourcecodeProperty().set("TYPE months := (jan, feb) END_TYPE");
    assertEquals("Sourcecode changed", true, sourcecodeChanged.get());
  }

  @Test
  public void testTokensExist() {
    code.sourcecodeProperty().set("TYPE is a keyword END_TYPE");
    List<? extends Token> tokens = code.tokensBinding().getValue();
    System.out.println(tokens);
    assertTrue(tokens.size() > 0);
  }

  @Test
  public void testTokensConcatenated() {
    String source = exampleCode.sourcecodeProperty().get();
    List<? extends Token> tokens = exampleCode.tokensBinding().getValue();
    String tokensConcatenated = tokens.stream()
        .map(Token::getText)
        .reduce("", String::concat);
    assertEquals("Lexer tokens concatenated are source code", source, tokensConcatenated);
  }

  @Test
  public void testGetParsedCode() {
    OptionalProperty<ParsedCode> parsed = enumDefinition.parsedCodeProperty();
    assertEquals("Have one defined type", 1, parsed.get().getDefinedTypes());
  }
}
