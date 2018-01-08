package org.artsicleprojects.textadventure.Items;

import org.artsicleprojects.textadventure.Areas.Area;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Enums.ToolClasses;
import org.artsicleprojects.textadventure.Reference;

import static org.artsicleprojects.textadventure.Areas.InitAreas.DUNGEON;
import static org.artsicleprojects.textadventure.Areas.InitAreas.TOWN;

public class Bread implements Item
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
        return ItemClasses.BREAD;
    }

    @Override
    public int getAttackDamage()
    {
        return 1;
    }

    @Override
    public String getItemName()
    {
        return "Bread";
    }

    @Override
    public int attackEnergyUse()
    {
        return 4;
    }

    @Override
    public boolean canBeEquipped()
    {
        return true;
    }

    @Override
    public Area[] getAreaSpawns()
    {
        Area[] s = {DUNGEON,TOWN};
        return s;
    }

    @Override
    public int[] getAreaChances()
    {
        int[] c = {1,2};
        return c;
    }

    @Override
    public int getSpawnCount() {
        return 0;
    }

    @Override
    public float getCost() {
        return 10f;
    }

    @Override
    public boolean canBeBought() {
        return true;
    }

    @Override
    public boolean canBeSold() {
        return true;
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
    public boolean canSpawn()
    {
        return true;
    }

    @Override
    public boolean isFood()
    {
        return true;
    }

    @Override
    public int[] getMinAndMaxFoodValue()
    {
        int[] v = {25,34};
        return v;
    }
}
