package org.artsicleprojects.textadventure.Entities;

import org.artsicleprojects.ArtUtils.ArtUtils;
import org.artsicleprojects.textadventure.AreaCreatables.InventoryItem;
import org.artsicleprojects.textadventure.Areas.Area;
import org.artsicleprojects.textadventure.Enums.AreaClasses;
import org.artsicleprojects.textadventure.Enums.EntityClasses;
import org.artsicleprojects.textadventure.Enums.ItemClasses;

import java.util.Map;

public class Goblin implements Entity {
    @Override
    public Integer attackDamage() {
        return ArtUtils.randomInt(12,14);
    }

    @Override
    public Integer maxHealth() {
        return 100;
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
        return "Goblin";
    }

    @Override
    public Boolean canSpawn() {
        return true;
    }

    @Override
    public Boolean autoAttacksPlayer() {
        return true;
    }

    @Override
    public EntityClasses getEntityClass() {
        return EntityClasses.GOBLIN;
    }

    @Override
    public InventoryItem dropItemOnDeath() {
        return new InventoryItem(ArtUtils.randomInt(2,3), ItemClasses.FLESH);
    }

    @Override
    public Boolean alwaysSpawnsAtNight() {
        return true;
    }

    @Override
    public AreaClasses[] getAreaSpawns() {
        return new AreaClasses[]{AreaClasses.CAVE};
    }

    @Override
    public Integer[] getAreaChances() {
        return new Integer[]{8};
    }

    @Override
    public Integer getSpawnCount() {
        return 2;
    }

    @Override
    public Float getMoneyOnDeath() {
        return ArtUtils.randomFloat(0f,1.2f);
    }

    @Override
    public Integer getXpOnDeath() {
        return ArtUtils.randomInt(4,7);
    }
}
