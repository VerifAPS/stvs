package edu.kit.iti.formal.stvs.model.table;

import edu.kit.iti.formal.stvs.model.common.SpecIOVariable;
import edu.kit.iti.formal.stvs.model.config.ColumnConfig;

import java.util.Optional;

/**
 * Created by philipp on 09.01.17.
 */
public class SpecificationColumn<C> {

    public C getEntryForRow(int row) {
        return null;
    }

    public SpecIOVariable getSpecIOVariable() {
        return null;
    }

    public Optional<ColumnConfig> getConfig() {
        return null;
    }
}