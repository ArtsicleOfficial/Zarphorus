package org.artsicleprojects.textadventure.AreaCreatables;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Reference;

public class InventoryItem
{
    public ItemClasses ITEM_CLASS = ItemClasses.AIR;
    public Integer COUNT = 1;
    public InventoryItem(Integer count,ItemClasses itemClass) {
        COUNT = count;
        ITEM_CLASS = itemClass;
    }
}
