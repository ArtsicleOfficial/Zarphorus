package org.artsicleprojects.textadventure.Mineables;

import org.artsicleprojects.textadventure.AreaCreatables.InventoryItem;
import org.artsicleprojects.textadventure.Areas.Area;
import org.artsicleprojects.textadventure.Areas.InitAreas;
import org.artsicleprojects.textadventure.Enums.AreaClasses;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Enums.MineableClasses;
import org.artsicleprojects.textadventure.Enums.ToolClasses;
import org.artsicleprojects.textadventure.Items.InitItems;
import org.artsicleprojects.textadventure.Items.Item;
import org.artsicleprojects.textadventure.Reference;

public class Rock implements Mineable {
    @Override
    public String getName() {
        return "Boulder";
    }

    @Override
    public Integer getMinimumHarvestLevel() {
        return 1;
    }

    @Override
    public MineableClasses getMineableClass() {
        return MineableClasses.BOULDER;
    }

    @Override
    public ToolClasses[] getToolClasses() {
        return new ToolClasses[]{ToolClasses.PICKAXE};
    }

    @Override
    public ItemClasses getDrop() {
        return ItemClasses.ROCK;
    }

    @Override
    public Boolean canSpawn() {
        return true;
    }

    @Override
    public Integer getMaxDurability() {
        return 150;
    }

    @Override
    public Integer getMinDurability() {
        return 100;
    }


    @Override
    public Integer getSpawnCount() {
        return 3;
    }

    @Override
    public AreaClasses[] getAreaSpawns() {
        return new AreaClasses[]{AreaClasses.GRASSLAND,AreaClasses.FOREST,AreaClasses.TOWN,AreaClasses.DESERT,AreaClasses.MOUNTAIN,AreaClasses.SWAMP,AreaClasses.SNOWY};
    }

    @Override
    public Integer[] getAreaChances() {
        return new Integer[]{9,6,3,7,15,5,2};
    }
}
