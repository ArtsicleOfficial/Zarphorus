package org.artsicleprojects.textadventure.Items;

import org.artsicleprojects.textadventure.Areas.InitAreas;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Enums.ToolClasses;
import org.artsicleprojects.textadventure.Reference;

public class GodItem implements Item
{
    @Override
    public void ItemUsed()
    {

    }

    @Override
    public void ItemEquipped()
    {

    }

    @Override
    public void ItemDropped()
    {

    }

    @Override
    public void ItemPickedUp()
    {

    }

    @Override
    public ItemClasses getItemClass()
    {
        return ItemClasses.GOD_ITEM;
    }

    @Override
    public int getAttackDamage()
    {
        return 999;
    }

    @Override
    public String getItemName()
    {
        return "GodItem";
    }

    @Override
    public int attackEnergyUse()
    {
        return 1;
    }

    @Override
    public boolean canBeEquipped()
    {
        return true;
    }

    @Override
    public org.artsicleprojects.textadventure.Areas.Area[] getAreaSpawns()
    {

        return new org.artsicleprojects.textadventure.Areas.Area[] {InitAreas.FOREST};
    }

    @Override
    public int[] getAreaChances()
    {
        return new int[]{0};
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
    public float getCost() {
        return 99999f;
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
    public ToolClasses[] getToolClasses() {
        return new ToolClasses[0];
    }

    @Override
    public Integer getToolDamage() {
        return 9;
    }

    @Override
    public boolean canSpawn()
    {
        return false;
    }

    @Override
    public boolean isFood()
    {
        return true;
    }

    @Override
    public int[] getMinAndMaxFoodValue()
    {
        return new int[]{999,999};
    }
}
