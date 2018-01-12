package org.artsicleprojects.textadventure.Commands;

import org.artsicleprojects.textadventure.Area;
import org.artsicleprojects.textadventure.Main;
import org.artsicleprojects.textadventure.Player;
import org.artsicleprojects.textadventure.Reference;

public class Walk implements Command
{
    @Override
    public String[] getCommand()
    {
        return new String[]{"walk"};
    }

    @Override
    public boolean commandPerformed( String[] args )
    {
        if( Player.tryRemoveEnergy(Reference.WALK_ENERGY_REMOVAL)) {
            Area.newArea();
            Main.addText("Walked to new area, '" + Area.currentArea.getName() + "'");
            Main.addText(Reference.WALK_ENERGY_REMOVAL + " energy removed from player");
            return true;
        }
        return false;
    }

    @Override
    public String getCommandFailMessage()
    {
        return "Walk requires " + Reference.WALK_ENERGY_REMOVAL + " energy.";
    }

    @Override
    public String getHelpMessage() {
        return "Walk to a new area";
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
