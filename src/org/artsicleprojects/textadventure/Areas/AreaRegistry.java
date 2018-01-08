package org.artsicleprojects.textadventure.Areas;

public class AreaRegistry {
    public static void registerAreas(Area... a) {
        for(int i = 0;i < a.length;i++) {
            new AreaHandler(a[i]);
        }
    }
}
