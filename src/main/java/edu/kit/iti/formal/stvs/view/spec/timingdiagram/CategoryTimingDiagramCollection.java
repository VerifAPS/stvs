package edu.kit.iti.formal.stvs.view.spec.timingdiagram;

import edu.kit.iti.formal.stvs.model.common.IOVariable;
import edu.kit.iti.formal.stvs.model.table.concrete.ConcreteSpecification;
import edu.kit.iti.formal.stvs.view.Controller;
import javafx.collections.ObservableList;

/**
 * Controller for the set of either InputVariables TimingDiagramCollection or OutputVariables TimingDiagramCollection
 * Created by csicar on 09.01.17.
 */
public abstract class CategoryTimingDiagramCollection implements Controller {
    private CategoryTimingDiagramCollectionView view;

    public CategoryTimingDiagramCollection(ConcreteSpecification concreteSpecification, ObservableList<IOVariable> ioVariables) {

    }

    public CategoryTimingDiagramCollectionView getView() {
        return view;
    }

}
