package org.artsicleprojects.textadventure.Mineables;

public class MineableRegistry {
    public static void registerMineables(Mineable...mineable) {
        for(Mineable m : mineable) {
            new MineableHandler(m);
        }

    }
}
