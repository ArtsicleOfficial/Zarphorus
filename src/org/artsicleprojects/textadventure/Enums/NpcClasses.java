package org.artsicleprojects.textadventure.Enums;

public enum NpcClasses {
    Merchant(0),
    Talk(1),
    NonInteractive(2),
    Blacksmith(3);
    private Integer value;
    NpcClasses(Integer npcclass) {
        this.value = npcclass;
    }
    public Integer getValue() {
        return value;
    }
}
