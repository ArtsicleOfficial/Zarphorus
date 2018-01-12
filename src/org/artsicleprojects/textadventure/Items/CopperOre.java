package org.artsicleprojects.textadventure.Items;

import org.artsicleprojects.textadventure.Areas.Area;
import org.artsicleprojects.textadventure.Enums.AreaClasses;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Enums.ToolClasses;

public class CopperOre implements Item {
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
        return ItemClasses.COPPER_ORE;
    }

    @Override
    public int getAttackDamage() {
        return 5;
    }

    @Override
    public String getItemName() {
        return "CopperOre";
    }

    @Override
    public int attackEnergyUse() {
        return 8;
    }

    @Override
    public boolean canBeEquipped() {
        return true;
    }

    @Override
    public AreaClasses[] getAreaSpawns() {
        return new AreaClasses[0];
    }

    @Override
    public int[] getAreaChances() {
        return new int[0];
    }

    @Override
    public int getSpawnCount() {
        return 0;
    }

    @Override
    public float getCost() {
        return 20;
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
        return false;
    }

    @Override
    public int[] getMinAndMaxFoodValue() {
        return new int[0];
    }
}
