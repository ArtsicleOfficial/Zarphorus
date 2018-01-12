package org.artsicleprojects.textadventure.Items;

import org.artsicleprojects.textadventure.Areas.Area;
import org.artsicleprojects.textadventure.Enums.AreaClasses;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Enums.ToolClasses;
import org.artsicleprojects.textadventure.Reference;

import static org.artsicleprojects.textadventure.Areas.InitAreas.FOREST;

/**
 * Created by Artsicle on 12/18/2017.
 */
public class Bacon implements Item
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
	public ItemClasses getItemClass() {
		return ItemClasses.BACON;
	}

	@Override
	public int getAttackDamage()
	{
		return 1;
	}

	@Override
	public String getItemName()
	{
		return "Bacon";
	}

	@Override
	public int attackEnergyUse()
	{
		return 0;
	}

	@Override
	public boolean canBeEquipped()
	{
		return false;
	}

	@Override
	public AreaClasses[] getAreaSpawns()
	{
		AreaClasses[] s = {AreaClasses.FOREST};
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
	public boolean canBeBought() {
		return true;
	}

	@Override
	public float getCost() {
		return 10f;
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
		int[] v = {25, 35};
		return v;
	}
}
