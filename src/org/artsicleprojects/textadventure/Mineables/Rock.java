package org.artsicleprojects.textadventure.Mineables;

import org.artsicleprojects.textadventure.AreaCreatables.InventoryItem;
import org.artsicleprojects.textadventure.Areas.Area;
import org.artsicleprojects.textadventure.Areas.InitAreas;
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
    public String getHarvestLevels() {
        return "$1";//$ + number = currTool >= number-
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
    public Item getDrop() {
        return InitItems.ROCK;
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
    public Area[] getAreaSpawns() {
        return new Area[]{InitAreas.GRASSLANDS,InitAreas.FOREST,InitAreas.TOWN,InitAreas.DESERT,InitAreas.MOUNTAINS,InitAreas.SWAMP,InitAreas.SNOWY};
    }

    @Override
    public Integer[] getAreaChances() {
        return new Integer[]{9,6,3,7,15,5,2};
    }
}
