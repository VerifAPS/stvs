package edu.kit.iti.formal.stvs.view.timingdiagram;

import edu.kit.iti.formal.stvs.model.common.IOVariable;
import edu.kit.iti.formal.stvs.model.table.concrete.ConcreteSpecification;
import javafx.collections.ObservableList;

/**
 * Created by csicar on 09.01.17.
 * creates TimingDiagramCollectionView
 */
public class TimingDiagramCollection {
    private ConcreteSpecification concreteSpecification;
    private ObservableList<IOVariable> ioVariables;


    /**
     * creates VariableTimingDiagram for each given Variable
     * @param concreteSpecification
     * @param ioVariables
     */
    public TimingDiagramCollection(ConcreteSpecification concreteSpecification, ObservableList<IOVariable> ioVariables) {

    }

}
