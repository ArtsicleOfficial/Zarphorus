package org.artsicleprojects.textadventure.Npcs;

public class InitNpcs {
    public static Blacksmith BLACKSMITH;
    public InitNpcs() {
        init();
        register();
    }
    private static void init() {
        BLACKSMITH = new Blacksmith();
    }
    private static void register() {
        NpcRegistry.registerAll(
                BLACKSMITH
        );
    }
}
