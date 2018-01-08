package org.artsicleprojects.textadventure.Commands;

import org.artsicleprojects.textadventure.Items.ItemHandler;
import org.artsicleprojects.textadventure.Main;
import org.artsicleprojects.textadventure.Player;

public class Inventory implements Command
{
    @Override
    public String[] getCommand()
    {
        return new String[]{"inventory"};
    }

    @Override
    public boolean commandPerformed( String[] args )
    {
        if(Player.equippedItem == null) {
            Main.addText("Equipped Item: NONE");
        } else {
            Main.addText("Equipped Item: " + ItemHandler.getItemByInventoryItem(Player.equippedItem).getItemName());
        }

        if(Player.inventory.size() >= 1) {
            for(int i = 0; i < Player.inventory.size(); i++)
            {
                if(Player.inventory.get(i) != null) {
                    Main.addText(Player.inventory.get(i).COUNT + " * " + ItemHandler.getItemByInventoryItem(Player.inventory.get(i)).getItemName());
                }

            }
        } else {
            Main.addText("Inventory is empty");
        }

        return true;
    }

    @Override
    public String getCommandFailMessage()
    {
        return "USAGE: inventory";
    }

    @Override
    public String getHelpMessage() {
        return "Views your inventory";
    }

    @Override
    public boolean canUseIfDead() {
        return true;
    }
}
