package org.artsicleprojects.textadventure.Commands;

import org.artsicleprojects.textadventure.Area;
import org.artsicleprojects.textadventure.Main;

import java.util.Random;

public class Loot implements Command
{

    @Override
    public String[] getCommand()
    {
        return new String[]{"loot","take"};
    }

    @Override
    public boolean commandPerformed( String[] args )
    {
        Area.lootArea();
        Main.addText("Looted area");
        return true;
    }

    @Override
    public String getCommandFailMessage()
    {
        return "USAGE: loot";
    }

    @Override
    public String getHelpMessage() {
        return "Loots area";
    }

    @Override
    public boolean canUseIfDead() {
        return false;
    }
}
