package edu.kit.iti.formal.stvs.view.menu;

import edu.kit.iti.formal.stvs.model.table.HybridSpecification;
import edu.kit.iti.formal.stvs.model.config.GlobalConfig;
import javafx.collections.ObservableList;

/**
 * Created by csicar on 10.01.17.
 */
public class SpecFileChooserManager {
  private GlobalConfig globalConfig;

  public SpecFileChooserManager(ObservableList<HybridSpecification> hybridSpecifications, GlobalConfig globalConfig) {

    this.globalConfig = globalConfig;
  }

}
