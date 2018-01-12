package org.artsicleprojects.textadventure.AreaCreatables;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.artsicleprojects.textadventure.Enums.EntityClasses;

import java.util.Random;

/**
 * Created by Artsicle on 12/17/2017.
 */
public class AreaEntity {
    public EntityClasses ENTITY_CLASS;
    public Integer HEALTH = 0;
    public Integer INTERACTION_ID = 0;
    public Boolean ATTACKING_PLAYER = false;
    public AreaEntity(EntityClasses ENTITY_CLASS,Integer HEALTH) {
    	this.ENTITY_CLASS = ENTITY_CLASS;
        this.HEALTH = HEALTH;
        this.INTERACTION_ID = new Random(System.nanoTime()).nextInt(9999-1000)+1000;
    }
}
