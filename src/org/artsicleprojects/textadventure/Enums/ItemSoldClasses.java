package org.artsicleprojects.textadventure.Enums;

public enum ItemSoldClasses {
    METAL(100),
    FOOD(101),
    MISC(102),
    PLANT(103),
    MONSTER_DROPS(104);
    private Integer value;
    public Integer getValue() {
        return value;
    }
    ItemSoldClasses(Integer classId) {
        this.value = classId;
    }
}
