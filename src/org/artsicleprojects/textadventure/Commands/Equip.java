package org.artsicleprojects.textadventure.Commands;

import org.artsicleprojects.textadventure.AreaCreatables.InventoryItem;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Items.ItemHandler;
import org.artsicleprojects.textadventure.Main;
import org.artsicleprojects.textadventure.Player;
import org.artsicleprojects.textadventure.Reference;

public class Equip implements Command
{
    @Override
    public String[] getCommand()
    {
        return new String[]{"equip"};
    }

    @Override
    public boolean commandPerformed( String[] args )
    {
        if ( ! args[0].equalsIgnoreCase(Reference.NO_ARGUMENTS_MESSAGE) )
        {
            if ( args.length == 1 )
            {
                if ( ItemHandler.getItemByName(args[0]) != null )
                {
                    if ( ItemHandler.getItemByName(args[0]).canBeEquipped() )
                    {
                        boolean itemEquipped = false;
                        for ( int i = 0 ; i < Player.inventory.size() ; i++ )
                        {
                            if ( Player.inventory.get(i).COUNT >= 1 )
                            {
                                if ( Player.inventory.get(i).ITEM_CLASS.getID() != ItemClasses.AIR.getID() )
                                {
                                    if ( ItemHandler.getItemByInventoryItem(Player.inventory.get(i)).getItemName().equalsIgnoreCase(args[0]))
                                    {
                                        Player.equippedItem = Player.inventory.get(i);
                                        Player.inventory.remove(i);
                                        if ( Player.inventory.size() <= 0 )
                                        {
                                            Player.inventory.add(new InventoryItem(1 , ItemClasses.AIR));
                                        }
                                        Main.addText("Equipped " + ItemHandler.getItemByName(args[0]).getItemName() + "");
                                        itemEquipped = true;
                                    }
                                }
                            }
                        }
                        if ( ! itemEquipped )
                        {

                            if ( ItemHandler.getItemByName(args[0]) == null )
                            {
                                Main.addText("You do not have '" + args[0] + "' in your inventory");
                            } else
                            {
                                Main.addText("You do not have '" + ItemHandler.getItemByName(args[0]).getItemName() + "' in your inventory");
                            }

                            Main.addText("Type 'inventory' to check your inventory");
                        }
                    } else
                    {
                        Main.addText("Item '" + ItemHandler.getItemByName(args[0]).getItemName() + "' cannot be equipped");
                    }
                }
            } else
            {
                Main.addText("Item with name '" + args[0] + "' doesn't exist");
            }

            return true;
        }
        return false;
    }

    @Override
    public String getCommandFailMessage()
    {
        return "USAGE: equip <##itemname>";
    }

    @Override
    public String getHelpMessage() {
        return "Equips item specified";
    }

    @Override
    public boolean isGameInteractionCommand() {
        return true;
    }

    @Override
    public boolean canUseIfDead() {
        return false;
    }
}
