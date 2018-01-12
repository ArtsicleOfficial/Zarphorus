package org.artsicleprojects.textadventure.Areas;

import org.artsicleprojects.textadventure.Enums.AreaClasses;
import org.artsicleprojects.textadventure.Reference;

public class Swamp implements Area {

    @Override
    public String getName() {
        return "Swamp";
    }

    @Override
    public AreaClasses getAreaClass() {
        return AreaClasses.SWAMP;
    }

    @Override
    public void whenWalkedIn() {

    }

    @Override
    public boolean isDefault() {
        return false;
    }
}
