package org.artsicleprojects.textadventure.Areas;

import org.artsicleprojects.textadventure.Enums.AreaClasses;
import org.artsicleprojects.textadventure.Reference;

public class Snowy implements Area {
    @Override
    public AreaClasses getAreaClass() {
        return AreaClasses.SNOWY;
    }

    @Override
    public String getName() {
        return "Snowy";
    }

    @Override
    public boolean isDefault() {
        return false;
    }
}
