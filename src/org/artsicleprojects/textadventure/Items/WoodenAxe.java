package org.artsicleprojects.textadventure.Items;

import org.artsicleprojects.textadventure.Areas.Area;
import org.artsicleprojects.textadventure.Enums.AreaClasses;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Enums.ToolClasses;
import org.artsicleprojects.textadventure.Reference;

import javax.tools.Tool;

public class WoodenAxe implements Item {
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
        return ItemClasses.WOODEN_AXE;
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
    public int getAttackDamage() {
        return 4;
    }

    @Override
    public String getItemName() {
        return "WoodenAxe";
    }

    @Override
    public int attackEnergyUse() {
        return 6;
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
    public boolean isTool() {
        return true;
    }

    @Override
    public Integer getHarvestLevel() {
        return 1;
    }

    @Override
    public ToolClasses[] getToolClasses() {
        return new ToolClasses[]{ToolClasses.AXE};
    }

    @Override
    public Integer getToolDamage() {
        return 4;
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
