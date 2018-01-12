package org.artsicleprojects.textadventure.Enums;

public enum ItemClasses {
    AIR(0,ItemSoldClasses.MISC),
    STICK(1,ItemSoldClasses.MISC),
    BREAD(2,ItemSoldClasses.FOOD),
    BACON(3,ItemSoldClasses.FOOD),
    STEAK(4,ItemSoldClasses.FOOD),
    SHARP_STICK(5,ItemSoldClasses.MISC),
    GOD_ITEM(6,ItemSoldClasses.MISC),
    WOODEN_SWORD(7,ItemSoldClasses.MISC),
    TOUGH_STRING(8,ItemSoldClasses.MISC),
    CATTAIL(9,ItemSoldClasses.PLANT),
    ROCK(10,ItemSoldClasses.MISC),
    CACTUS(11,ItemSoldClasses.PLANT),
    WOODEN_PICKAXE(12,ItemSoldClasses.MISC),
    WOODEN_AXE(13,ItemSoldClasses.MISC),
    RABBIT_MEAT(14,ItemSoldClasses.FOOD),
    CHICKEN_BREAST(15,ItemSoldClasses.FOOD),
    COPPER_ORE(16,ItemSoldClasses.METAL),
    IRON_ORE(17,ItemSoldClasses.METAL),
    LANTERN(18,ItemSoldClasses.MISC),
    FLESH(19,ItemSoldClasses.MONSTER_DROPS);


    private Integer id;
    private ItemSoldClasses itemSoldClasses;
    public ItemSoldClasses getSoldClass() {
        return itemSoldClasses;
    }
    public Integer getID(){ return id; };
    ItemClasses(Integer value,ItemSoldClasses sold) {
        this.id = value;
        this.itemSoldClasses = sold;
    }
}
