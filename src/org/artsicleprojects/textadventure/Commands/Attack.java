package org.artsicleprojects.textadventure.Commands;

import org.artsicleprojects.textadventure.*;
import org.artsicleprojects.textadventure.AreaCreatables.InventoryItem;
import org.artsicleprojects.textadventure.Entities.EntityHandler;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Items.ItemHandler;
import org.artsicleprojects.textadventure.Player;


public class Attack implements Command {
    @Override
    public String[] getCommand() {
        return new String[]{"attack"};
    }

    @Override
    public boolean commandPerformed(String[] args) {
        if(args[0] != Reference.NO_ARGUMENTS_MESSAGE) {
            if(args.length == 1) {
                if(isStringNumeric(args[0])) {
                    Integer integer = Integer.valueOf(args[0]);
                    Boolean done = false;
                    for(int i = 0;i < Area.localEntities.size();i++) {
                        if(Area.localEntities.get(i).INTERACTION_ID.equals(integer)) {
                            done = true;
                            Integer s = 0;
                            if(Player.equippedItem != null) {
                                s = EntityHandler.attackEntity(Area.localEntities.get(i),Player.equippedItem);

                            } else {
                                s = EntityHandler.attackEntity(Area.localEntities.get(i),new InventoryItem(1, ItemClasses.AIR));
                            }
                            Main.addText("Attacked "+EntityHandler.getEntityByClass(Area.localEntities.get(i).ENTITY_CLASS).getEntityName()+" ("+Area.localEntities.get(i).INTERACTION_ID+") for "+s+" damage");
                            Main.addText("Enemy Health: "+Area.localEntities.get(i).HEALTH);
                            if(Area.localEntities.get(i).HEALTH <= EntityHandler.getEntityByAreaEntity(Area.localEntities.get(i)).minHealth()) {
                                InventoryItem drop = EntityHandler.getEntityByAreaEntity(Area.localEntities.get(i)).dropItemOnDeath();
                                Main.addText("Enemy killed");
                                Player.addExperience(Area.localEntities.get(i));
                                Main.addText(drop.COUNT+" * "+ItemHandler.getItemByInventoryItem(drop).getItemName()+" dropped onto ground");
                                Area.localItems.add(drop);
                                Area.localEntities.remove(i);
                            } else {
                                if(EntityHandler.getEntityByAreaEntity(Area.localEntities.get(i)).attacksPlayer()) {
                                    Main.addText("Enemy attacking you...");
                                    Integer attack = Player.attackPlayer(Area.localEntities.get(i));
                                    if(! Player.dead) {
                                        Main.addText("You have been attacked by "+EntityHandler.getEntityByClass(Area.localEntities.get(i).ENTITY_CLASS).getEntityName()+" for "+attack+" damage");
                                    }
                                }
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
        return "USAGE: attack <INTERACTION_ID>";
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
