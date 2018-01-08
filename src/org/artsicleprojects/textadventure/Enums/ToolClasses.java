package org.artsicleprojects.textadventure.Enums;

public enum ToolClasses {
    PICKAXE(-19215281),
    AXE(-38791552);
    private Integer value;
    public Integer getValue() {
        return value;
    }
    ToolClasses(Integer classId) {
        value = classId;
    }
}
