package org.artsicleprojects.textadventure.Npcs;

public class NpcRegistry {
    public static void registerAll(Npc...s) {
        for(Npc e : s) {
            new NpcHandler(e);
        }
    }
}
