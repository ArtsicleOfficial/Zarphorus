package org.artsicleprojects.textadventure.Commands;

import org.artsicleprojects.textadventure.Commands.cmdC.CommandRegistry;

public class InitCommands
{
    public static Help HELP;
    public static Print PRINT;
    public static Game GAME;
    public static Equip EQUIP;
    public static Walk WALK;
    public static Inventory INVENTORY;
    public static Loot LOOT;
    public static Check CHECK;
    public static Step STEP;
    public static Eat EAT;
    public static Player PLAYER;
    public static Drop DROP;
    public static Option OPTION;
    public static Attack ATTACK;
    public static Cheatcode CHEATCODE;
    public static Craft CRAFT;
    public static Variable VARIABLE;
    public static Mine MINE;


    public InitCommands() {
        init();
        register();
    }
    private static void init() {
        HELP = new Help();
        PRINT = new Print();
        GAME = new Game();
        EQUIP = new Equip();
        WALK = new Walk();
        INVENTORY = new Inventory();
        LOOT = new Loot();
        CHECK = new Check();
        STEP = new Step();
        EAT = new Eat();
        PLAYER = new Player();
        DROP = new Drop();
        OPTION = new Option();
        ATTACK = new Attack();
        CHEATCODE = new Cheatcode();
        CRAFT = new Craft();
        VARIABLE = new Variable();
        MINE = new Mine();
    }
    public static void register() {
        CommandRegistry.registerCommands(
                HELP,
                PRINT,
                GAME,
                EQUIP,
                WALK,
                INVENTORY,
                LOOT,
                CHECK,
                STEP,
                EAT,
                PLAYER,
                DROP,
                OPTION,
                ATTACK,
                CHEATCODE,
                CRAFT,
                VARIABLE,
                MINE
        );
    }
}
