package org.artsicleprojects.textadventure.Areas;

import org.artsicleprojects.textadventure.Enums.AreaClasses;

public interface Area {
    public String getName();
    public AreaClasses getAreaClass();

    public boolean isDefault();
}
