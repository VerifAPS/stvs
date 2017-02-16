package edu.kit.iti.formal.stvs.model.config;

import edu.kit.iti.formal.stvs.ViewUtils;
import edu.kit.iti.formal.stvs.logic.io.ExportException;
import edu.kit.iti.formal.stvs.logic.io.ExporterFacade;
import edu.kit.iti.formal.stvs.logic.io.ImporterFacade;
import javafx.beans.property.*;
import javafx.scene.control.Alert;
import org.apache.commons.lang3.builder.EqualsBuilder;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Contains global configuration specified by the user
 */
public class GlobalConfig {

  private static final String AUTOLOAD_CONFIG_FILENAME = "stvs-config.xml";
  private static final String CONFIG_DIRNAME = ".config";
  private List<String> validLanguages = Arrays.asList("EN");

  // General
  private IntegerProperty verificationTimeout;
  private IntegerProperty simulationTimeout;
  private BooleanProperty windowMaximized;
  private IntegerProperty windowHeight;
  private IntegerProperty  windowWidth;
  private StringProperty uiLanguage;
  private IntegerProperty maxLineRollout;

  // Editor
  private IntegerProperty editorFontSize;
  private StringProperty editorFontFamily;
  private BooleanProperty showLineNumbers;

  // Dependency paths
  private StringProperty nuxmvFilename;
  private StringProperty z3Path;
  private StringProperty getetaCommand;

  /**
   * Default configuration
   */
  public GlobalConfig() {
    verificationTimeout = new SimpleIntegerProperty(3600);
    simulationTimeout = new SimpleIntegerProperty(60);
    windowMaximized = new SimpleBooleanProperty(true);
    windowHeight = new SimpleIntegerProperty(600);
    windowWidth = new SimpleIntegerProperty(800);
    editorFontSize = new SimpleIntegerProperty(12);
    maxLineRollout = new SimpleIntegerProperty(50);
    editorFontFamily = new SimpleStringProperty("Courier");
    showLineNumbers = new SimpleBooleanProperty(true);
    uiLanguage = new SimpleStringProperty("EN");
    nuxmvFilename = new SimpleStringProperty("[Path to NuXmv Executable]");
    z3Path = new SimpleStringProperty("[Path to Z3 Executable]");
    getetaCommand = new SimpleStringProperty("java -jar /path/to/geteta.jar -c ${code} -t ${spec} -x");
  }

  public static GlobalConfig autoloadConfig() {
    String userHome = System.getProperty("user.home");
    String configDirPath = userHome + File.separator + CONFIG_DIRNAME;
    File configFile = new File(configDirPath + File.separator + AUTOLOAD_CONFIG_FILENAME);
    try {
        return ImporterFacade.importConfig(configFile, ImporterFacade.ImportFormat.XML);
    } catch (Exception e) {
        return new GlobalConfig();
    }
  }

  public void autosaveConfig() throws IOException, ExportException {
    String userHome = System.getProperty("user.home");
    String configDirPath = userHome + File.separator + CONFIG_DIRNAME;
    File configDir = new File(configDirPath);
    if (!configDir.isDirectory() || !configDir.exists()) {
      configDir.mkdirs();
    }
    File configFile = new File(configDirPath + File.separator + AUTOLOAD_CONFIG_FILENAME);
    ExporterFacade.exportConfig(this, ExporterFacade.ExportFormat.XML, configFile);
  }

  public void setAll(GlobalConfig toBeCopied) {
    verificationTimeout.set(toBeCopied.getVerificationTimeout());
    simulationTimeout.set(toBeCopied.getSimulationTimeout());
    windowMaximized.set(toBeCopied.isWindowMaximized());
    windowHeight.set(toBeCopied.getWindowHeight());
    windowWidth.set(toBeCopied.getWindowWidth());
    editorFontSize.set(toBeCopied.getEditorFontSize());
    maxLineRollout.set(toBeCopied.getMaxLineRollout());
    editorFontFamily.set(toBeCopied.getEditorFontFamily());
    showLineNumbers.set(toBeCopied.getShowLineNumbers());
    uiLanguage.set(toBeCopied.getUiLanguage());
    nuxmvFilename.set(toBeCopied.getNuxmvFilename());
    z3Path.set(toBeCopied.getZ3Path());
    getetaCommand.set(toBeCopied.getGetetaCommand());
  }

  /**
   * Get the current verification timeout
   *
   * @return The current verification timeout
   */
  public int getVerificationTimeout() {
    return verificationTimeout.get();
  }

  /**
   * Get the current simulation timeout
   *
   * @return The current simulation timeout
   */
  public int getSimulationTimeout() {
    return simulationTimeout.get();
  }

  /**
   * Get the current editor font size
   *
   * @return The current editor font size
   */
  public int getEditorFontSize() {
    return editorFontSize.get();
  }

  /**
   * Get the current editor font family
   *
   * @return The current editor font family
   */
  public String getEditorFontFamily() {
    return editorFontFamily.get();
  }

  /**
   * Are line numbers to be shown in the editor?
   *
   * @return Whether line numbers are to be shown in the editor
   */
  public boolean getShowLineNumbers() {
    return showLineNumbers.get();
  }

  /**
   * What is the current UI language?
   *
   * @return The current UI language
   */
  public String getUiLanguage() {
    return uiLanguage.get();
  }

  /**
   * Set the current verification timeout
   *
   * @param verificationTimeout The verification timeout to set
   */
  public void setVerificationTimeout(int verificationTimeout) {
    if (verificationTimeout <= 0) {
      throw new IllegalArgumentException("Invalid verification timeout: " + verificationTimeout);
    }
    this.verificationTimeout.set(verificationTimeout);
  }

  /**
   * Set the current simulation timeout
   *
   * @param simulationTimeout The simulation timeout to set
   */
  public void setSimulationTimeout(int simulationTimeout) {
    if (simulationTimeout <= 0) {
      throw new IllegalArgumentException("Invalid simulation timeout: " + simulationTimeout);
    }
    this.simulationTimeout.set(simulationTimeout);
  }

  /**
   * Set the current editor font size
   *
   * @param editorFontSize The editor font size to set
   */
  public void setEditorFontSize(int editorFontSize) {
    if (editorFontSize <= 0) {
      throw new IllegalArgumentException("Invalid editor font size: " + editorFontSize);
    }
    this.editorFontSize.set(editorFontSize);
  }

  /**
   * Set the current editor font family
   *
   * @param editorFontFamily The verification timeout to set
   */
  public void setEditorFontFamily(String editorFontFamily) {
    this.editorFontFamily.set(editorFontFamily);
  }

  /**
   * Are line numbers to be shown in the editor?
   *
   * @param showLineNumbers Whether line numbers are to be shown in the editor
   */
  public void setShowLineNumbers(boolean showLineNumbers) {
    this.showLineNumbers.set(showLineNumbers);
  }

  public List<String> getValidLanguages() {
    return this.validLanguages;
  }

  /**
   * Set the current UI language
   *
   * @param uiLanguage
   */
  public void setUiLanguage(String uiLanguage) {
    if (!validLanguages.contains(uiLanguage))  {
      throw new IllegalArgumentException("Input language " + uiLanguage + " is not supported");
    }
    this.uiLanguage.set(uiLanguage);
  }

  public int getWindowHeight() {
    return windowHeight.get();
  }

  public void setWindowHeight(int windowHeight) {
    if (windowHeight <= 0) {
      throw new IllegalArgumentException("Illegal window height: " + windowHeight);
    }
    this.windowHeight.set(windowHeight);
  }

  public int getWindowWidth() {
    return windowWidth.get();
  }

  public void setWindowWidth(int windowWidth) {
    if (windowWidth <= 0) {
      throw new IllegalArgumentException("Illegal window width: " + windowWidth);
    }
    this.windowWidth.set(windowWidth);
  }

  public IntegerProperty verificationTimeoutProperty() {
    return this.verificationTimeout;
  }

  public IntegerProperty simulationTimeoutProperty() {
    return simulationTimeout;
  }

  public IntegerProperty windowHeightProperty() {
    return windowHeight;
  }

  public IntegerProperty windowWidthProperty() {
    return windowWidth;
  }

  public IntegerProperty editorFontSizeProperty() {
    return editorFontSize;
  }

  public StringProperty editorFontFamilyProperty() {
    return editorFontFamily;
  }

  public boolean isShowLineNumbers() {
    return showLineNumbers.get();
  }

  public BooleanProperty showLineNumbersProperty() {
    return showLineNumbers;
  }

  public StringProperty uiLanguageProperty() {
    return uiLanguage;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof GlobalConfig)) return false;
    if (obj == this) return true;

    GlobalConfig rhs = (GlobalConfig) obj;
    return new EqualsBuilder().
            append(verificationTimeout.get(), rhs.verificationTimeout.get()).
            append(simulationTimeout.get(), rhs.simulationTimeout.get()).
        append(editorFontFamily.get(), rhs.editorFontFamily.get()).
        append(editorFontSize.get(), rhs.editorFontSize.get()).
        append(showLineNumbers.get(), rhs.showLineNumbers.get()).
        append(uiLanguage.get(), rhs.uiLanguage.get()).
        append(windowHeight.get(), rhs.windowHeight.get()).
        append(windowWidth.get(), rhs.windowWidth.get()).
            isEquals();
  }

  public String getNuxmvFilename() {
    return nuxmvFilename.get();
  }

  public StringProperty nuxmvFilenameProperty() {
    return nuxmvFilename;
  }

  public void setNuxmvFilename(String nuxmvFilename) {
    this.nuxmvFilename.set(nuxmvFilename);
  }

  public String getZ3Path() {
    return z3Path.get();
  }

  public StringProperty z3PathProperty() {
    return z3Path;
  }

  public void setZ3Path(String z3Path) {
    this.z3Path.set(z3Path);
  }

  public String getGetetaCommand() {
    return getetaCommand.get();
  }

  public StringProperty getetaCommandProperty() {
    return getetaCommand;
  }

  public void setGetetaCommand(String getetaCommand) {
    this.getetaCommand.set(getetaCommand);
  }

  public int getMaxLineRollout() {
    return maxLineRollout.get();
  }

  public IntegerProperty maxLineRolloutProperty() {
    return maxLineRollout;
  }

  public void setMaxLineRollout(int maxLineRollout) {
    this.maxLineRollout.set(maxLineRollout);
  }

  public boolean isWindowMaximized() {
    return windowMaximized.get();
  }

  public BooleanProperty windowMaximizedProperty() {
    return windowMaximized;
  }

  public void setWindowMaximized(boolean windowMaximized) {
    this.windowMaximized.set(windowMaximized);
  }
}
