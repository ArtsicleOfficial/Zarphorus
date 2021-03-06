package org.artsicleprojects.textadventure.Mineables;

import org.artsicleprojects.textadventure.AreaCreatables.InventoryItem;
import org.artsicleprojects.textadventure.Areas.Area;
import org.artsicleprojects.textadventure.Enums.AreaClasses;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Enums.MineableClasses;
import org.artsicleprojects.textadventure.Enums.ToolClasses;
import org.artsicleprojects.textadventure.Items.Item;

public interface Mineable {

    public String getName();
    public Integer getMinimumHarvestLevel();
    public ToolClasses[] getToolClasses();

    public ItemClasses getDrop();

    public Boolean canSpawn();

    public MineableClasses getMineableClass();

    public Integer getMaxDurability();
    public Integer getMinDurability();
    public Integer getSpawnCount();
    public Integer[] getAreaChances();

    public AreaClasses[] getAreaSpawns();
}
