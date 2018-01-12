package org.artsicleprojects.textadventure.Commands;

import org.artsicleprojects.textadventure.*;
import org.artsicleprojects.textadventure.Commands.cmdC.CommandHandler;

public class Help implements Command {

    @Override
    public String[] getCommand() {
        return new String[]{"help"};
    }

    @Override
    public boolean commandPerformed(String[] args) {
        if(args[0].equalsIgnoreCase(Reference.NO_ARGUMENTS_MESSAGE)) {
            return false;
        }else {
            if(args[0].equalsIgnoreCase("commands") || args[0].equalsIgnoreCase("cmds")) {
                for(int i = 0; i < CommandHandler.cmds.size(); i++) {
                    if(!CommandHandler.cmds.get(i).getCommand()[0].equalsIgnoreCase("cheatcode")) {
                        Command currCommand = CommandHandler.cmds.get(i);
                        printCommandInfo(currCommand);
                    }
                }
                return true;
            } else {
                if(args.length == 1) {
                    for(int i = 0; i < CommandHandler.cmds.size(); i++) {
                        String hasWhat = "";
                        Command currCommand = CommandHandler.cmds.get(i);
                        boolean has = false;
                        for(String alias : currCommand.getCommand()) {
                            if(alias.equalsIgnoreCase(args[0])) {
                                hasWhat = alias;
                                has = true;
                            }
                        }
                        if(has) {
                            printCommandInfo(CommandHandler.getCommandFromName(hasWhat));
                        }
                    }
                    return true;
                }
            }
            if(args[0].equalsIgnoreCase("game")) {
                Main.addTexts(
                        "To make a new save game file, type 'game save <filename>' Ex: 'game save art1'",
                        "To load a game save file, type 'game load <filename>' Ex: 'game load art1'",
                        "To equip an item, type 'equip'",
                        "To attack an entity, type 'attack",
                        "To check for nearby entities, type 'check'",
                        "To take loot, type 'loot'",
                        "To move on to a new area, type 'walk'",
                        "To look at your inventory, type 'inventory'"
                );
                return true;
            }
        }
        return false;
    }
    private static void printCommandInfo(Command command) {
        Main.addText(command.getCommand()[0] + ") HELP: " + command.getHelpMessage());
        String aliases = "";
        for(int l = 0; l < command.getCommand().length; l++) {
            aliases += command.getCommand()[l] + ",";
        }
        aliases = aliases.substring(0,aliases.length()-1);
        Main.addText(command.getCommand()[0] + " ) ALIASES: " + aliases);
        Main.addText(command.getCommand()[0] + " ) FAIL MESSAGE: " + command.getCommandFailMessage());
    }
    @Override
    public String getCommandFailMessage() {
        return "USAGE: help commands OR help game OR help <##command>";
    }

    @Override
    public String getHelpMessage() {
        return "Get help with the game or commands";
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
