package org.artsicleprojects.textadventure.Enums;

import org.artsicleprojects.textadventure.Entities.Entity;
import org.artsicleprojects.textadventure.Items.Item;
import org.artsicleprojects.textadventure.Main;
import org.artsicleprojects.textadventure.Npcs.Npc;
import org.artsicleprojects.textadventure.Player;

public enum GameMessages {
    tooLowHarvestLevel("Item '<item_name>' doesn't have a high enough harvest level"),
    loseHealth(" - <loss> health"),
    touchingItemHurts("Touching that <item_name> hurts"),
    energyTooLow("Player energy is too low! (<player_energy>/<player_max_energy>"),
    attackEntity("Attacked <entity_name> for <loss>"),
    tooDark("It is too dark! You are hitting walls and losing health! You need a light source"),
    boughtItem("Bought <item_name> from <npc_name> for <loss>"),
    attackedByEntity("Attacked by <entity_name> for <loss>"),
    itemDropped("<loss> * <item_name> dropped onto ground"),
    notEnoughOfItem("Not enough of <item_name>, Required: <loss>");

    private String value;
    private String unchanged;
    public String getValue() {
        return value;
    }
    public void Reset() {
        value = unchanged;
    }
    public void PrintMessage() {
        Main.addText(value);
    }
    public void SetLoss(Float loss) {
        value = value.replace("<loss>",String.valueOf(loss));
    }
    public void SetEntity(Entity entity) {
        value = value.replace("<entity_name>",entity.getEntityName());
    }
    public void SetNpc(Npc npc) {
        value = value.replace("<npc_name>",npc.getName());
    }
    public void Update() {
        value = value.replace("<player_energy>",String.valueOf(Player.playerEnergy));
        value = value.replace("<player_health>",String.valueOf(Player.playerHealth));
        value = value.replace("<player_max_energy>",String.valueOf(Player.maxPlayerEnergy));
        value = value.replace("<player_max_health>",String.valueOf(Player.maxPlayerHealth));
    }
    public void SetItem(Item item) {
        this.value = this.value.replace("<item_name>",item.getItemName());
    }
    GameMessages(String value) {
        this.value = value;
        this.unchanged = value;
    }
}
