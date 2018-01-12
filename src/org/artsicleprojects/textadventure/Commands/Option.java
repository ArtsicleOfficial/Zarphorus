package org.artsicleprojects.textadventure.Commands;

import static org.artsicleprojects.textadventure.Functions.*;

import org.artsicleprojects.textadventure.Main;
import org.artsicleprojects.textadventure.Reference;

import java.awt.*;

public class Option implements Command
{


    @Override
    public String[] getCommand()
    {
        return new String[]{"option","gameoption"};
    }

    @Override
    public boolean commandPerformed( String[] args )
    {
        if ( args[0] != Reference.NO_ARGUMENTS_MESSAGE )
        {
            if ( args.length >= 3 )
            {
                if ( args[0].equalsIgnoreCase("textcolor") )
                {
                    if ( isInteger(args[1]) && isInteger(args[2]) && isInteger(args[3]) )
                    {
                        if ( Integer.valueOf(args[1]) <= 255 && Integer.valueOf(args[2]) <= 255 && Integer.valueOf(args[3]) <= 255 )
                        {
                            if ( Integer.valueOf(args[1]) >= 0 && Integer.valueOf(args[2]) >= 0 && Integer.valueOf(args[3]) >= 0 )
                            {
                                Color color = new Color(Integer.valueOf(args[1]) , Integer.valueOf(args[2]) , Integer.valueOf(args[3]));
                                Main.console.setForeground(color);
                                Main.input.setForeground(color);
                                Main.addText("Set text color to " + color.getRed() + " " + color.getGreen() + " " + color.getBlue());
                                return true;
                            }
                        }
                    }
                }
                if ( args[0].equalsIgnoreCase("windowcolor") )
                {
                    if ( isInteger(args[1]) && isInteger(args[2]) && isInteger(args[3]) )
                    {
                        if ( Integer.valueOf(args[1]) <= 255 && Integer.valueOf(args[2]) <= 255 && Integer.valueOf(args[3]) <= 255 )
                        {
                            if ( Integer.valueOf(args[1]) >= 0 && Integer.valueOf(args[2]) >= 0 && Integer.valueOf(args[3]) >= 0 )
                            {
                                Color color = new Color(Integer.valueOf(args[1]) , Integer.valueOf(args[2]) , Integer.valueOf(args[3]));
                                Main.consoleWindow.getContentPane().setBackground(color);
                                Main.inputWindow.getContentPane().setBackground(color);
                                Main.addText("Set window color to " + color.getRed() + " " + color.getGreen() + " " + color.getBlue());
                                return true;
                            }
                        }
                    }
                }
                if ( args[0].equalsIgnoreCase("backgroundcolor") )
                {
                    if ( isInteger(args[1]) && isInteger(args[2]) && isInteger(args[3]) )
                    {
                        if ( Integer.valueOf(args[1]) <= 255 && Integer.valueOf(args[2]) <= 255 && Integer.valueOf(args[3]) <= 255 )
                        {
                            if ( Integer.valueOf(args[1]) >= 0 && Integer.valueOf(args[2]) >= 0 && Integer.valueOf(args[3]) >= 0 )
                            {
                                Color color = new Color(Integer.valueOf(args[1]) , Integer.valueOf(args[2]) , Integer.valueOf(args[3]));
                                Main.console.setBackground(color);
                                Main.input.setBackground(color);
                                Main.input.setCaretColor(color);
                                Main.addText("Set background color to " + color.getRed() + " " + color.getGreen() + " " + color.getBlue());
                                return true;
                            }
                        }
                    }
                }
            }
            if ( args.length >= 2 )
            {
                if ( args[0].equalsIgnoreCase("toggle") )
                {
                    if ( args[1].equalsIgnoreCase("commandwindow") )
                    {
                        Main.toggleCommandWindow();
                        Main.addText("Toggled command window visibility");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String getCommandFailMessage()
    {
        return "USAGE: option <textcolor,backgroundcolor,windowcolor> <red> <green> <blue> OR option toggle commandwindow";
    }

    @Override
    public String getHelpMessage() {
        return "Set game settings/options";
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
