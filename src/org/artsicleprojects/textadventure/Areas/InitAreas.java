package org.artsicleprojects.textadventure.Areas;

public class InitAreas {
    public static Desert DESERT;
    public static Town TOWN;
    public static Dungeon DUNGEON;
    public static Snowy SNOWY;
    public static Forest FOREST;
    public static Grasslands GRASSLANDS;
    public static Mountains MOUNTAINS;
    public static Swamp SWAMP;
    public static Cave CAVE;
    public InitAreas() {
        init();
        register();
    }

    private void init() {
        DESERT = new Desert();
        TOWN = new Town();
        DUNGEON = new Dungeon();
        SNOWY = new Snowy();
        FOREST = new Forest();
        GRASSLANDS = new Grasslands();
        MOUNTAINS = new Mountains();
        SWAMP = new Swamp();
        CAVE = new Cave();
    }
    private void register() {
        AreaRegistry.registerAreas(
                DESERT,
                TOWN,
                DUNGEON,
                SNOWY,
                FOREST,
                GRASSLANDS,
                MOUNTAINS,
                SWAMP,
                CAVE
        );
    }
}
