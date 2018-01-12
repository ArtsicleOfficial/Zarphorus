package org.artsicleprojects.textadventure.Commands;

import org.artsicleprojects.textadventure.Main;
import org.artsicleprojects.textadventure.Reference;

public class Variable implements Command {
    @Override
    public String[] getCommand() {
        return new String[]{"variable"};
    }

    @Override
    public boolean commandPerformed(String[] args) {
        if(!args[0].equalsIgnoreCase(Reference.NO_ARGUMENTS_MESSAGE)) {
            if(args.length == 1) {
                if(args[0].equalsIgnoreCase("launch_date")) {
                    Main.addText("Launch Date(Serialized): " + Main.launchDate.getTime());
                    Main.addText("Launch Date: " + Main.launchDate.toString());
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getCommandFailMessage() {
        return "USAGE: variable <##variablename>";
    }

    @Override
    public String getHelpMessage() {
        return "Developer Command";
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
