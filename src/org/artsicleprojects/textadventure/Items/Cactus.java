package org.artsicleprojects.textadventure.Items;

import org.artsicleprojects.textadventure.Areas.Area;
import org.artsicleprojects.textadventure.Enums.AreaClasses;
import org.artsicleprojects.textadventure.Enums.GameMessages;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Enums.ToolClasses;
import org.artsicleprojects.textadventure.Main;
import org.artsicleprojects.textadventure.Player;
import org.artsicleprojects.textadventure.Reference;

public class Cactus implements Item {
    @Override
    public void ItemUsed() {
        handleCactus();
    }

    @Override
    public void ItemEquipped() {
        handleCactus();
    }

    private void handleCactus() {
        Player.removePlayerHealth(4);
        GameMessages.touchingItemHurts.Reset();
        GameMessages.touchingItemHurts.SetItem(this);
        GameMessages.touchingItemHurts.PrintMessage();
        GameMessages.loseHealth.SetLoss(4f);
        GameMessages.loseHealth.PrintMessage();
    }

    @Override
    public void ItemDropped() {
        handleCactus();
    }

    @Override
    public void ItemPickedUp() {
        handleCactus();
    }

    @Override
    public ItemClasses getItemClass() {
        return ItemClasses.CACTUS;
    }

    @Override
    public int getAttackDamage() {
        return 9;
    }

    @Override
    public String getItemName() {
        return "Cactus";
    }

    @Override
    public int attackEnergyUse() {
        return 16;
    }

    @Override
    public boolean canBeEquipped() {
        return true;
    }

    @Override
    public AreaClasses[] getAreaSpawns() {
        return new AreaClasses[0];
    }

    @Override
    public int[] getAreaChances() {
        return new int[0];
    }

    @Override
    public int getSpawnCount() {
        return 0;
    }

    @Override
    public float getCost() {
        return 5f;
    }

    @Override
    public boolean canBeSold() {
        return true;
    }

    @Override
    public boolean canBeBought() {
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
    public boolean canSpawn() {
        return false;
    }

    @Override
    public boolean isFood() {
        return false;
    }

    @Override
    public int[] getMinAndMaxFoodValue() {
        return new int[0];
    }
}
