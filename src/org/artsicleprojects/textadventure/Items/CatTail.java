package org.artsicleprojects.textadventure.Items;

import org.artsicleprojects.textadventure.Areas.Area;
import org.artsicleprojects.textadventure.Areas.InitAreas;
import org.artsicleprojects.textadventure.Enums.AreaClasses;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Enums.ToolClasses;
import org.artsicleprojects.textadventure.Reference;

public class CatTail implements Item {
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
    public ItemClasses getItemClass() {
        return ItemClasses.CATTAIL;
    }

    @Override
    public int getAttackDamage() {
        return 0;
    }

    @Override
    public String getItemName() {
        return "CatTail";
    }

    @Override
    public int attackEnergyUse() {
        return 0;
    }

    @Override
    public float getCost() {
        return 4f;
    }

    @Override
    public boolean canBeSold() {
        return true; //Can be sold to the player?
    }

    @Override
    public boolean canBeBought() {
        return false; //Can be sold to the shopkeeper?
    }

    @Override
    public boolean canBeEquipped() {
        return false;
    }

    @Override
    public AreaClasses[] getAreaSpawns() {
        return new AreaClasses[]{AreaClasses.SWAMP,AreaClasses.FOREST};
    }

    @Override
    public int[] getAreaChances() {
        return new int[]{25,13};
    }

    @Override
    public int getSpawnCount() {
        return 6;
    }

    @Override
    public boolean isTool() {
        return false;
    }

    @Override
    public Integer getHarvestLevel() {
        return null;
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
        return new int[0];
    }
}
