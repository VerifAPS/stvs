package edu.kit.iti.formal.stvs.view.timingdiagram;

import edu.kit.iti.formal.stvs.model.common.IOVariable;
import javafx.collections.ObservableList;

/**
 * Created by csicar on 09.01.17.
 */
public class InputVariablesTimingDiagrams extends CategoryTimingDiagrams {
    public InputVariablesTimingDiagrams(ConcreteSpecification concreteSpecification, ObservableList<IOVariable> ioVariables, Selection selection) {
        super(concreteSpecification, ioVariables, selection);
    }
}
