package org.artsicleprojects.textadventure.AreaCreatables;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.artsicleprojects.textadventure.Enums.MineableClasses;

import java.util.Random;

public class AreaMineable {
    public MineableClasses CLASS;
    public Integer DURABILITY = 0;
    public Integer INTERACTION_ID = 0;

    public AreaMineable(MineableClasses CLASS, Integer DURABILITY) {
        this.CLASS = CLASS;
        this.DURABILITY = DURABILITY;
        this.INTERACTION_ID = new Random(System.nanoTime()).nextInt(9999-1000)+1000;
    }
}
