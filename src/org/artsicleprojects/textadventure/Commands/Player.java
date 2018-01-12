package org.artsicleprojects.textadventure.Commands;

import org.artsicleprojects.textadventure.Items.ItemHandler;
import org.artsicleprojects.textadventure.Main;
import org.artsicleprojects.textadventure.Reference;

public class Player implements Command
{
    @Override
    public String[] getCommand()
    {
        return new String[]{"player","self"};
    }

    @Override
    public boolean isGameInteractionCommand() {
        return true;
    }

    @Override
    public boolean commandPerformed( String[] args )
    {
        Integer itemSizeCount = 0;
        for(int l = 0; l < org.artsicleprojects.textadventure.Player.inventory.size();l++) {
            itemSizeCount += org.artsicleprojects.textadventure.Player.inventory.get(l).COUNT;
        }
        if(org.artsicleprojects.textadventure.Player.equippedItem != null) {
            itemSizeCount += org.artsicleprojects.textadventure.Player.equippedItem.COUNT;
        }
        Main.addTexts("Item Count: " + itemSizeCount,
                "Health: " + org.artsicleprojects.textadventure.Player.playerHealth + "/" + org.artsicleprojects.textadventure.Player.maxPlayerHealth,
                "Energy: " + org.artsicleprojects.textadventure.Player.playerEnergy + "/" +org.artsicleprojects.textadventure.Player.maxPlayerEnergy,
                "",
                "Experience: " +org.artsicleprojects.textadventure.Player.xpPoints + "/" +org.artsicleprojects.textadventure.Player.getNextLevelXp(),
                "Level: " + org.artsicleprojects.textadventure.Player.level,
                "",
                "Money: " + Reference.CURRENCY_SYMBOL + String.valueOf(org.artsicleprojects.textadventure.Player.playerMoney));
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
