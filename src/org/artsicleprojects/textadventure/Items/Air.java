package org.artsicleprojects.textadventure.Items;

import org.artsicleprojects.textadventure.Areas.Area;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Enums.ToolClasses;
import org.artsicleprojects.textadventure.Reference;

import static org.artsicleprojects.textadventure.Areas.InitAreas.FOREST;

public class Air implements Item
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
    public int getAttackDamage()
    {
        return 1;
    }

    @Override
    public String getItemName()
    {
        return "Air";
    }

    @Override
    public int attackEnergyUse()
    {
        return 1;
    }

    @Override
    public boolean canBeEquipped()
    {
        return false;
    }

    @Override
    public Area[] getAreaSpawns()
    {
        Area[] s = {FOREST};
        return s;
    }

    @Override
    public int[] getAreaChances()
    {
        int[] c = {0};
        return c;
    }

    @Override
    public int getSpawnCount() {
        return 0;
    }

    @Override
    public float getCost() {
        return 0;
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
        return ItemClasses.AIR;
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
        return 0;
    }

    @Override
    public boolean canSpawn()
    {
        return false;
    }

    @Override
    public boolean isFood()
    {
        return false;
    }

    @Override
    public int[] getMinAndMaxFoodValue()
    {
        return new int[0];
    }
}
