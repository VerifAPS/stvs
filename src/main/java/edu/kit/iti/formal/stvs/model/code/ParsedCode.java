package edu.kit.iti.formal.stvs.model.code;

import edu.kit.iti.formal.automation.parser.IEC61131Lexer;
import edu.kit.iti.formal.automation.parser.IEC61131Parser;
import edu.kit.iti.formal.automation.st.ast.*;
import edu.kit.iti.formal.automation.visitors.DefaultVisitor;
import edu.kit.iti.formal.stvs.model.common.CodeIoVariable;
import edu.kit.iti.formal.stvs.model.common.VariableCategory;
import edu.kit.iti.formal.stvs.model.expressions.Type;
import edu.kit.iti.formal.stvs.model.expressions.TypeBool;
import edu.kit.iti.formal.stvs.model.expressions.TypeEnum;
import edu.kit.iti.formal.stvs.model.expressions.TypeInt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

/**
 * Created by philipp on 09.01.17.
 *
 * @author Lukas Fritsch
 */
public class ParsedCode {

  private static class TypeDeclarationVisitor extends DefaultVisitor<Void> {
    private List<Type> definedTypes;

    TypeDeclarationVisitor() {
      this.definedTypes = new ArrayList<>();
      this.definedTypes.add(TypeBool.BOOL);
      this.definedTypes.add(TypeInt.INT);
    }

    @Override
    public Void visit(TypeDeclarations decls) {
      decls.stream().forEach(decl -> decl.visit(this));
      return null;
    }

    @Override
    public Void visit(EnumerationTypeDeclaration enumType) {
      TypeEnum type = new TypeEnum(enumType.getTypeName(), enumType.getAllowedValues());
      this.definedTypes.add(type);
      return null;
    }

    public List<Type> getDefinedTypes() {
      return definedTypes;
    }

  }

  private static class VariableVisitor extends DefaultVisitor<Void> {
    private List<CodeIoVariable> definedVariables = new ArrayList<>();

    @Override
    public Void visit(ProgramDeclaration program) {
      program.getLocalScope().getLocalVariables().entrySet().forEach(variableEntry -> {
        //String varName = variableEntry.getKey();
        VariableDeclaration varDecl = variableEntry.getValue();
        VariableCategory category;
        switch (varDecl.getType()) {
          case VariableDeclaration.INPUT:
            category = VariableCategory.INPUT;
            break;
          case VariableDeclaration.OUTPUT:
            category = VariableCategory.OUTPUT;
            break;
          default:
            // Don't create variables for other types than INPUT or OUTPUT
            //TODO: recognize INOUT or other variables (was not specified however)
            return;
        }
        this.definedVariables.add(new CodeIoVariable(category, varDecl.getDataTypeName(), varDecl.getName()));
      });
      return null;
    }

    public List<CodeIoVariable> getDefinedVariables() {
      return definedVariables;
    }
  }

  private static class BlockVisitor extends DefaultVisitor<Void> {
    private List<FoldableCodeBlock> foldableCodeBlocks;

    BlockVisitor() {
      this.foldableCodeBlocks = new ArrayList<>();
    }

    private void addBlock(Top topElement) {
      foldableCodeBlocks.add(new FoldableCodeBlock(
          topElement.getStartPosition().getLineNumber(),
          topElement.getEndPosition().getLineNumber()));
    }

    @Override
    public Void visit(FunctionDeclaration function) {
      addBlock(function);
      return null;
    }

    @Override
    public Void visit(ProgramDeclaration program) {
      addBlock(program);
      return null;
    }

    List<FoldableCodeBlock> getFoldableCodeBlocks() {
      return this.foldableCodeBlocks;
    }
  }

  private List<FoldableCodeBlock> foldableCodeBlocks;
  private List<CodeIoVariable> definedVariables;
  private List<Type> definedTypes;

  public ParsedCode(List<FoldableCodeBlock> foldableCodeBlocks, List<CodeIoVariable> definedVariables, List<Type> definedTypes) {
    this.foldableCodeBlocks = foldableCodeBlocks;
    this.definedVariables = definedVariables;
    this.definedTypes = definedTypes;
  }

  /**
   *
   * @param input the code to parse
   * @param tokenListener
   * @param syntaxErrorsListener
   * @param parsedCodeListener
   */
  public static void parseCode(String input,
                               Consumer<List<? extends Token>> tokenListener,
                               Consumer<List<SyntaxError>> syntaxErrorsListener,
                               Consumer<ParsedCode> parsedCodeListener) {
    try {
      SyntaxErrorListener syntaxErrorListener = new SyntaxErrorListener();
      IEC61131Lexer lexer = new IEC61131Lexer(new ANTLRInputStream(input));
      lexer.removeErrorListeners();
      lexer.addErrorListener(syntaxErrorListener);
      tokenListener.accept(lexer.getAllTokens());
      lexer.reset();

      IEC61131Parser parser = new IEC61131Parser(new CommonTokenStream(lexer));
      parser.removeErrorListeners();
      parser.addErrorListener(syntaxErrorListener);

      TopLevelElements ast = new TopLevelElements(parser.start().ast);

      syntaxErrorsListener.accept(syntaxErrorListener.getSyntaxErrors());

      // Find types in parsed code
      TypeDeclarationVisitor typeVisitor = new TypeDeclarationVisitor();
      ast.visit(typeVisitor);
      Map<String, Type> definedTypesByName = new HashMap<>();
      typeVisitor.getDefinedTypes().forEach(type -> definedTypesByName.put(type.getTypeName(), type));

      // Find IoVariables in parsed code
      VariableVisitor variableVisitor = new VariableVisitor();
      ast.visit(variableVisitor);

      // Find code blocks in parsed code
      BlockVisitor blockVisitor = new BlockVisitor();
      ast.visit(blockVisitor);
      List<FoldableCodeBlock> foldableCodeBlocks = blockVisitor.getFoldableCodeBlocks();

      parsedCodeListener.accept(
          new ParsedCode(
              foldableCodeBlocks,
              variableVisitor.getDefinedVariables(),
              typeVisitor.getDefinedTypes())
      );
      // GOTTA CATCH 'EM ALL! *sings*
    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }

  public List<FoldableCodeBlock> getFoldableCodeBlocks() {
    return foldableCodeBlocks;
  }

  public List<CodeIoVariable> getDefinedVariables() {
    return definedVariables;
  }

  public List<Type> getDefinedTypes() {
    return definedTypes;
  }


}
