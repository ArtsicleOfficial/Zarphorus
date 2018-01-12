package org.artsicleprojects.textadventure.Commands;

import org.artsicleprojects.textadventure.AreaCreatables.InventoryItem;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Items.ItemHandler;
import org.artsicleprojects.textadventure.Main;
import org.artsicleprojects.textadventure.Player;
import org.artsicleprojects.textadventure.Reference;

public class Cheatcode implements Command
{

    @Override
    public String[] getCommand()
    {
        return new String[]{"cheatcode"};
    }

    @Override
    public boolean commandPerformed( String[] args )
    {

        Main.addTexts(
                "Donald's command is not meant to be known",
                "on my watch! You do know it, although",
                "not many people know about this, but",
                "a lot of people might if they decompile the code.",
                "Lots of people don't decompile, so I think it'll be fine. Well, im",
                "done,",
                "",
                "To die, or not to die... that is the question,",
                "reclusively, I do not say anything,",
                "Unless... There is a third option.",
                "my mind is trying to correlate this all into what a cheatcode could be...",
                "putin might've known.."
        );
        if(args[0] != Reference.NO_ARGUMENTS_MESSAGE) {
            String allArgs = "";
            for(int i=0;i<args.length;i++) {
                allArgs+=args[i];
            }
            allArgs = allArgs.replace(" ","");
            if(allArgs.equalsIgnoreCase("donaldtrump")) {
                Main.addTexts("...",
                        "What!?",
                        "How did you know!",
                        " + 1 " + ItemHandler.getItemByClass(ItemClasses.GOD_ITEM).getItemName());
                Player.addInventoryItem(new InventoryItem(1,ItemClasses.GOD_ITEM));
                return true;
            } else if(allArgs.equalsIgnoreCase("nitup")) {
                Main.addText("Dead");
                Player.dead = true;
            } else if(allArgs.equalsIgnoreCase("fsadud")) {
                Player.addEnergy(999);
            } else if(allArgs.equalsIgnoreCase("picknick")) {
                Player.addInventoryItem(new InventoryItem(1,ItemClasses.WOODEN_PICKAXE));
            }
        }
        return false;
    }

    @Override
    public String getCommandFailMessage()
    {
        return "wait.. what? You weren't suposed to know of this command.";
    }

    @Override
    public String getHelpMessage() {
        return null;
    }

    @Override
    public boolean isGameInteractionCommand() {
        return false;
    }

    @Override
    public boolean canUseIfDead() {
        return true;
    }
}
