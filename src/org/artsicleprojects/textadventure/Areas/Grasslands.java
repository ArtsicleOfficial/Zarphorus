package org.artsicleprojects.textadventure.Areas;

import org.artsicleprojects.textadventure.Enums.AreaClasses;
import org.artsicleprojects.textadventure.Reference;

public class Grasslands implements Area {

    @Override
    public String getName() {
        return "Grasslands";
    }

    @Override
    public AreaClasses getAreaClass() {
        return AreaClasses.GRASSLAND;
    }

    @Override
    public boolean isDefault() {
        return true;
    }
}
