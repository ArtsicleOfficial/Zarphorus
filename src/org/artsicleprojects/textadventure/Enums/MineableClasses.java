package org.artsicleprojects.textadventure.Enums;

public enum MineableClasses {
    BOULDER(0),
    COPPER_DEPOSIT(1),
    IRON_DEPOSIT(2);
    private Integer value;
    public Integer getValue() {
        return value;
    }
    MineableClasses(Integer classID) {
        value = classID;
    }
}
