package edu.kit.iti.formal.stvs.view.spec.timingdiagram.renderer;

import edu.kit.iti.formal.stvs.model.table.ConcreteDuration;
import edu.kit.iti.formal.stvs.view.Controller;
import javafx.scene.control.ContextMenu;

import java.util.function.Function;

/**
 * Controller for the Cycle-Display on the X-Axis
 * Created by csicar on 10.01.17.
 */
public class CycleController implements Controller {
    private ContextMenu contextMenu;

    /**
     *
     * @param getDurationForRow method from HybridSpecification as a function
     */
    public CycleController(Function<Integer, ConcreteDuration> getDurationForRow) {

    }

    public CycleView getView() {
        return null;
    }
}
