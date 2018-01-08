package org.artsicleprojects.textadventure.Items;


import static org.artsicleprojects.textadventure.Areas.InitAreas.*;

import org.artsicleprojects.textadventure.Areas.Area;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Enums.ToolClasses;
import org.artsicleprojects.textadventure.Reference;

public class SharpStick implements Item
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
		return ItemClasses.SHARP_STICK;
	}

	@Override
	public int getAttackDamage()
	{
		return 4;
	}

	@Override
	public String getItemName()
	{
		return "SharpStick";
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
		Area[] l = {MOUNTAINS,SNOWY,GRASSLANDS,TOWN,FOREST,DUNGEON};
		return l;
	}

	@Override
	public int[] getAreaChances()
	{
		int[] c = {6,8,9,6,16,4};
		return c;
	}

    @Override
    public int getSpawnCount() {
        return 4;
    }

	@Override
	public boolean isTool() {
		return false;
	}

	@Override
	public float getCost() {
		return 0.1f;
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
		return false;
	}

	@Override
	public int[] getMinAndMaxFoodValue()
	{
		return new int[0];
	}
}
