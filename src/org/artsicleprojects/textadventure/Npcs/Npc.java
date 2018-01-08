package org.artsicleprojects.textadventure.Npcs;

import org.artsicleprojects.textadventure.Areas.Area;
import org.artsicleprojects.textadventure.Enums.NpcClasses;

public interface Npc {
    public NpcClasses npcClass();

    public Boolean canSpawn();

    public Boolean canSpeak();
    public String[] getDialouges();
    public Area[] getSpawns();
    public Integer[] getSpawnChances();

}
