package org.artsicleprojects.textadventure.Mineables;

import org.artsicleprojects.ArtUtils.ArtUtils;
import org.artsicleprojects.textadventure.AreaCreatables.InventoryItem;
import org.artsicleprojects.textadventure.Areas.Area;
import org.artsicleprojects.textadventure.Enums.AreaClasses;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Enums.MineableClasses;
import org.artsicleprojects.textadventure.Enums.ToolClasses;
import org.artsicleprojects.textadventure.Items.Item;

public class CopperDeposit implements Mineable {
    @Override
    public String getName() {
        return "CopperDeposit";
    }

    @Override
    public Integer getMinimumHarvestLevel() {
        return 2;
    }

    @Override
    public ToolClasses[] getToolClasses() {
        return new ToolClasses[]{ToolClasses.PICKAXE};
    }

    @Override
    public ItemClasses getDrop() {
        return ItemClasses.COPPER_ORE;
    }

    @Override
    public Boolean canSpawn() {
        return true;
    }

    @Override
    public MineableClasses getMineableClass() {
        return MineableClasses.COPPER_DEPOSIT;
    }

    @Override
    public Integer getMaxDurability() {
        return 70;
    }

    @Override
    public Integer getMinDurability() {
        return 50;
    }

    @Override
    public Integer getSpawnCount() {
        return 2;
    }

    @Override
    public Integer[] getAreaChances() {
        return new Integer[]{4};
    }

    @Override
    public AreaClasses[] getAreaSpawns() {
        return new AreaClasses[]{AreaClasses.CAVE};
    }
}
