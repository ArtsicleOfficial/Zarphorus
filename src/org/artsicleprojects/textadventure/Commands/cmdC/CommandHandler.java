package org.artsicleprojects.textadventure.Commands.cmdC;

import org.artsicleprojects.textadventure.Commands.Command;
import org.artsicleprojects.textadventure.Main;
import org.artsicleprojects.textadventure.Player;
import org.artsicleprojects.textadventure.Reference;

import javax.swing.*;
import javax.xml.stream.events.Characters;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandHandler {
    public static List<Command> cmds = new ArrayList<>();

    public CommandHandler(Command s) {

        CommandHandler.cmds.add(s);
    }

    public static Command getCommandFromName(String cmd) {
        for(int i = 0;i < cmds.size();i++) {
            boolean has = false;
            String hasWhat = "";
            for(String alias : cmds.get(i).getCommand()) {
                if(alias.equalsIgnoreCase(cmd)) {
                    hasWhat = alias;
                    has = true;
                }
            }
            if(has) {
                return cmds.get(i);
            }
        }
        return null;
    }

    public static void onCommand(String cmd,String[] args) {
        Main.lastCommand = cmd;
        boolean canUse = false;
        boolean canDo = true;
        if(cmds.size() >= 0) {

            if(Player.dead) {
                if(! getCommandFromName(cmd).canUseIfDead()) {
                    Main.addText("Cannot use '" + cmd + "' if dead");
                    canDo = false;
                }
            }
            if(canDo) {
                boolean activated = false;
                for(int i = 0;i < cmds.size();i++) {
                    Command s = cmds.get(i);
                    boolean has = false;
                    String hasWhat = "";
                    for(String alias : s.getCommand()) {
                        if(alias.equalsIgnoreCase(cmd)) {
                            has = true;
                            hasWhat = alias;
                        }
                    }
                    if(has) {
                        String[] a = args;
                        if(a[0] == null) {
                            a = new String[]{Reference.NO_ARGUMENTS_MESSAGE};
                        }
                        String fChar = "----"+Character.toUpperCase(cmd.charAt(0))+cmd.substring(1,cmd.length());
                        if(! a[0].equals(Reference.NO_ARGUMENTS_MESSAGE)) {
                            for(int l = 0;l < args.length;l++) {
                                fChar += " "+Character.toUpperCase(a[l].charAt(0))+a[l].substring(1,a[l].length());
                                Main.lastCommand += " "+a[l];
                            }
                        }
                        Main.addText(fChar+"----");
                        if(! s.commandPerformed(a)) {
                            String fail = s.getCommandFailMessage();
                            fail = fail.replaceAll("##itemname",Reference.ARGUMENT_ITEM_NAME);
                            fail = fail.replaceAll("##amount",Reference.ARGUMENT_ITEM_COUNT);
                            fail = fail.replaceAll("##filename",Reference.ARGUMENT_FILE_NAME);
                            Main.addText(fail);
                        }
                        Main.input.setText("");
                        activated = true;
                    }
                }
                if(! activated) {
                    Main.addText("Unknown Command '"+cmd+"'");
                }
            }
        }

        Main.autosave();
    }

    public static void triggerCommand(String command) {
        String all[] = command.split(" ");
        String cmd = all[0];
        List<String> arg = new ArrayList<>(Arrays.asList(all));
        arg.remove(0);
        String[] args = {""};
        args = arg.toArray(args);
        CommandHandler.onCommand(cmd,args);
    }
}
