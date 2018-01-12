package org.artsicleprojects.textadventure.AreaCreatables;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.artsicleprojects.ArtUtils.ArtUtils;
import org.artsicleprojects.textadventure.Enums.NpcClasses;
import org.artsicleprojects.textadventure.Npcs.NpcHandler;

import java.util.Hashtable;
import java.util.Random;

public class AreaNpc {
    public NpcClasses ID;
    public Hashtable<InventoryItem,Float> TRADES = null;
    public Integer INTERACTION_ID = 0;
    public Integer TIER = 0;

    public AreaNpc(NpcClasses npcClass) {
        this.ID = npcClass;
        this.TIER = ArtUtils.randomInt(1,5);
        this.INTERACTION_ID = new Random(System.nanoTime()).nextInt(9999-1000)+1000;
        this.TRADES = NpcHandler.generateTrades(TIER,NpcHandler.getNpcByEnum(npcClass).getAllowedItemsSold());
        if(this.TRADES.size() >= 1) {
            ArtUtils.println("ye");
        }
    }
}
