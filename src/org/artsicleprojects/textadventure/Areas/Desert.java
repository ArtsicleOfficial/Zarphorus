package org.artsicleprojects.textadventure.Areas;

import org.artsicleprojects.textadventure.Enums.AreaClasses;
import org.artsicleprojects.textadventure.Reference;

public class Desert implements Area {

    @Override
    public String getName() {
        return "Desert";
    }

    @Override
    public AreaClasses getAreaClass() {
        return AreaClasses.DESERT;
    }

    @Override
    public void whenWalkedIn() {

    }

    @Override
    public boolean isDefault() {
        return false;
    }
}
