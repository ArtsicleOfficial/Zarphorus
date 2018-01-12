package org.artsicleprojects.textadventure.Entities;

import org.artsicleprojects.textadventure.Areas.Area;
import org.artsicleprojects.textadventure.AreaCreatables.InventoryItem;
import org.artsicleprojects.textadventure.Enums.AreaClasses;
import org.artsicleprojects.textadventure.Enums.EntityClasses;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Reference;

import java.util.Random;

import static org.artsicleprojects.textadventure.Areas.InitAreas.*;

/**
 * Created by Artsicle on 12/18/2017.
 */
public class Pig implements Entity {
    @Override
    public Integer attackDamage() {
        Random random = new Random();
        Integer n = random.nextInt(2-1)+1;
        return n;
    }

    @Override
    public Integer maxHealth()
    {
        return 20;
    }

    @Override
    public Integer minHealth()
    {
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
        return "Pig";
    }

    @Override
    public Boolean canSpawn() {
        return true;
    }

    @Override
    public EntityClasses getEntityClass() {
        return EntityClasses.PIG;
    }

    @Override
    public InventoryItem dropItemOnDeath() {
        Random random = new Random();
        Integer n = random.nextInt(3-1)+1;
        return new InventoryItem(n, ItemClasses.BACON);
    }

    @Override
    public AreaClasses[] getAreaSpawns() {
        AreaClasses[] s = {AreaClasses.FOREST,AreaClasses.GRASSLAND,AreaClasses.TOWN,AreaClasses.MOUNTAIN,AreaClasses.SNOWY,AreaClasses.SWAMP};
        return s;
    }

    @Override
    public Integer[] getAreaChances() {
        //Chance out of 100 Same order as chances in "getAreaSpawns()"
        int a = 0;
        Integer[] c = {4+a,2+a,5+a,3+a,2+a,3+a};
        //Integer[] c = {75,75,75,75,75};
        return c;
    }

    @Override
    public Integer getSpawnCount() {
        return 6;
    }

    @Override
    public Boolean alwaysSpawnsAtNight() {
        return false;
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
    public Integer getXpOnDeath()
    {
        return new Random().nextInt(5-3)+3;
    }
}
