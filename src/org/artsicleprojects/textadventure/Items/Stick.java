package org.artsicleprojects.textadventure.Items;

import org.artsicleprojects.textadventure.Areas.Area;
import org.artsicleprojects.textadventure.Enums.AreaClasses;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Enums.ToolClasses;
import org.artsicleprojects.textadventure.Reference;

import javax.tools.Tool;

import static org.artsicleprojects.textadventure.Enums.ToolClasses.*;

public class Stick implements Item {

    @Override
    public void ItemUsed() {

    }

    @Override
    public void ItemEquipped() {

    }

    @Override
    public void ItemDropped() {

    }

    @Override
    public void ItemPickedUp() {

    }

    @Override
    public float getCost() {
        return 0.05f;
    }

    @Override
    public boolean canBeSold() {
        return false;
    }

    @Override
    public boolean canBeBought() {
        return true;
    }

    @Override
    public ItemClasses getItemClass() {
        return ItemClasses.STICK;
    }


    @Override
    public int getAttackDamage() {
        return 2;
    }

    @Override
    public String getItemName() {
        return "Stick";
    }

    @Override
    public int attackEnergyUse() {
        return 3;
    }

    @Override
    public boolean canBeEquipped() {
        return true;
    }

    @Override
    public AreaClasses[] getAreaSpawns() {
        //Areas that item can be looted from
        AreaClasses[] s = {AreaClasses.GRASSLAND, AreaClasses.SNOWY, AreaClasses.TOWN, AreaClasses.DUNGEON, AreaClasses.MOUNTAIN, AreaClasses.FOREST};
        return s;
    }

    @Override
    public int[] getAreaChances() {
        //Chances to get item from area out of 100 (In same order as getAreaLoots)
        int[] c = {6, 4, 7, 2, 1, 15};
        return c;
    }

    @Override
    public int getSpawnCount() {
        return 7;
    }

    @Override
    public boolean isTool() {
        return false;
    }

    @Override
    public Integer getHarvestLevel() {
        return 0;
    }

    @Override
    public ToolClasses[] getToolClasses() {
        return new ToolClasses[0];
    }

    @Override
    public Integer getToolDamage() {
        return null;
    }

    @Override
    public boolean canSpawn() {
        return true;
    }

    @Override
    public boolean isFood() {
        return false;
    }

    @Override
    public int[] getMinAndMaxFoodValue() {
        int[] c = {1, 1};
        return c;
    }
}
