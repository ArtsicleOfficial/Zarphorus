package org.artsicleprojects.textadventure;

import org.artsicleprojects.textadventure.AreaCreatables.AreaEntity;
import org.artsicleprojects.textadventure.AreaCreatables.AreaMineable;
import org.artsicleprojects.textadventure.AreaCreatables.AreaNpc;
import org.artsicleprojects.textadventure.AreaCreatables.InventoryItem;
import org.artsicleprojects.textadventure.Areas.AreaHandler;
import org.artsicleprojects.textadventure.Entities.Entity;
import org.artsicleprojects.textadventure.Entities.EntityHandler;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Items.Item;
import org.artsicleprojects.textadventure.Items.ItemHandler;
import org.artsicleprojects.textadventure.Mineables.Mineable;
import org.artsicleprojects.textadventure.Mineables.MineableHandler;
import org.artsicleprojects.textadventure.Npcs.Npc;
import org.artsicleprojects.textadventure.Npcs.NpcHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Area {
    public static org.artsicleprojects.textadventure.Areas.Area currentArea = AreaHandler.getDefaultArea();
    public static Random randArea = new Random();
    public static Integer areaSeed = new Random().nextInt(2);
    public static Integer smallAreaSeed = new Random().nextInt(2);
    public static Boolean areaLooted = false;

    public static List<InventoryItem> localItems = getItemsInArea();
    public static List<AreaEntity> localEntities = getEntitiesInArea();
    public static List<AreaMineable> localMineables = getMineablesInArea();

    public static void walkToSameArea() {
        if(Player.tryRemoveEnergy(Reference.STEP_ENERGY_REMOVAL)) {
            areaLooted = false;
            localItems.clear();
            new Random().setSeed(System.nanoTime());
            smallAreaSeed = new Random().nextInt(2)+1;
            areaSeed = new Random().nextInt(2)+1;
            localItems = getItemsInArea();
            localEntities = getEntitiesInArea();
            localMineables = getMineablesInArea();
        }
    }

    public static void saveAreaItems() {
        for(int i = 0; i < localItems.size(); i++) {
            for(int l = 0; l < localItems.size(); l++) {
                if(localItems.get(l) != localItems.get(i)) {
                    if(localItems.get(i).ITEM_CLASS == localItems.get(l).ITEM_CLASS) {
                        localItems.get(i).COUNT += localItems.get(l).COUNT;
                        localItems.remove(l);
                    }
                }
            }
            if(localItems.get(i).COUNT < 1) {
                localItems.remove(i);
            }
        }
    }

    public static void newArea() {
        boolean done = false;
        smallAreaSeed = new Random().nextInt(2);
        areaSeed = new Random().nextInt(2);
        for(int i = 0; i < AreaHandler.areas.size(); i++) {
            int rand = (int)Math.floor(Math.random()*100);
            if(rand <= AreaHandler.areas.get(i).getAreaClass().getValue()[1]) {
                currentArea = AreaHandler.areas.get(i);
                done = true;
                break;
            }
        }
        if(! done) {
            currentArea = AreaHandler.getDefaultArea();
        }
        localItems = getItemsInArea();
        localEntities = getEntitiesInArea();
        localMineables = getMineablesInArea();
        areaLooted = false;
    }
    public static void addItemToArea(InventoryItem s) {
        ItemClasses id1 = s.ITEM_CLASS;
        Boolean contains = false;
        Integer index = 0;
        for(int i = 0; i < localItems.size(); i++) {
            if(localItems.get(i).ITEM_CLASS == id1) {
                contains = true;
                index = i;
            }
        }
        if(! contains) {
            localItems.add(s);
        }else {
            Integer count1 = s.COUNT;
            localItems.get(index).COUNT += count1;
        }
    }

    public static List<AreaMineable> getMineablesInArea() {
        List<AreaMineable> areaMineables = new ArrayList<>();
        for(int a = 0; a < smallAreaSeed; a++) {
            for(int i = 0; i < MineableHandler.mineables.size(); i++) {
                boolean canMineableSpawn = false;
                Integer areaNum = 0;
                for(int l = 0; l < MineableHandler.mineables.get(i).getAreaSpawns().length; l++) {
                    if(MineableHandler.mineables.get(i).getAreaSpawns()[l].getAreaClass().getValue()[0] == Area.currentArea.getAreaClass().getValue()[0]) {
                        areaNum = l;
                        canMineableSpawn = true;
                    }
                }
                Mineable mineable = MineableHandler.mineables.get(i);
                if(! mineable.canSpawn()) {
                    canMineableSpawn = false;
                }
                if(canMineableSpawn) {
                    Random random = new Random();
                    for(int x = 0; x < mineable.getSpawnCount(); x++) {
                        Integer f = random.nextInt(100);
                        if(f <= mineable.getAreaChances()[areaNum]) {
                            areaMineables.add(new AreaMineable(mineable.getMineableClass(), random.nextInt(mineable.getMaxDurability()-mineable.getMinDurability())+mineable.getMinDurability()));
                        }
                    }
                }
            }
        }
        return areaMineables;
    }

    public static List<AreaNpc> getNpcsInArea() {
        List<AreaNpc> areaNpcs = new ArrayList<>();
        for(int a = 0; a < smallAreaSeed; a++) {
            for(int i = 0; i < NpcHandler.npcs.size(); i++) {
                boolean canEntitySpawn = false;
                Integer areaNum = 0;
                for(int l = 0; l < NpcHandler.npcs.get(i).getSpawns().length; l++) {
                    if((NpcHandler.npcs.get(i).getSpawns()[l]).getAreaClass().getValue()[0] == (Area.currentArea).getAreaClass().getValue()[0]) {
                        areaNum = l;
                        canEntitySpawn = true;
                    }
                }
                Npc npc = NpcHandler.getNpcByEnum(NpcHandler.npcs.get(i).npcClass());
                if(npc.canSpawn() != null) {
                    if(! npc.canSpawn()) {
                        canEntitySpawn = false;
                    }
                }else {
                    canEntitySpawn = false;
                }

                if(canEntitySpawn) {
                    Random random = new Random();
                    random.setSeed(System.nanoTime());
                    Integer f = random.nextInt(100);
                    if(f <= npc.getSpawnChances()[areaNum]) {
                        areaNpcs.add(new AreaNpc(npc.npcClass()));
                    }
                }


            }
        }
        return areaNpcs;
    }

            public static List<AreaEntity> getEntitiesInArea () {
                List<AreaEntity> areaEntities = new ArrayList<>();
                for(int a = 0; a < smallAreaSeed; a++) {
                    for(int i = 0; i < EntityHandler.entities.size(); i++) {
                        boolean canEntitySpawn = false;
                        Integer areaNum = 0;
                        for(int l = 0; l < EntityHandler.entities.get(i).getAreaSpawns().length; l++) {
                            if((EntityHandler.entities.get(i).getAreaSpawns()[l]).getAreaClass().getValue()[0] == (Area.currentArea).getAreaClass().getValue()[0]) {
                                areaNum = l;
                                canEntitySpawn = true;
                            }
                        }
                        Entity entity = EntityHandler.entities.get(i);
                        if(entity.canSpawn() != null) {
                            if(! entity.canSpawn()) {
                                canEntitySpawn = false;
                            }
                        }else {
                            canEntitySpawn = false;
                        }

                        if(canEntitySpawn) {
                            Random random = new Random();
                            for(int x = 0; x < entity.getSpawnCount(); x++) {
                                random.setSeed(System.nanoTime());
                                Integer f = random.nextInt(100);
                                if(f <= entity.getAreaChances()[areaNum]) {
                                    areaEntities.add(new AreaEntity(entity.getEntityClass(), EntityHandler.getEntityByClass(entity.getEntityClass()).maxHealth()));
                                }
                            }

                        }
                    }
                }
                return areaEntities;
            }

        public static void saveAreaSeed () {
            if(areaSeed <= 0) {
                areaSeed++;
            }
            if(smallAreaSeed <= 0) {
                smallAreaSeed++;
            }
        }

        public static List<InventoryItem> getItemsInArea () {
            List<InventoryItem> s = new ArrayList<>();
            randArea.setSeed(System.nanoTime());
            saveAreaSeed();
            if(! areaLooted) {
                for(int f = 0; f < areaSeed; f++) {
                    for(int i = 0; i < ItemHandler.items.size(); i++) {
                        boolean itemCanSpawn = false;
                        Integer areaNum = Reference.EMPTY_NUMBER;
                        for(int l = 0; l < ItemHandler.items.get(i).getAreaSpawns().length; l++) {
                            if(ItemHandler.items.get(i).getAreaSpawns()[l].getName().equalsIgnoreCase(Area.currentArea.getName())) {
                                areaNum = l;
                                itemCanSpawn = true;
                            }
                        }
                        Item item = ItemHandler.items.get(i);
                        if(! item.canSpawn()) {
                            itemCanSpawn = false;
                        }
                        if(itemCanSpawn) {
                            Random random = new Random();
                            InventoryItem currItem = null;
                            int count = 0;
                            for(int x = 0; x < ItemHandler.items.get(i).getSpawnCount(); x++) {
                                random.setSeed(System.nanoTime());
                                int a = (int)Math.floor(random.nextInt(100));
                                //System.out.println(a + " " + item.getAreaChances()[areaNum]);
                                if(a <= item.getAreaChances()[areaNum]) {
                                    count++;
                                }
                            }
                            if(count >= 1) {
                                currItem = new InventoryItem(count, item.getItemClass());
                            }
                            if(currItem != null) {
                                s.add(currItem);
                            }
                        }
                    }
                }
            }
            //List<Item> item = new ArrayList<>();
            if(s.size() >= 1) {
                for(int i = 0; i < s.size(); i++) {
                    if(! ItemHandler.getItemByInventoryItem(s.get(i)).canSpawn()) {

                        s.remove(i);
                    }
                }
                for(int x = 0; x < 5; x++) {
                    for(int i = 0; i < s.size(); i++) {
                        for(int l = 0; l < s.size(); l++) {
                            if(s.get(i).ITEM_CLASS == s.get(l).ITEM_CLASS && s.get(i) != s.get(l)) {
                                s.get(i).COUNT += s.get(l).COUNT;
                                s.remove(l);
                            }
                        }
                    }
                }
            }
            return s;
        }

        public static void lootArea () {
            if(localItems.size() >= 1) {
                for(int i = 0; i < localItems.size(); i++) {
                    Player.noPrintAddInventoryItem(localItems.get(i));
                    Main.addText("Looted "+localItems.get(i).COUNT+" * "+ItemHandler.getItemByInventoryItem(localItems.get(i)).getItemName());
                }
                localItems.clear();
            }

            Player.saveInventory();
            areaLooted = true;
        }
    }
