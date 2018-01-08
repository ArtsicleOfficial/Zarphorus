package org.artsicleprojects.textadventure.Areas;

import org.artsicleprojects.textadventure.Enums.AreaClasses;
import org.artsicleprojects.textadventure.Reference;

public class Forest implements Area {

    @Override
    public String getName() {
        return "Forest";
    }

    @Override
    public AreaClasses getAreaClass() {
        return AreaClasses.FOREST;
    }

    @Override
    public boolean isDefault() {
        return false;
    }
}
