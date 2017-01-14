package edu.kit.iti.formal.stvs.view.spec;


import edu.kit.iti.formal.stvs.model.common.CodeIOVariable;
import edu.kit.iti.formal.stvs.model.config.GlobalConfig;
import edu.kit.iti.formal.stvs.model.expressions.Type;
import edu.kit.iti.formal.stvs.model.table.HybridSpecification;
import edu.kit.iti.formal.stvs.model.verification.VerificationState;
import edu.kit.iti.formal.stvs.view.Controller;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.scene.control.ContextMenu;

public class SpecificationTabController implements Controller {
    public SpecificationTabController(HybridSpecification hybridSpecification, ObservableList<Type> types, ObservableList<CodeIOVariable> ioVars, VerificationState state, GlobalConfig globalConfig) {
    }
    private GlobalConfig globalConfig;
    private ObservableSet<String> definedVars;
    private ObservableList<Type> types;
    private ObservableList<CodeIOVariable> ioVars;
    private HybridSpecification spec;
    private VerificationState state;
    private ContextMenu contextMenu;

    public SpecificationTab getView() {
        return null;
    }


}