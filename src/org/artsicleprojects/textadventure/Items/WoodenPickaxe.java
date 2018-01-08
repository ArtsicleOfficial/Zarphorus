package org.artsicleprojects.textadventure.Items;

import org.artsicleprojects.textadventure.Areas.Area;
import org.artsicleprojects.textadventure.Areas.InitAreas;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Enums.ToolClasses;
import org.artsicleprojects.textadventure.Reference;

public class WoodenPickaxe implements Item {
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
        return ItemClasses.WOODEN_PICKAXE;
    }

    @Override
    public int getAttackDamage() {
        return 4;
    }

    @Override
    public String getItemName() {
        return "WoodenPickaxe";
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
    public Area[] getAreaSpawns() {
        return new Area[0];
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
        return 20f;
    }

    @Override
    public boolean canBeSold() {
        return true;
    }

    @Override
    public boolean canBeBought() {
        return false;
    }

    @Override
    public boolean isTool() {
        return true;
    }

    public Integer getToolDamage() {
        return 3;
    }

    @Override
    public ToolClasses[] getToolClasses() {
        return new ToolClasses[]{ToolClasses.PICKAXE};
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
