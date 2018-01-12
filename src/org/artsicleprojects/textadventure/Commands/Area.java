package org.artsicleprojects.textadventure.Commands;

import org.artsicleprojects.textadventure.Main;

public class Area implements Command {
    @Override
    public String[] getCommand() {
        return new String[]{"Area","Time","Biome"};
    }

    @Override
    public boolean commandPerformed(String[] args) {
        Main.addText("Area: " + org.artsicleprojects.textadventure.Area.currentArea.getName());
        Main.addText("Time: " +org.artsicleprojects.textadventure.Area.gameTime.toString());
        return true;
    }

    @Override
    public String getCommandFailMessage() {
        return "USAGE: area";
    }

    @Override
    public String getHelpMessage() {
        return "Returns area info such as your current area, and time.";
    }

    @Override
    public boolean isGameInteractionCommand() {
        return false;
    }

    @Override
    public boolean canUseIfDead() {
        return false;
    }
}
