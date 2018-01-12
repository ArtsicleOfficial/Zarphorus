package org.artsicleprojects.textadventure.Items;



public class InitItems
{
    public static Stick STICK;
    public static Air AIR;
    public static Bread BREAD;
    public static Bacon BACON;
    public static Steak STEAK;
    public static SharpStick SHARP_STICK;
    public static GodItem GODITEM;
    public static WoodenSword WOODEN_SWORD;
    public static ToughString TOUGH_STRING;
    public static CatTail CAT_TAIL;
    public static Rock ROCK;
    public static WoodenPickaxe WOODEN_PICKAXE;
    public static WoodenAxe WOODEN_AXE;
    public static ChickenBreast CHICKEN_BREAST;
    public static CopperOre COPPER_ORE;
    public static IronOre IRON_ORE;
    public static Lantern LANTERN;
    public static Flesh FLESH;

    public InitItems() {
        init();
        register();
    }
    public void init() {
        STICK = new Stick();
        AIR = new Air();
        BREAD = new Bread();
        BACON = new Bacon();
        STEAK = new Steak();
        SHARP_STICK = new SharpStick();
        GODITEM = new GodItem();
        WOODEN_SWORD = new WoodenSword();
        TOUGH_STRING = new ToughString();
        CAT_TAIL = new CatTail();
        ROCK = new Rock();
        WOODEN_PICKAXE = new WoodenPickaxe();
        WOODEN_AXE = new WoodenAxe();
        CHICKEN_BREAST = new ChickenBreast();
        IRON_ORE = new IronOre();
        COPPER_ORE = new CopperOre();
        LANTERN = new Lantern();
        FLESH = new Flesh();
    }
    public void register() {
        ItemRegistry.regsterItems(
                STICK,
                AIR,
                BREAD,
                BACON,
                STEAK,
                SHARP_STICK,
                GODITEM,
                WOODEN_SWORD,
                TOUGH_STRING,
                CAT_TAIL,
                ROCK,
                WOODEN_PICKAXE,
                WOODEN_AXE,
                CHICKEN_BREAST,
                IRON_ORE,
                COPPER_ORE,
                LANTERN,
                FLESH
        );
    }
}
