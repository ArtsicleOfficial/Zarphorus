package org.artsicleprojects.textadventure.Commands;

import org.artsicleprojects.textadventure.Items.Item;
import org.artsicleprojects.textadventure.Items.ItemHandler;
import org.artsicleprojects.textadventure.Main;
import org.artsicleprojects.textadventure.Player;
import org.artsicleprojects.textadventure.Reference;

public class Eat implements Command
{
    @Override
    public String[] getCommand()
    {
        return new String[]{"eat"};
    }

    @Override
    public boolean commandPerformed( String[] args )
    {
        if ( args[0] != Reference.NO_ARGUMENTS_MESSAGE )
        {
            for ( int i = 0 ; i < Player.inventory.size() ; i++ )
            {
                if ( Player.inventory.get(i).COUNT >= 1 )
                {
                    if ( ItemHandler.getItemByName(args[0]) != null )
                    {
                        Item item = ItemHandler.getItemByName(args[0]);
                        if ( item.isFood() )
                        {
                            Integer e = Player.eatFood(item);
                            if ( e != Reference.EMPTY_NUMBER )
                            {
                                Main.addText("Ate " + item.getItemName());
                                Main.addText("Restored " + e + " energy");
                            } else
                            {
                                Main.addText("Failed to eat item");
                            }
                        } else
                        {
                            Main.addText("Item '" + item.getItemName() + "' is not a food");
                        }
                    } else
                    {
                        Main.addText("Character Sequence '" + args[0] + "' is not an item");
                    }
                } else
                {
                    Main.addText("This item is not in your inventory.");
                }
                break;
            }
            return true;
        }
        return false;
    }

    @Override
    public String getCommandFailMessage()
    {
        return "USAGE: eat <##itemname>";
    }

    @Override
    public String getHelpMessage() {
        return "Eats item specified";
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
