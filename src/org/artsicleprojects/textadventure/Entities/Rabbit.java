package org.artsicleprojects.textadventure.Entities;

import org.artsicleprojects.ArtUtils.ArtUtils;
import org.artsicleprojects.textadventure.AreaCreatables.InventoryItem;
import org.artsicleprojects.textadventure.Areas.Area;
import org.artsicleprojects.textadventure.Enums.EntityClasses;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Reference;

import static org.artsicleprojects.textadventure.Areas.InitAreas.*;

public class Rabbit implements Entity {
    @Override
    public Integer attackDamage() {
        return ArtUtils.randomInt(0,1);
    }

    @Override
    public Integer maxHealth() {
        return 8;
    }

    @Override
    public Integer minHealth() {
        return 0;
    }

    @Override
    public Boolean attacksPlayer() {
        return true;
    }

    @Override
    public Boolean dropsItem() {
        return true;
    }

    @Override
    public String getEntityName() {
        return "Rabbit";
    }

    @Override
    public Boolean canSpawn() {
        return true;
    }

    @Override
    public EntityClasses getEntityClass() {
        return EntityClasses.RABBIT;
    }

    @Override
    public InventoryItem dropItemOnDeath() {
        return new InventoryItem(ArtUtils.randomInt(1,2), ItemClasses.RABBIT_MEAT);
    }

    @Override
    public Area[] getAreaSpawns() {
        return new Area[]{FOREST,SWAMP,GRASSLANDS,DESERT,TOWN,MOUNTAINS,SNOWY};
    }

    @Override
    public Integer[] getAreaChances() {
        return new Integer[]{5,4,6,5,4,5,3};
    }

    @Override
    public Integer getSpawnCount() {
        return 6;
    }

    @Override
    public Integer getXpOnDeath() {
        return ArtUtils.randomInt(1,2);
    }
}
