package org.artsicleprojects.textadventure.Commands;

import org.artsicleprojects.textadventure.Area;
import org.artsicleprojects.textadventure.Areas.AreaHandler;
import org.artsicleprojects.textadventure.Entities.EntityHandler;
import org.artsicleprojects.textadventure.Items.ItemHandler;
import org.artsicleprojects.textadventure.Main;
import org.artsicleprojects.textadventure.Mineables.MineableHandler;
import org.artsicleprojects.textadventure.Reference;

public class Check implements Command {
    @Override
    public String[] getCommand() {
        return new String[]{"check","look"};
    }

    @Override
    public boolean commandPerformed(String[] args) {
        if(args[0] != Reference.NO_ARGUMENTS_MESSAGE) {
            if(args[0].equalsIgnoreCase("item")) {
                boolean done = false;
                for(int s = 0; s < Area.localItems.size(); s++) {
                    Main.addText(Area.localItems.get(s).COUNT+" * "+ItemHandler.getItemByInventoryItem(Area.localItems.get(s)).getItemName());
                    done = true;
                }
                if(! done) {
                    Main.addText("No entities near");
                }
                return true;
            }else if(args[0].equalsIgnoreCase("entity")) {
                boolean done = false;
                for(int s = 0; s < Area.localEntities.size(); s++) {
                    Main.addText(EntityHandler.getEntityByClass(Area.localEntities.get(s).ENTITY_CLASS).getEntityName()+" ) HP: "+Area.localEntities.get(s).HEALTH+", Interaction ID: "+Area.localEntities.get(s).INTERACTION_ID);
                    done = true;
                }
                if(! done) {
                    Main.addText("No entities near");
                }
                return true;
            }else if(args[0].equalsIgnoreCase("mineable")) {
                boolean done = false;
                for(int s = 0; s < Area.localMineables.size(); s++) {
                    Main.addText(MineableHandler.getMineableByClass(Area.localMineables.get(s).CLASS).getName()+" ) DURABILITY: "+Area.localMineables.get(s).DURABILITY+", Interaction ID: "+Area.localMineables.get(s).INTERACTION_ID);
                    done = true;
                }
                if(! done) {
                    Main.addText("No mineables near");
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String getCommandFailMessage() {
        return "USAGE: check item OR check entity OR check mineable";
    }

    @Override
    public String getHelpMessage() {
        return "Look around for entities, items, or mineables";
    }

    @Override
    public boolean canUseIfDead() {
        return true;
    }
}
