package org.artsicleprojects.textadventure.Commands;

import org.artsicleprojects.ArtUtils.ArtUtils;
import org.artsicleprojects.textadventure.FileSystem;
import org.artsicleprojects.textadventure.Main;
import org.artsicleprojects.textadventure.Reference;

public class Game implements Command {
    @Override
    public String[] getCommand() {
        return new String[]{"game","file"};
    }

    @Override
    public boolean commandPerformed(String[] args) {
        if(args[0] != Reference.NO_ARGUMENTS_MESSAGE) {
            if(args.length == 3) {
                if(args[0].equalsIgnoreCase("set")) {
                    if(args[1].equalsIgnoreCase("autosavefile")) {
                        FileSystem.AutoSaveGame(args[2]);
                        Main.addText("Set autosave file to " + Main.autosaveFileName + ", Auto save is turned " + ArtUtils.getOnOffFromBool(Main.autosave));
                        return true;
                    }
                }
                if(args[0].equalsIgnoreCase("overwrite")) {
                    if(args[1].equalsIgnoreCase("save")) {
                        FileSystem.OverwriteSaveGame(args[2]);
                        Main.addText("Saved game file to '"+args[2]+".zar'");
                        return true;
                    }
                }
            }
            if(args.length == 2) {
                if(args[0].equalsIgnoreCase("toggle")) {
                    if(args[1].equalsIgnoreCase("autosave")) {
                        Main.autosave = !Main.autosave;
                        Main.addText("Set autosave to " + Main.autosave);
                        return true;
                    }
                }
                if(args[0].equalsIgnoreCase("save")) {
                    FileSystem.SaveGame(args[1]);

                    return true;
                } else if(args[0].equalsIgnoreCase("load")) {
                    FileSystem.LoadGame(args[1]);
                    return true;
                } else if(args[0].equalsIgnoreCase("listData")) {
                    String[] listedData = FileSystem.listDataFromSave(args[1]);
                    for(int i = 0 ; i < listedData.length ; i++) {
                        Main.addText(listedData[i]);
                    }
                    return true;
                } else if(args[0].equalsIgnoreCase("delete")) {
                    FileSystem.DeleteGame(args[1]);
                    return true;
                }
            }
            if(args.length == 1) {
                if(args[0].equalsIgnoreCase("list")) {
                    String[] listedFiles = FileSystem.getGamesNoExtension();
                    for(int i = 0 ; i < listedFiles.length ; i++) {
                        Main.addText(listedFiles[i]);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getCommandFailMessage() {
        return "USAGE: game save <##filename> OR game <##filename> OR game list OR game toggle autosave OR game listData <##filename> OR game delete <##filename> OR game set autosavefile <##filename> OR game overwrite save <##filename>";
    }

    @Override
    public String getHelpMessage() {
        return "Interact with the file system by saving loading, or deleting games.";
    }

    @Override
    public boolean canUseIfDead() {
        return true;
    }
}
