package org.artsicleprojects.textadventure.Commands;

import org.artsicleprojects.textadventure.Items.ItemHandler;
import org.artsicleprojects.textadventure.Main;

public class Player implements Command
{
    @Override
    public String[] getCommand()
    {
        return new String[]{"player","self"};
    }

    @Override
    public boolean commandPerformed( String[] args )
    {
        Integer itemSizeCount = 0;
        for(int l = 0; l < org.artsicleprojects.textadventure.Player.inventory.size();l++) {
            itemSizeCount += org.artsicleprojects.textadventure.Player.inventory.get(l).COUNT;
        }
        Main.addText("Inventory Size: " + org.artsicleprojects.textadventure.Player.inventory.size());
        Main.addText("Inventory Item Count: " + itemSizeCount);
        Main.addText("Energy: " + org.artsicleprojects.textadventure.Player.playerEnergy + "/" + org.artsicleprojects.textadventure.Player.maxPlayerEnergy);
        Main.addText("Level: " + org.artsicleprojects.textadventure.Player.level);
        Main.addText("Experience: " + org.artsicleprojects.textadventure.Player.xpPoints + "/" + org.artsicleprojects.textadventure.Player.getNextLevelXp());
        Main.addText("Health: " + org.artsicleprojects.textadventure.Player.playerHealth);
        if(org.artsicleprojects.textadventure.Player.equippedItem == null) {
            Main.addText("Equipped Item: Empty");
        } else {
            Main.addText("Equipped Item: " + ItemHandler.getItemByInventoryItem(org.artsicleprojects.textadventure.Player.equippedItem).getItemName());
        }
        return true;
    }

    @Override
    public String getCommandFailMessage()
    {
        return "USAGE: player";
    }

    @Override
    public String getHelpMessage() {
        return "Views player status";
    }

    @Override
    public boolean canUseIfDead() {
        return true;
    }
}
