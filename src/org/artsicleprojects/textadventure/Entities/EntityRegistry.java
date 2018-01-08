package org.artsicleprojects.textadventure.Entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artsicle on 12/17/2017.
 */
public class EntityRegistry {
    public static void registerEntities(Entity...e) {
        for(Entity i : e) {
            new EntityHandler(i);
        }
    }
}
