package org.artsicleprojects.textadventure.Items;

import org.artsicleprojects.textadventure.Areas.Area;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Enums.ToolClasses;
import org.artsicleprojects.textadventure.Reference;

public class ChickenBreast implements Item {
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
        return ItemClasses.CHICKEN_BREAST;
    }

    @Override
    public int getAttackDamage() {
        return 1;
    }

    @Override
    public String getItemName() {
        return "ChickenBreast";
    }

    @Override
    public int attackEnergyUse() {
        return 5;
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
    public boolean isTool() {
        return false;
    }

    @Override
    public ToolClasses[] getToolClasses() {
        return new ToolClasses[0];
    }

    @Override
    public float getCost() {
        return 10f;
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
        return new int[]{30,37};
    }
}
