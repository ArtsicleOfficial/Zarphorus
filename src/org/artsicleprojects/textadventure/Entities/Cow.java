package org.artsicleprojects.textadventure.Entities;

import org.artsicleprojects.textadventure.AreaCreatables.InventoryItem;
import org.artsicleprojects.textadventure.Enums.AreaClasses;
import org.artsicleprojects.textadventure.Enums.EntityClasses;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Reference;

import java.util.Random;


import static org.artsicleprojects.textadventure.Areas.InitAreas.*;

/**
 * Created by Artsicle on 12/20/2017.
 */
public class Cow implements Entity
{
	@Override
	public Integer attackDamage()
	{
		return new Random().nextInt(4-2)+2;
	}

	@Override
	public Integer maxHealth()
	{
		return 30;
	}

	@Override
	public Integer minHealth()
	{
		return 0;
	}

	@Override
	public Boolean attacksPlayer()
	{
		return true;
	}

	@Override
	public Boolean dropsItem()
	{
		return true;
	}

	@Override
	public String getEntityName()
	{
		return "Cow";
	}

	@Override
	public Boolean canSpawn()
	{
		return true;
	}

	@Override
	public EntityClasses getEntityClass() {
		return EntityClasses.COW;
	}

	@Override
	public InventoryItem dropItemOnDeath()
	{
		return new InventoryItem(new Random().nextInt(2-1)+1, ItemClasses.STEAK);
	}

	@Override
	public Boolean alwaysSpawnsAtNight() {
		return false;
	}

	@Override
	public AreaClasses[] getAreaSpawns()
	{
		AreaClasses[] s = {AreaClasses.FOREST,AreaClasses.GRASSLAND,AreaClasses.TOWN,AreaClasses.SNOWY,AreaClasses.MOUNTAIN};
		return s;
	}

	@Override
	public Integer[] getAreaChances()
	{
		int a = 10;
		Integer[] c = {a+2,a+4,a+1,a+1,a+1};
		return c;
	}

	@Override
	public Integer getSpawnCount() {
		return 5;
	}

	@Override
	public Boolean autoAttacksPlayer() {
		return false;
	}

	@Override
	public Float getMoneyOnDeath() {
		return 0f;
	}

	@Override
	public Integer getXpOnDeath()
	{
		return new Random().nextInt(6-2)+2;
	}
}
