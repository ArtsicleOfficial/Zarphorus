package org.artsicleprojects.textadventure.Entities;

import org.artsicleprojects.ArtUtils.ArtUtils;
import org.artsicleprojects.textadventure.AreaCreatables.InventoryItem;
import org.artsicleprojects.textadventure.Areas.Area;
import org.artsicleprojects.textadventure.Enums.AreaClasses;
import org.artsicleprojects.textadventure.Enums.EntityClasses;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Reference;

import java.util.Random;

public class Chicken implements Entity {
    @Override
    public Integer attackDamage() {
        return 2;
    }

    @Override
    public Integer maxHealth() {
        return 10;
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
        return "Chicken";
    }

    @Override
    public Boolean canSpawn() {
        return true;
    }


    @Override
    public EntityClasses getEntityClass() {
        return EntityClasses.CHICKEN;
    }

    @Override
    public InventoryItem dropItemOnDeath() {
        return new InventoryItem(ArtUtils.randomInt(1,2), ItemClasses.CHICKEN_BREAST);
    }

    @Override
    public Boolean alwaysSpawnsAtNight() {
        return false;
    }

    @Override
    public AreaClasses[] getAreaSpawns() {
        return new AreaClasses[]{AreaClasses.FOREST,AreaClasses.SNOWY,AreaClasses.MOUNTAIN,AreaClasses.TOWN,AreaClasses.SWAMP,AreaClasses.GRASSLAND};
    }

    @Override
    public Integer[] getAreaChances() {
        return new Integer[]{4,3,4,5,3,5};
    }

    @Override
    public Integer getSpawnCount() {
        return 3;
    }

    @Override
    public Boolean autoAttacksPlayer() {
        return false;
    }

    @Override
    public Float getMoneyOnDeath() {
        return 0f;
    }

    @Override
    public Integer getXpOnDeath() {
        return ArtUtils.randomInt(3,5);
    }
}
