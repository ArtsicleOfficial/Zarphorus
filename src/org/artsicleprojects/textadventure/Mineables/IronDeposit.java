package org.artsicleprojects.textadventure.Mineables;

import org.artsicleprojects.ArtUtils.ArtUtils;
import org.artsicleprojects.textadventure.Enums.AreaClasses;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Enums.MineableClasses;
import org.artsicleprojects.textadventure.Enums.ToolClasses;

public class IronDeposit implements Mineable {
    @Override
    public String getName() {
        return "IronDeposit";
    }

    @Override
    public Integer getMinimumHarvestLevel() {
        return 3;
    }

    @Override
    public ToolClasses[] getToolClasses() {
        return new ToolClasses[]{ToolClasses.PICKAXE};
    }

    @Override
    public ItemClasses getDrop() {
        return ItemClasses.IRON_ORE;
    }

    @Override
    public Boolean canSpawn() {
        return true;
    }

    @Override
    public MineableClasses getMineableClass() {
        return MineableClasses.IRON_DEPOSIT;
    }

    @Override
    public Integer getMaxDurability() {
        return 120;
    }

    @Override
    public Integer getMinDurability() {
        return 80;
    }

    @Override
    public Integer getSpawnCount() {
        return 2;
    }

    @Override
    public Integer[] getAreaChances() {
        return new Integer[]{5};
    }

    @Override
    public AreaClasses[] getAreaSpawns() {
        return new AreaClasses[]{AreaClasses.CAVE};
    }
}
