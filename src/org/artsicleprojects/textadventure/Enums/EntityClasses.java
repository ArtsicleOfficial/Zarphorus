package org.artsicleprojects.textadventure.Enums;

public enum EntityClasses {
    PIG(0),
    COW(1),
    RABBIT(2),
    CHICKEN(3),
    GOBLIN(4);
    private Integer value;

    EntityClasses(Integer value) {
        this.value = value;
    }
}
