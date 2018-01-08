package org.artsicleprojects.textadventure.Enums;

public enum NpcClasses {
    Merchant(-1337),
    Talk(-1000),
    NonInteractive(-900),
    Blacksmith(-1404);
    private Integer value;
    NpcClasses(Integer npcclass) {
        this.value = npcclass;
    }
    public Integer getValue() {
        return value;
    }
}
