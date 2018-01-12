package org.artsicleprojects.textadventure.Commands;

import org.artsicleprojects.ArtUtils.ArtUtils;
import org.artsicleprojects.textadventure.Area;
import org.artsicleprojects.textadventure.AreaCreatables.AreaNpc;
import org.artsicleprojects.textadventure.Enums.GameMessages;
import org.artsicleprojects.textadventure.Items.ItemHandler;
import org.artsicleprojects.textadventure.Main;
import org.artsicleprojects.textadventure.Npcs.Npc;
import org.artsicleprojects.textadventure.Npcs.NpcHandler;
import org.artsicleprojects.textadventure.Player;
import org.artsicleprojects.textadventure.Reference;

import java.awt.event.ComponentListener;

public class Buy implements Command {
    @Override
    public String[] getCommand() {
        return new String[]{"Buy"};
    }

    @Override
    public boolean isGameInteractionCommand() {
        return true;
    }

    @Override
    public boolean commandPerformed(String[] args) {
        if(args[0] != Reference.NO_ARGUMENTS_MESSAGE) {
            ArtUtils.println("ARGS");
            if(args.length == 2) {
                ArtUtils.println("ENOUGH!");
                if(ArtUtils.isStringAllNumeric(args[0])) {
                    AreaNpc selectedNpc = null;
                    boolean npcFound = false;
                    Integer interactionID = Integer.valueOf(args[0]);
                    for(int i = 0; i < Area.localNpcs.size(); i++ ) {
                        ArtUtils.println(Area.localNpcs.get(i).INTERACTION_ID + " " + interactionID);
                        if(Area.localNpcs.get(i).INTERACTION_ID.intValue() == interactionID.intValue()) {
                            npcFound = true;
                            selectedNpc = Area.localNpcs.get(i);
                        }
                    }
                    if(npcFound) {
                        if(ItemHandler.getItemByName(args[1]) != null) {
                            if(NpcHandler.npcHasTrade(ItemHandler.getItemByName(args[1]),selectedNpc)) {
                                if(Player.playerMoney >= NpcHandler.getNpcTrade(ItemHandler.getItemByName(args[1]),selectedNpc).getValue()) {
                                    Player.addInventoryItem(NpcHandler.getNpcTrade(ItemHandler.getItemByName(args[1]),selectedNpc).getKey());
                                    GameMessages.boughtItem.Reset();
                                    GameMessages.boughtItem.SetItem(ItemHandler.getItemByName(args[1]));
                                    GameMessages.boughtItem.SetLoss(NpcHandler.getNpcTrade(ItemHandler.getItemByName(args[1]),selectedNpc).getValue());
                                    GameMessages.boughtItem.SetNpc(NpcHandler.getNpcByAreaNpc(selectedNpc));
                                    Player.playerMoney-=NpcHandler.getNpcTrade(ItemHandler.getItemByName(args[1]),selectedNpc).getValue();
                                    NpcHandler.removeNpcTrade(ItemHandler.getItemByName(args[1]),selectedNpc);
                                    GameMessages.boughtItem.PrintMessage();
                                    return true;
                                } else {
                                    Main.addText("Not enough money!");
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String getCommandFailMessage() {
        return "USAGE: buy <##interaction_id> <##item_name>";
    }

    @Override
    public String getHelpMessage() {
        return "Buy items from an npc";
    }

    @Override
    public boolean canUseIfDead() {
        return false;
    }
}
