package org.artsicleprojects.textadventure.Items;

import org.artsicleprojects.textadventure.Areas.Area;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Enums.ToolClasses;

public interface Item
{
    public void ItemUsed();
    public void ItemEquipped();
    public void ItemDropped();
    public void ItemPickedUp();
    public ItemClasses getItemClass();

    public int getAttackDamage();
    public String getItemName();
    public int attackEnergyUse();

    public boolean canBeEquipped();

    public Area[] getAreaSpawns();
    public int[] getAreaChances();
    public int getSpawnCount();

    public float getCost();
    public boolean canBeSold();
    public boolean canBeBought();

    public boolean isTool();
    public ToolClasses[] getToolClasses();
    public Integer getToolDamage();

    public boolean canSpawn();


    public boolean isFood();
    public int[] getMinAndMaxFoodValue();

}
