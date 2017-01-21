package edu.kit.iti.formal.stvs.view.editor;

import edu.kit.iti.formal.stvs.model.code.Code;
import edu.kit.iti.formal.stvs.model.code.FoldableCodeBlock;
import edu.kit.iti.formal.stvs.model.config.GlobalConfig;
import edu.kit.iti.formal.stvs.view.Controller;
import javafx.beans.value.ObservableValue;
import org.antlr.v4.runtime.Token;
import org.fxmisc.richtext.StyleSpans;
import org.reactfx.Observable;

import java.util.Collection;
import java.util.List;

/**
 * Created by csicar on 09.01.17.
 * <p>
 * Some parts are inspired by examples of the used library:
 * https://github.com/TomasMikula/RichTextFX/blob/a098da6309a0f624052fd1d4d6f5079dd6265fbe/richtextfx-demos/src/main/java/org/fxmisc/richtext/demo/JavaKeywords.java
 */
public class EditorPaneController implements Controller {
  private EditorPane view;
  private Code code;
  private GlobalConfig globalConfig;

  public EditorPaneController(Code code, GlobalConfig globalConfig) {
    this.code = code;
    this.view = new EditorPane(code.sourcecodeProperty().get());
    this.globalConfig = globalConfig;

    code.tokensBinding().addListener(this::onLexedCodeChange);
  }

  private void onLexedCodeChange(
      ObservableValue<? extends List<? extends Token>> val,
      List<? extends Token> oldTokens,
      List<? extends Token> tokens) {
    view.setStyleSpans(toStyleSpans(tokens));
  }

  private void handleParsedCodeFoldingBlocks(List<FoldableCodeBlock> foldableCodeBlocks) {

  }

  private static StyleSpans<Collection<String>> toStyleSpans(List<? extends Token> tokens) {

    return null;
  }

  public void setStylesheet(String url) {

  }

  @Override
  public EditorPane getView() {
    return null;
  }
}
