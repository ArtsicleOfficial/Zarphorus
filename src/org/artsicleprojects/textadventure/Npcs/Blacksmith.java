package org.artsicleprojects.textadventure.Npcs;

import org.artsicleprojects.textadventure.Areas.Area;
import org.artsicleprojects.textadventure.Areas.InitAreas;
import org.artsicleprojects.textadventure.Enums.ItemSoldClasses;
import org.artsicleprojects.textadventure.Enums.NpcClasses;

public class Blacksmith implements Npc {
    @Override
    public NpcClasses npcClass() {
        return NpcClasses.Blacksmith;
    }

    @Override
    public Boolean canSpeak() {
        return true;
    }

    @Override
    public String[] getDialouges() {
        return new String[]{"Legend has it, there's a powerful metal that shocks anyone who touches it.","Carbon is an excellent material if you want your tool to shatter on touch!","Bring me your gold, I'll bring you a tool.","Stainless steel? do you want your tools to be for sissies or for real men?","Where is the customer!","You want a tool? Oh i'll give you a tool.","What will it be?","There are no heros, only killers.","I sense a fox just killed itself by jumping off the metallands","The water is being attacked","My metal jobs are the finest anyone has ever seen","We do NOT buy 999 of your useless loot, maybe 998."};
    }

    @Override
    public String getName() {
        return "Blacksmith";
    }

    @Override
    public Area[] getSpawns() {
        return new Area[]{InitAreas.TOWN};
    }

    @Override
    public Boolean canSpawn() {
        return true;
    }

    @Override
    public ItemSoldClasses[] getAllowedItemsSold() {
        return new ItemSoldClasses[]{ItemSoldClasses.METAL};
    }

    @Override
    public Integer[] getSpawnChances() {
        return new Integer[]{20};
    }

}
