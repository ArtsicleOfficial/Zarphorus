package org.artsicleprojects.textadventure.Commands.cmdC;

import org.artsicleprojects.textadventure.Commands.Command;
import org.artsicleprojects.textadventure.Commands.Help;

public class CommandRegistry
{
    public static void registerCommands( Object... s ) {

        for(int i =0; i < s.length; i++) {
            Command a = (Command)s[i];
            new CommandHandler(a);
        }
    }
}
