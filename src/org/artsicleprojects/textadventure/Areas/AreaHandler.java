package org.artsicleprojects.textadventure.Areas;

import org.artsicleprojects.textadventure.Enums.AreaClasses;
import org.artsicleprojects.textadventure.Reference;

import java.util.ArrayList;
import java.util.List;

public class AreaHandler {
    public static List<Area> areas = new ArrayList<>();
    public AreaHandler(Area a) {
        areas.add(a);
    }
    public static Area getDefaultArea() {
        return getAreaByClass(AreaClasses.GRASSLAND);
    }
    public static Area getAreaByClass(AreaClasses input) {
        for(int i = 0;i < areas.size();i++) {
            if(areas.get(i).getAreaClass().getValue()[0] == input.getValue()[0]) {
                return areas.get(i);
            }
        }
        return null;
    }
    public static Area getAreaByName(String name) {
        for(int i = 0;i < areas.size();i++) {
            if(areas.get(i).getName().equalsIgnoreCase(name)) {
                return areas.get(i);
            }
        }
        return null;
    }
}
