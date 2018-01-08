package org.artsicleprojects.textadventure.Commands;

import org.artsicleprojects.ArtUtils.ArtUtils;
import org.artsicleprojects.textadventure.Area;
import org.artsicleprojects.textadventure.Enums.ToolClasses;
import org.artsicleprojects.textadventure.Items.Item;
import org.artsicleprojects.textadventure.Items.ItemHandler;
import org.artsicleprojects.textadventure.Main;
import org.artsicleprojects.textadventure.Mineables.MineableHandler;
import org.artsicleprojects.textadventure.Player;
import org.artsicleprojects.textadventure.Reference;

public class Mine implements Command {
    @Override
    public String[] getCommand() {
        return new String[]{"Mine"};
    }

    @Override
    public boolean commandPerformed(String[] args) {
        if(args[0] != Reference.NO_ARGUMENTS_MESSAGE) {
            if(args.length == 1) {
                if(Player.equippedItem != null) {
                    if(ItemHandler.getItemByInventoryItem(Player.equippedItem).isTool()) {
                        for(int i = 0; i < Area.localMineables.size(); i++) {
                            if(ArtUtils.isStringAllNumeric(args[0])) {
                                ArtUtils.println(Area.localMineables.get(i).INTERACTION_ID + " " + Integer.valueOf(args[0]));
                                if(Area.localMineables.get(i).INTERACTION_ID.equals(Integer.valueOf(args[0]))) {
                                    for(int l = 0; l < MineableHandler.getMineableByClass(Area.localMineables.get(i).CLASS).getToolClasses().length; l++) {
                                        Item item = ItemHandler.getItemByInventoryItem(Player.equippedItem);
                                        ToolClasses iteration = MineableHandler.getMineableByClass(Area.localMineables.get(i).CLASS).getToolClasses()[l];
                                        for(ToolClasses tools : item.getToolClasses()) {
                                            if(tools.getValue() == iteration.getValue()) {
                                                Player.mineMineable(Player.equippedItem,i);
                                            }
                                        }
                                    }
                                }
                            }else {
                                Main.addText("'"+args[1]+"' is not numeric");
                            }
                        }
                    }else {
                        Main.addText("'"+args[0]+"' is not a tool");
                    }
                }else {
                    Main.addText("You do not have an equipped item to mine with");
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String getCommandFailMessage() {
        return "USAGE: mine <##interaction_id>";
    }

    @Override
    public String getHelpMessage() {
        return "Mines specified mineable";
    }

    @Override
    public boolean canUseIfDead() {
        return false;
    }
}
