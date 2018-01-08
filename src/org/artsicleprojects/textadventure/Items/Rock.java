package org.artsicleprojects.textadventure.Items;

import org.artsicleprojects.textadventure.Areas.Area;
import org.artsicleprojects.textadventure.Areas.InitAreas;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Enums.ToolClasses;
import org.artsicleprojects.textadventure.Reference;

public class Rock implements Item {
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
        return false;
    }

    @Override
    public ItemClasses getItemClass() {
        return ItemClasses.ROCK;
    }

    @Override
    public int getAttackDamage() {
        return 4;
    }

    @Override
    public String getItemName() {
        return "Rock";
    }

    @Override
    public int attackEnergyUse() {
        return 4;
    }

    @Override
    public boolean canBeEquipped() {
        return true;
    }

    @Override
    public Area[] getAreaSpawns() {
        return new Area[]{InitAreas.GRASSLANDS,InitAreas.TOWN,InitAreas.FOREST,InitAreas.SWAMP,InitAreas.SNOWY,InitAreas.MOUNTAINS,InitAreas.DUNGEON,InitAreas.DESERT};
    }

    @Override
    public int[] getAreaChances() {
        return new int[]{5,6,7,6,4,7,5,4};
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
    public ToolClasses[] getToolClasses() {
        return new ToolClasses[0];
    }

    @Override
    public Integer getToolDamage() {
        return null;
    }

    @Override
    public boolean canSpawn() {
        return false;
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
