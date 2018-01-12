package org.artsicleprojects.textadventure.Items;

import org.artsicleprojects.textadventure.Enums.AreaClasses;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Enums.ToolClasses;

public class Flesh implements Item {
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
        return ItemClasses.FLESH;
    }

    @Override
    public int getAttackDamage() {
        return 1;
    }

    @Override
    public String getItemName() {
        return "Flesh";
    }

    @Override
    public int attackEnergyUse() {
        return 7;
    }

    @Override
    public boolean canBeEquipped() {
        return true;
    }

    @Override
    public AreaClasses[] getAreaSpawns() {
        return new AreaClasses[]{AreaClasses.DUNGEON};
    }

    @Override
    public int[] getAreaChances() {
        return new int[]{1};
    }

    @Override
    public int getSpawnCount() {
        return 2;
    }

    @Override
    public float getCost() {
        return 2f;
    }

    @Override
    public boolean canBeSold() {
        return true;
    }

    @Override
    public boolean canBeBought() {
        return true;
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
        return false;
    }

    @Override
    public boolean isFood() {
        return true;
    }

    @Override
    public int[] getMinAndMaxFoodValue() {
        return new int[]{2,4};
    }
}
