package org.artsicleprojects.textadventure.Areas;

import org.artsicleprojects.textadventure.Enums.AreaClasses;
import org.artsicleprojects.textadventure.Reference;

public class Town implements Area {

    @Override
    public String getName() {
        return "Town";
    }

    @Override
    public AreaClasses getAreaClass() {
        return AreaClasses.TOWN;
    }

    @Override
    public boolean isDefault() {
        return false;
    }
}
