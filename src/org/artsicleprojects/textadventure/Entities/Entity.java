package org.artsicleprojects.textadventure.Entities;

import org.artsicleprojects.textadventure.Areas.Area;
import org.artsicleprojects.textadventure.AreaCreatables.InventoryItem;
import org.artsicleprojects.textadventure.Enums.EntityClasses;

public interface Entity
{
    public Integer attackDamage();
    public Integer maxHealth();
    public Integer minHealth();
    public Boolean attacksPlayer();
    public Boolean dropsItem();

    public String getEntityName();

    public Boolean canSpawn();

    public EntityClasses getEntityClass();
    public InventoryItem dropItemOnDeath();

    public Area[] getAreaSpawns();
    public Integer[] getAreaChances();
    public Integer getSpawnCount();

    public Integer getXpOnDeath();
}
