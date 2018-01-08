package org.artsicleprojects.textadventure.Items;

import org.artsicleprojects.textadventure.AreaCreatables.InventoryItem;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Enums.ToolClasses;

import java.util.ArrayList;
import java.util.List;

public class ItemHandler
{
    public static List<Item> items = new ArrayList<>();

    public ItemHandler( Item s )
    {
        items.add(s);
    }

    public static Item getItemByClass( ItemClasses itemClass )
    {
        for ( int i = 0 ; i < items.size() ; i++ )
        {
            if ( items.get(i).getItemClass().getValue() == itemClass.getValue() )
            {
                return items.get(i);
            }
        }
        return null;
    }

    public static Item getItemByName( String name )
    {
        for ( int i = 0 ; i < items.size() ; i++ )
        {
            if ( items.get(i).getItemName().equalsIgnoreCase(name) )
            {
                return items.get(i);
            }
        }
        return null;
    }

    public static Item getItemByNameStrictly( ToughString name )
    {
        for ( int i = 0 ; i < items.size() ; i++ )
        {
            if ( items.get(i).getItemName().equals(name) )
            {
                return items.get(i);
            }
        }
        return null;
    }

    public static Item getItemByInventoryItem( InventoryItem item )
    {
        Item i;
        i = getItemByClass(item.ITEM_CLASS);
        return i;
    }
}
