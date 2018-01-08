package org.artsicleprojects.textadventure.Items;

public class ItemRegistry
{
    public static void regsterItems(Object ... o) {
        for(int i = 0; i < o.length;i++) {
            Item a = (Item)o[i];
            new ItemHandler(a);
        }
    }
}
