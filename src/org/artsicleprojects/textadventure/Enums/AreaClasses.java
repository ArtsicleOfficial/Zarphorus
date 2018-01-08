package org.artsicleprojects.textadventure.Enums;

public enum AreaClasses {
    DUNGEON(0,2),
    GRASSLAND(1,5),
    TOWN(2,23),
    FOREST(3,23),
    SNOWY(4,24),
    MOUNTAIN(5,25),
    DESERT(6,27),
    SWAMP(7,27);
    private Integer[] value = new Integer[2];
    public Integer[] getValue() {
        return value;
    }
    AreaClasses(Integer id, Integer chance) {
        value[0] = id;
        value[1] = chance;
    }
}
