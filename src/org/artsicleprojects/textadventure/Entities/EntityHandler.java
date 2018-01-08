package org.artsicleprojects.textadventure.Entities;

import org.artsicleprojects.textadventure.AreaCreatables.AreaEntity;
import org.artsicleprojects.textadventure.AreaCreatables.InventoryItem;
import org.artsicleprojects.textadventure.Enums.EntityClasses;
import org.artsicleprojects.textadventure.Items.ItemHandler;
import org.artsicleprojects.textadventure.Main;
import org.artsicleprojects.textadventure.Player;

import java.util.ArrayList;
import java.util.List;


public class EntityHandler {
    public static List<Entity> entities = new ArrayList<>();
    public EntityHandler(Entity entity) {
        entities.add(entity);
    }

    public static Integer attackEntity(AreaEntity entity, InventoryItem item) {
		Integer attack = ItemHandler.getItemByInventoryItem(item).getAttackDamage();
		if(entity.HEALTH-attack >= EntityHandler.getEntityByClass(entity.ENTITY_CLASS).minHealth()) {
			if(Player.tryRemoveEnergy(ItemHandler.getItemByInventoryItem(item).getAttackDamage())) {
				entity.HEALTH-=attack;
			} else {
                Main.addText("Player energy too low to attack using equipped item");
                attack = 0;
            }
		} else {
			entity.HEALTH = EntityHandler.getEntityByClass(entity.ENTITY_CLASS).minHealth();

		}
		return attack;
	}
	public static Entity getEntityByAreaEntity(AreaEntity e) {
    	return getEntityByClass(e.ENTITY_CLASS);
	}
    public static Entity getEntityByClass(EntityClasses entityClass) {
        for(int i = 0; i < entities.size();i++) {
            if(entities.get(i).getEntityClass() == entityClass) {
                return entities.get(i);
            }
        }
        return null;
    }
}
