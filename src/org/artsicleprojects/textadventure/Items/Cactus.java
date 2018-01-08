package org.artsicleprojects.textadventure.Items;

import org.artsicleprojects.textadventure.Areas.Area;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Enums.ToolClasses;
import org.artsicleprojects.textadventure.Main;
import org.artsicleprojects.textadventure.Player;
import org.artsicleprojects.textadventure.Reference;

public class Cactus implements Item {
    @Override
    public void ItemUsed() {
        Player.removePlayerHealth(4);
        Main.addText("Touching that cactus hurts");
        Main.addText("- 4 Health (" + Player.playerHealth + "/" + Player.maxPlayerHealth + ")");
    }

    @Override
    public void ItemEquipped() {
        Player.removePlayerHealth(4);
        Main.addText("Touching that cactus hurts");
        Main.addText("- 4 Health (" + Player.playerHealth + "/" + Player.maxPlayerHealth + ")");
    }

    @Override
    public void ItemDropped() {
        Player.removePlayerHealth(4);
        Main.addText("Touching that cactus hurts");
        Main.addText("- 4 Health (" + Player.playerHealth + "/" + Player.maxPlayerHealth + ")");
    }

    @Override
    public void ItemPickedUp() {
        Player.removePlayerHealth(4);
        Main.addText("Touching that cactus hurts.");
        Main.addText("- 4 Health (" + Player.playerHealth + "/" + Player.maxPlayerHealth + ")");
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
        return 0;
    }

    @Override
    public boolean canBeEquipped() {
        return true;
    }

    @Override
    public Area[] getAreaSpawns() {
        return new Area[0];
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
