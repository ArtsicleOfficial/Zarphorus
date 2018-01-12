package org.artsicleprojects.textadventure.Enums;

public enum Arguments {
    ITEM_NAME("ITEM_NAME"),
    ITEM_COUNT("ITEM_COUNT"),
    FILE_NAME("FILE_NAME"),
    INTERACTION_ID("INTERACTION_ID"),
    VARIABLE_NAME("VARIABLE_NAME");
    private String value;
    public String getValue() {
        return value;
    }
    Arguments(String replacement) {
        this.value = replacement;
    }
}
