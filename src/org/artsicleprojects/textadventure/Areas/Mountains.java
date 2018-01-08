package org.artsicleprojects.textadventure.Areas;

import org.artsicleprojects.textadventure.Enums.AreaClasses;
import org.artsicleprojects.textadventure.Reference;

public class Mountains implements Area {

    @Override
    public String getName() {
        return "Mountains";
    }

    @Override
    public AreaClasses getAreaClass() {
        return AreaClasses.MOUNTAIN;
    }

    @Override
    public boolean isDefault() {
        return false;
    }
}
