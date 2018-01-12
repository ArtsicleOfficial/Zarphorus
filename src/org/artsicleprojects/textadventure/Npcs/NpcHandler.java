package org.artsicleprojects.textadventure.Npcs;

import org.artsicleprojects.ArtUtils.ArtUtils;
import org.artsicleprojects.textadventure.AreaCreatables.AreaNpc;
import org.artsicleprojects.textadventure.AreaCreatables.InventoryItem;
import org.artsicleprojects.textadventure.Enums.ItemSoldClasses;
import org.artsicleprojects.textadventure.Enums.NpcClasses;
import org.artsicleprojects.textadventure.Items.Item;
import org.artsicleprojects.textadventure.Items.ItemHandler;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

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
    public static Npc getNpcByAreaNpc(AreaNpc cls) {
        for(Npc s : npcs) {
            if(s.npcClass().getValue() == cls.ID.getValue()) {
                return s;
            }
        }
        return null;
    }
    public static boolean npcHasTrade(Item item, AreaNpc npc) {
        for(Map.Entry<InventoryItem,Float> e : npc.TRADES.entrySet()) {
            if(e.getKey().ITEM_CLASS.getID() == item.getItemClass().getID()) {
                return true;
            }
        }
        return false;
    }
    public static Map.Entry<InventoryItem,Float> getNpcTrade(Item item, AreaNpc npc) {
        if(npcHasTrade(item,npc)) {
            for(Map.Entry<InventoryItem,Float> e : npc.TRADES.entrySet()) {
                if(e.getKey().ITEM_CLASS.getID() == item.getItemClass().getID()) {
                    return e;
                }
            }
        }
        return null;
    }
    public static void removeNpcTrade(Item item, AreaNpc npc) {
        if(npcHasTrade(item,npc)) {
            for(Map.Entry<InventoryItem,Float> e : npc.TRADES.entrySet()) {
                if(e.getKey().ITEM_CLASS.getID() == item.getItemClass().getID()) {
                    npc.TRADES.remove(e.getKey());
                    break;
                }
            }
        }
    }
    public static boolean npcHasTrade(Item item, Hashtable<InventoryItem,Float> trades) {
        for(Map.Entry<InventoryItem,Float> e : trades.entrySet()) {
            if(e.getKey().ITEM_CLASS.getID() == item.getItemClass().getID()) {
                return true;
            }
        }
        return false;
    }
    public static Hashtable<InventoryItem,Float> generateTrades(Integer tie, ItemSoldClasses[] allowedClasses) {
        Hashtable<InventoryItem,Float> items = new Hashtable<>();
        Integer count = 0;
        while(items.size() <= 1) {
            if(count >= 100) {
                break;
            }
            for(Item item : ItemHandler.items) {
                if(item.canBeBought() || item.canBeSold()) {
                    Boolean can = false;
                    for(ItemSoldClasses cc : allowedClasses) {
                        if(cc.getValue() == item.getItemClass().getSoldClass().getValue()) {
                            can = true;
                        }
                    }
                    if(can) {
                        Float rand = ArtUtils.randomFloat(0,100);
                        Float check = ArtUtils.randomFloat(0,20);
                        ArtUtils.println(rand + " " + check);
                        if(rand < check) {
                            Integer cnt = ArtUtils.randomInt(1,3);
                            Float price = cnt*item.getCost();
                            ArtUtils.println(rand + " " + check);
                            ArtUtils.println(getTier(item.getCost()) + " " + tie); //Tier doesnt print
                            if(getTier(item.getCost()) <= tie) {
                                if(!npcHasTrade(item,items)) {
                                    items.put(new InventoryItem(cnt,item.getItemClass()),price);
                                }
                            }
                        }
                    }
                }
            }
            count++;
        }
        ArtUtils.println(items.size() + "");
        return items;
    }
    private static Integer getTier(Float price) {
        Integer tier = -1;
        if(price >= 0 && price <= 99.99) {
            tier = 1;
        }
        if(price >= 100 && price <= 399.99) {
            tier = 2;
        }
        if(price >= 400 && price <= 899.99) {
            tier = 3;
        }
        if(price >= 900 && price <= 1599.99) {
            tier = 4;
        }
        if(price >= 1600) {
            tier = 5;
        }
        return tier;
    }
}
