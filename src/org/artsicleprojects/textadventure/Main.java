package org.artsicleprojects.textadventure;


import org.artsicleprojects.ArtUtils.ArtUtils;
import org.artsicleprojects.textadventure.Areas.InitAreas;
import org.artsicleprojects.textadventure.Commands.InitCommands;
import org.artsicleprojects.textadventure.Commands.cmdC.CommandHandler;
import org.artsicleprojects.textadventure.Crafts.Crafting;
import org.artsicleprojects.textadventure.Entities.InitEntities;
import org.artsicleprojects.textadventure.Events.Input;
import org.artsicleprojects.textadventure.Items.InitItems;
import org.artsicleprojects.textadventure.Items.Item;
import org.artsicleprojects.textadventure.Items.ItemHandler;
import org.artsicleprojects.textadventure.Mineables.InitMineables;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Main {
    public static JFrame consoleWindow = new JFrame(), inputWindow = new JFrame(), easyButtonWindow = new JFrame();

    public static JTextArea console = new JTextArea();

    public static JScrollPane consoleArea = new JScrollPane(console);

    public static JTextField input = new JTextField("Enter text");

    public static JButton enterLastMessage = new JButton("Enter previous message");

    public static Boolean autosave = false;

    public static String autosaveFileName = "New Game", lastCommand = "help";

    public static Date launchDate = new Date();
    public static DateFormat date = new SimpleDateFormat("dd_h.mm_ss_aa");
    static {
        input.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                input.setText("");
                input.removeMouseListener(this);
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public static void autosave() {
        if(autosave) {
            FileSystem.OverwriteSaveGame(autosaveFileName);
        }
    }
    public static void main(String[] args) {
        preInit();
        init();
        postInit();

        easyButtonWindow.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                autosave();
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        consoleWindow.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                autosave();
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        inputWindow.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                autosave();
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        enterLastMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CommandHandler.triggerCommand(lastCommand);
            }
        });
    }

    private static void preInit() {
        easyButtonWindow.add(enterLastMessage);
        new InitItems();
        new InitEntities();
        new InitAreas();
        new InitMineables();
        new Player();
    }

    private static void init() {
        new InitCommands();
    }

    public static void toggleCommandWindow() {
        easyButtonWindow.setVisible(! easyButtonWindow.isVisible());
    }

    private static void postInit() {
        easyButtonWindow.setLayout(new GridLayout(1,1));
        easyButtonWindow.setPreferredSize(new Dimension(300,60));
        consoleWindow.setAlwaysOnTop(true);
        inputWindow.setAlwaysOnTop(true);

        inputWindow.setLayout(new GridLayout(1,1));
        input.setBackground(Color.BLACK);
        input.setForeground(Color.WHITE);
        input.setCaretColor(Color.WHITE);
        consoleWindow.setMinimumSize(new Dimension(200,200));
        inputWindow.add(input);
        consoleWindow.setResizable(true);
        input.addKeyListener(new Input());
        consoleArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        DefaultCaret caret = (DefaultCaret)console.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        console.setBackground(Color.BLACK);
        console.setForeground(Color.WHITE);
        console.setEditable(false);
        console.setLineWrap(true);
        consoleArea.setBounds(0,0,consoleWindow.getWidth(),consoleWindow.getHeight());
        consoleArea.scrollRectToVisible(new Rectangle(0,0,10,10));
        consoleWindow.add(consoleArea);
        consoleWindow.setLayout(new GridLayout(1,1));
        consoleWindow.setPreferredSize(new Dimension(700,500));
        consoleWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        consoleWindow.pack();
        inputWindow.setTitle("Input");
        consoleWindow.setTitle("Console");
        inputWindow.setPreferredSize(new Dimension(500,60));
        consoleWindow.setVisible(true);
        inputWindow.pack();
        inputWindow.setVisible(true);
        inputWindow.setLocation(consoleWindow.getLocationOnScreen().x,consoleWindow.getLocationOnScreen().y+consoleWindow.getHeight());
        inputWindow.setSize(new Dimension((int)consoleWindow.getSize().getWidth(),60));
        inputWindow.setLocation(consoleWindow.getX(),consoleWindow.getY()+consoleWindow.getHeight());
        easyButtonWindow.pack();
        easyButtonWindow.setAlwaysOnTop(true);
        easyButtonWindow.setVisible(false);

        addText("Welcome to "+Reference.NAME+" v"+Reference.VERSION);
        addText("Type 'help' to start");


    }

    public static void addText(String tex) {
        StringBuilder te = new StringBuilder(tex);
        if(!ArtUtils.StringEndsInPunctuation(te.toString())) {
            if(Character.isLetterOrDigit(te.toString().charAt(te.toString().length()-1))) {
                te.append(".");
            }
        }
        String text = te.toString();
        DateFormat f = new SimpleDateFormat("[dd/mm/yy hh:mm:ss] > ");
        Date c = new Date();
        console.setText(console.getText()+f.format(c)+text+"\n");
        try {
            File d = new File("C:/Zarphorus/logs");
            File v = new File("C:/Zarphorus/logs/log" + date.format(launchDate) + ".txt");
            if(!d.exists()) {
                d.mkdirs();
            }

            if(!v.exists()) {
                v.createNewFile();
            }

            FileWriter writer = new FileWriter(v,true);
            PrintWriter writ = new PrintWriter(writer);
            writ.println(f.format(c)+text);
            writ.close();
        } catch(IOException ex) {

        }


    }

    public static void addTexts(String... t) {
        for(int l = 0;l < t.length;l++) {
            String c = t[l];
            addText(c);
        }
    }
}
