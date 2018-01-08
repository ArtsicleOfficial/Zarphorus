package org.artsicleprojects.textadventure.Mineables;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.artsicleprojects.textadventure.Enums.MineableClasses;

import java.util.ArrayList;
import java.util.List;

public class MineableHandler {
    public static List<Mineable> mineables = new ArrayList<>();
    public MineableHandler(Mineable mineable) {
        mineables.add(mineable);
    }
    public static Mineable getMineableByClass(MineableClasses input) {
        Mineable mineable = null;
        for(int i = 0; i < mineables.size();i++) {
            if(mineables.get(i).getMineableClass().getValue() == input.getValue()) {
                mineable = mineables.get(i);
            }
        }
        return mineable;
    }
}
