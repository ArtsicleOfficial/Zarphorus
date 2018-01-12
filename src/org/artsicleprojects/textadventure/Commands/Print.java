package org.artsicleprojects.textadventure.Commands;

import org.artsicleprojects.textadventure.Main;
import org.artsicleprojects.textadventure.Reference;

public class Print implements Command
{

    @Override
    public String[] getCommand()
    {
        return new String[]{"print"};
    }

    @Override
    public boolean commandPerformed( String[] args )
    {
        if(args == null) {
            return false;
        }
        if(args[0].equalsIgnoreCase(Reference.NO_ARGUMENTS_MESSAGE)) {
            return false;
        } else {
            String s = "";
            for(int i = 0; i < args.length; i++) {
                s+=args[i] + " ";
            }
            Main.addText(s);
            return true;
        }
    }

    @Override
    public String getCommandFailMessage()
    {
        return "USAGE: print <text>";
    }

    @Override
    public String getHelpMessage() {
        return "Prints specified arguments";
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
