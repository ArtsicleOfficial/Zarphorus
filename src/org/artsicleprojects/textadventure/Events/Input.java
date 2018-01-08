package org.artsicleprojects.textadventure.Events;

import org.artsicleprojects.textadventure.Commands.cmdC.CommandHandler;
import org.artsicleprojects.textadventure.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input implements KeyListener
{
    @Override
    public void keyTyped( KeyEvent e )
    {

    }

    @Override
    public void keyPressed( KeyEvent e )
    {

    }
    @Override
    public void keyReleased( KeyEvent e )
    {
        if(e.getExtendedKeyCode() == 10) {
            String all[] = Main.input.getText().split(" ");
            String cmd = all[0];
            List<String> arg = new ArrayList<>(Arrays.asList(all));
            arg.remove(0);
            String[] args = {""};
            args = arg.toArray(args);
            CommandHandler.onCommand(cmd,args);
        }
    }
}
