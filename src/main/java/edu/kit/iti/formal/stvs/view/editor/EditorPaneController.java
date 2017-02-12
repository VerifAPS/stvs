package edu.kit.iti.formal.stvs.view.editor;

import edu.kit.iti.formal.automation.parser.IEC61131Lexer;
import edu.kit.iti.formal.stvs.model.code.Code;
import edu.kit.iti.formal.stvs.model.code.FoldableCodeBlock;
import edu.kit.iti.formal.stvs.model.code.SyntaxError;
import edu.kit.iti.formal.stvs.model.config.GlobalConfig;
import edu.kit.iti.formal.stvs.view.Controller;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import org.antlr.v4.runtime.Token;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.StyleSpans;
import org.fxmisc.richtext.StyleSpansBuilder;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
  private ExecutorService executor;
  private ObservableList<SyntaxError> syntaxErrors;

  public EditorPaneController(Code code, GlobalConfig globalConfig) {
    this.code = code;
    this.syntaxErrors = code.getSyntaxErrorObs();
    this.view = new EditorPane(code.getSourcecode(), syntaxErrors);
    this.globalConfig = globalConfig;

    this.view.getStylesheets().add(
        EditorPane.class.getResource("st-keywords.css").toExternalForm());
    this.executor = Executors.newSingleThreadExecutor();
    configureTextArea();
    handleTextChange(computeHighlighting(code.getSourcecode()));

  }

  private void configureTextArea() {
    CodeArea codeArea = view.getCodeArea();
    codeArea.richChanges()
        .filter(ch -> !ch.getInserted().equals(ch.getRemoved()))
        .successionEnds(Duration.ofMillis(500))
        .hook(collectionRichTextChange -> codeArea.getUndoManager().mark())
        .supplyTask(this::computeHighlightingAsync)
        .awaitLatest(codeArea.richChanges())
        .filterMap(t -> {
          if(t.isSuccess()) {
            return Optional.of(t.get());
          } else {
            t.getFailure().printStackTrace();
            return Optional.empty();
          }
        })
        .subscribe(this::handleTextChange);
  }

  private Task<StyleSpans<Collection<String>>> computeHighlightingAsync() {
    CodeArea codeArea = view.getCodeArea();
    String sourcecode = codeArea.getText();
    Task<StyleSpans<Collection<String>>> task = new Task<StyleSpans<Collection<String>>>() {
      @Override
      protected StyleSpans<Collection<String>> call() throws Exception {
        return computeHighlighting(sourcecode);
      }
    };
    executor.execute(task);
    return task;
  }

  private StyleSpans<Collection<String>> computeHighlighting(String sourcecode) {
    code.updateSourcecodeAsync(sourcecode,
        syntaxErrs -> Platform.runLater(() -> code.getSyntaxErrorObs().setAll(syntaxErrs)));
    List<? extends Token> tokens = code.getTokens();

    StyleSpansBuilder<Collection<String>> spansBuilder
        = new StyleSpansBuilder<>();

    if (tokens.isEmpty()) {
      spansBuilder.add(Collections.emptyList(), 0);
      return spansBuilder.create();
    }

    tokens.forEach(token ->
      // replaceAll is a work-around for a bug when ANTLR has a
      // different character count than this CodeArea.
      spansBuilder.add(getStyleClassesFor(token, code.getSyntaxErrors()),
          token.getText().replaceAll("\\r", "").length())
    );
    return spansBuilder.create();
  }

  private Collection<String> getStyleClassesFor(Token token, List<SyntaxError> syntaxErrors) {
        //getHightlightingClass(token);
    if (syntaxErrors.stream().anyMatch(syntaxError -> syntaxError.isToken(token))) {
      return Collections.singletonList("syntax-error");
    } else {
      return getHightlightingClass(token);
    }
  }

  private List<String> getHightlightingClass(Token token) {
    // TODO: Add more colours (styles) to tokens
    switch (token.getType()) {
      case IEC61131Lexer.PROGRAM:
      case IEC61131Lexer.END_PROGRAM:
      case IEC61131Lexer.TYPE:
      case IEC61131Lexer.END_TYPE:
      case IEC61131Lexer.IF:
      case IEC61131Lexer.END_IF:
      case IEC61131Lexer.FUNCTION:
      case IEC61131Lexer.END_FUNCTION:
      case IEC61131Lexer.FUNCTION_BLOCK:
      case IEC61131Lexer.END_FUNCTION_BLOCK:
      case IEC61131Lexer.CASE:
      case IEC61131Lexer.END_CASE:
        return listOf("keyword");
      case IEC61131Lexer.INT:
      case IEC61131Lexer.BOOL:
        return listOf("type");
      case IEC61131Lexer.INTEGER_LITERAL:
        return listOf("number");
      case IEC61131Lexer.STRING_LITERAL:
        return listOf("string");
      case IEC61131Lexer.VAR:
      case IEC61131Lexer.VAR_INPUT:
      case IEC61131Lexer.VAR_IN_OUT:
      case IEC61131Lexer.VAR_OUTPUT:
      case IEC61131Lexer.END_VAR:
        return listOf("vardef");
      default:
          return listOf();
      }
    }

  private <E> List<E> listOf(E... elements) {
    ArrayList<E> list = new ArrayList<>();
    for (E element : elements) {
      list.add(element);
    }
    return list;
  }

  private void handleTextChange(StyleSpans<Collection<String>> highlighting) {
    code.updateSourcecode(view.getCodeArea().getText());
    view.setStyleSpans(highlighting);
    System.out.println(view.getSyntaxErrorListView().getItems());

  }

  private void handleParsedCodeFoldingBlocks(List<FoldableCodeBlock> foldableCodeBlocks) {

  }

  // TODO: Implement this?
  public void setStylesheet(String url) {
  }

  public Code getCode() {
    return this.code;
  }

  @Override
  public EditorPane getView() {
    return view;
  }
}
