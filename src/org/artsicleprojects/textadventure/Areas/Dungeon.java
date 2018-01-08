package org.artsicleprojects.textadventure.Areas;

import org.artsicleprojects.textadventure.Enums.AreaClasses;
import org.artsicleprojects.textadventure.Reference;

public class Dungeon implements Area {
    @Override
    public AreaClasses getAreaClass() {
        return AreaClasses.DUNGEON;
    }

    @Override
    public String getName() {
        return "Dungeon";
    }

    @Override
    public boolean isDefault() {
        return false;
    }
}
