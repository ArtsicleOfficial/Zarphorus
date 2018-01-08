package org.artsicleprojects.textadventure.Commands;

import org.artsicleprojects.textadventure.Area;
import org.artsicleprojects.textadventure.Main;
import org.artsicleprojects.textadventure.Player;
import org.artsicleprojects.textadventure.Reference;

public class Step implements Command
{
    @Override
    public String[] getCommand()
    {
        return new String[]{"step"};
    }

    @Override
    public boolean commandPerformed( String[] args )
    {
        if( Player.tryRemoveEnergy(Reference.STEP_ENERGY_REMOVAL)) {
            Area.walkToSameArea();
            Main.addText("Poked around in current area, '" + Area.currentArea.getName() + "'");
            Main.addText(Reference.STEP_ENERGY_REMOVAL + " energy removed from player");
            return true;
        }
        return false;
    }

    @Override
    public String getCommandFailMessage()
    {
        return "Step requires " + Reference.STEP_ENERGY_REMOVAL + " energy.";
    }

    @Override
    public String getHelpMessage() {
        return "Poke around in the current area without going to a new one";
    }

    @Override
    public boolean canUseIfDead() {
        return false;
    }
}
