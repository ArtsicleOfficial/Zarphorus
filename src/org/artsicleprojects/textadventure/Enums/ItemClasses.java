package org.artsicleprojects.textadventure.Enums;

public enum ItemClasses {
    AIR(0),
    STICK(1),
    BREAD(2),
    BACON(3),
    STEAK(4),
    SHARP_STICK(5),
    GOD_ITEM(6),
    WOODEN_SWORD(7),
    TOUGH_STRING(8),
    CATTAIL(9),
    ROCK(10),
    CACTUS(11),
    WOODEN_PICKAXE(12),
    WOODEN_AXE(13),
    RABBIT_MEAT(14),
    CHICKEN_BREAST(15);

    private Integer value;
    public Integer getValue(){ return value; };
    ItemClasses(Integer value) {
        this.value = value;
    }
}
