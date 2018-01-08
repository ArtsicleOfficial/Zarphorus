package org.artsicleprojects.textadventure.Enums;

public enum MineableClasses {
    BOULDER(-15129807);
    private Integer value;
    public Integer getValue() {
        return value;
    }
    MineableClasses(Integer classID) {
        value = classID;
    }
}
