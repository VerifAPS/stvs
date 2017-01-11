package edu.kit.iti.formal.stvs.view.spec;

import edu.kit.iti.formal.stvs.logic.specification.VerificationState;
import edu.kit.iti.formal.stvs.model.common.IOVariable;
import edu.kit.iti.formal.stvs.model.expressions.Type;
import edu.kit.iti.formal.stvs.model.table.HybridSpecification;
import edu.kit.iti.formal.stvs.view.Controller;
import javafx.collections.ObservableList;
import javafx.scene.control.TabPane;

public class SpecificationsPaneController implements Controller {
    public SpecificationsPaneController(ObservableList<Type> types, ObservableList<IOVariable> ioVars, ObservableList<HybridSpecification> hybridSpecifications, VerificationState state) {
    }

    private ObservableList<HybridSpecification> hybridSpecifications;

    public ObservableList<HybridSpecification> getHybridSpecifications() {
        return null;
    }

    private ObservableList<Type> types;
    private ObservableList<IOVariable> ioVars;
    private TabPane view;


    public TabPane getView() {
        return view;
    }

    private void addTab(HybridSpecification spec) {

    }

    private void removeTab(int tabIndex) {

    }
}
