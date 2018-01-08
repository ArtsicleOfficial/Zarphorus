package org.artsicleprojects.textadventure.Npcs;

import org.artsicleprojects.textadventure.AreaCreatables.InventoryItem;
import org.artsicleprojects.textadventure.Enums.NpcClasses;

import java.util.ArrayList;
import java.util.Hashtable;

public class NpcHandler {
    public static ArrayList<Npc> npcs = new ArrayList<>();
    public NpcHandler(Npc npc) {
        npcs.add(npc);
    }
    public static Npc getNpcByEnum(NpcClasses cls) {
        for(Npc s : npcs) {
            if(s.npcClass().getValue() == cls.getValue()) {
                return s;
            }
        }

        return null;
    }
    public static Hashtable<InventoryItem,Float> generateTrades(Integer tier) {
        Hashtable<InventoryItem,Float> items = new Hashtable<>();

        return items;
    }
}
