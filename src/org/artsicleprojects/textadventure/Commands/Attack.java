package org.artsicleprojects.textadventure.Commands;

import org.artsicleprojects.textadventure.*;
import org.artsicleprojects.textadventure.AreaCreatables.AreaEntity;
import org.artsicleprojects.textadventure.AreaCreatables.InventoryItem;
import org.artsicleprojects.textadventure.Entities.Entity;
import org.artsicleprojects.textadventure.Entities.EntityHandler;
import org.artsicleprojects.textadventure.Enums.GameMessages;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Items.ItemHandler;
import org.artsicleprojects.textadventure.Player;
import org.artsicleprojects.textadventure.Area;


public class Attack implements Command {
    @Override
    public String[] getCommand() {
        return new String[]{"attack"};
    }

    @Override
    public boolean isGameInteractionCommand() {
        return true;
    }

    @Override
    public boolean commandPerformed(String[] args) {
        if(args[0] != Reference.NO_ARGUMENTS_MESSAGE) {
            if(args.length == 1) {
                if(isStringNumeric(args[0])) {
                    Integer integer = Integer.valueOf(args[0]);
                    Boolean done = false;
                    for(int i = 0; i < org.artsicleprojects.textadventure.Area.localEntities.size(); i++) {
                        if(org.artsicleprojects.textadventure.Area.localEntities.get(i).INTERACTION_ID.equals(integer)) {
                            done = true;
                            Integer s = 0;
                            if(Player.equippedItem != null) {
                                s = EntityHandler.attackEntity(org.artsicleprojects.textadventure.Area.localEntities.get(i),Player.equippedItem);
                            } else {
                                s = EntityHandler.attackEntity(org.artsicleprojects.textadventure.Area.localEntities.get(i),new InventoryItem(1, ItemClasses.AIR));
                            }
                            Entity entity = EntityHandler.getEntityByAreaEntity(org.artsicleprojects.textadventure.Area.localEntities.get(i));
                            if(s >= 1) {
                                if(EntityHandler.getEntityByAreaEntity(org.artsicleprojects.textadventure.Area.localEntities.get(i)).attacksPlayer()) {
                                    if(entity.attacksPlayer()) {
                                        if(!entity.autoAttacksPlayer()) {
                                            org.artsicleprojects.textadventure.Area.localEntities.get(i).ATTACKING_PLAYER = true;
                                        }
                                    }
                                }
                            }
                            GameMessages.attackEntity.Reset();
                            GameMessages.attackEntity.SetLoss(Float.valueOf(s));
                            GameMessages.attackEntity.SetEntity(EntityHandler.getEntityByClass(Area.localEntities.get(i).ENTITY_CLASS));
                            GameMessages.attackEntity.PrintMessage();
                            Main.addText("Enemy Health: "+Area.localEntities.get(i).HEALTH);
                            if(Area.localEntities.get(i).HEALTH <= EntityHandler.getEntityByAreaEntity(Area.localEntities.get(i)).minHealth()) {
                                InventoryItem drop = EntityHandler.getEntityByAreaEntity(Area.localEntities.get(i)).dropItemOnDeath();
                                Main.addText("Enemy killed");
                                Player.addExperience(Area.localEntities.get(i));
                                GameMessages.itemDropped.Reset();
                                GameMessages.itemDropped.SetItem(ItemHandler.getItemByClass(drop.ITEM_CLASS));
                                GameMessages.itemDropped.SetLoss(Float.valueOf(drop.COUNT));
                                GameMessages.itemDropped.PrintMessage();
                                Area.localItems.add(drop);
                                Area.localEntities.remove(i);
                            } else {
                                /*if(EntityHandler.getEntityByAreaEntity(Area.localEntities.get(i)).attacksPlayer()) {
                                    Main.addText("Enemy attacking you...");
                                    Integer attack = Player.attackPlayer(Area.localEntities.get(i));
                                    if(! Player.dead) {
                                        GameMessages.attackedByEntity.Reset();
                                        GameMessages.attackedByEntity.SetEntity(EntityHandler.getEntityByAreaEntity(Area.localEntities.get(i)));
                                        GameMessages.attackedByEntity.SetLoss(Float.valueOf(attack));
                                        GameMessages.attackedByEntity.PrintMessage();
                                    }
                                }*/
                            }
                        }
                    }
                    if(! done) {
                        Main.addText("Entity not found");
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getCommandFailMessage() {
        return "USAGE: attack <##interaction_id>";
    }

    @Override
    public String getHelpMessage() {
        return "Attacks entity specified";
    }

    @Override
    public boolean canUseIfDead() {
        return false;
    }

    public boolean isStringNumeric(String s) {
        boolean done = false;
        for(int i = 0;i < s.length();i++) {
            Character character = s.charAt(i);
            if(! Character.isDigit(character)) {
                done = true;
                break;
            }
        }
        return ! done;
    }
}
