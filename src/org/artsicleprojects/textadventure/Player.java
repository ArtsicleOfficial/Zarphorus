package org.artsicleprojects.textadventure;

import org.artsicleprojects.ArtUtils.ArtUtils;
import org.artsicleprojects.textadventure.AreaCreatables.AreaEntity;
import org.artsicleprojects.textadventure.AreaCreatables.AreaMineable;
import org.artsicleprojects.textadventure.AreaCreatables.InventoryItem;
import org.artsicleprojects.textadventure.Crafts.CraftingItem;
import org.artsicleprojects.textadventure.Entities.EntityHandler;
import org.artsicleprojects.textadventure.Enums.GameMessages;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Enums.ToolClasses;
import org.artsicleprojects.textadventure.Items.Item;
import org.artsicleprojects.textadventure.Items.ItemHandler;
import org.artsicleprojects.textadventure.Mineables.Mineable;
import org.artsicleprojects.textadventure.Mineables.MineableHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    public static InventoryItem equippedItem;
    public static List<InventoryItem> inventory = new ArrayList<>();

    public static Boolean dead = false;

    public static Integer playerEnergy = 100;
    public static Integer maxPlayerEnergy = 100;
    public static Integer minPlayerEnergy = 0;
    public static Integer playerHealth = 100;
    public static Integer minPlayerHealth = 0;
    public static Integer maxPlayerHealth = 100;
    public static Integer xpPoints = 1;
    public static Integer level = 1;
    public static Integer nextlevelXp = getNextLevelXp();
    public static Integer REST_ENERGY_ADDITION = 1;
    public static Float playerMoney = 0f;

    public static void addPlayerMoney(Float add) {
        playerMoney += add;
        playerMoney = ArtUtils.toFixedDecimalLength(playerMoney,2);
    }
    public static boolean getDead() {
        return dead;
    }
    public static Integer getXpPoints() {
        return xpPoints;
    }
    public static Integer getPlayerEnergy() {
        return playerEnergy;
    }
    public static Integer getPlayerHealth() {
        return playerHealth;
    }
    public static Integer getMinPlayerEnergy() {
        return minPlayerEnergy;
    }
    public static Integer getMaxPlayerEnergy() {
        return maxPlayerEnergy;
    }
    public static Integer getMaxPlayerHealth() {
        return maxPlayerHealth;
    }
    public static Integer getMinPlayerHealth() {
        return minPlayerHealth;
    }
    public static Integer getRestEnergyAddition() {
        return REST_ENERGY_ADDITION;
    }
    public static Integer getLevel() {
        return level;
    }
    public static Integer getNextLevelXp() {
        Integer basexp = 100;
        Double exponent = 1.25;
        return ((int)Math.round(basexp*(Math.pow(level,exponent))));
    }
    public static void levelUpAttempt() {
        if(xpPoints >= getNextLevelXp()) {
            xpPoints-=getNextLevelXp();
            level++;
            nextlevelXp = getNextLevelXp();
        }
    }
    public static void mineMineable(InventoryItem with, Integer index) {
        if(ItemHandler.getItemByInventoryItem(with).isTool()) {
            Integer level;
            level = MineableHandler.getMineableByClass(Area.localMineables.get(index).CLASS).getMinimumHarvestLevel();
            if(ItemHandler.getItemByInventoryItem(with).getHarvestLevel() >= level) {
                Area.localMineables.get(index).DURABILITY-=ItemHandler.getItemByInventoryItem(with).getToolDamage();
                Player.addInventoryItem(new InventoryItem(ItemHandler.getItemByInventoryItem(with).getToolDamage()/3,MineableHandler.getMineableByClass(Area.localMineables.get(index).CLASS).getDrop()));
                if(Area.localMineables.get(index).DURABILITY <= 0) {
                    Area.localMineables.remove(index);
                }
            } else {
                GameMessages.tooLowHarvestLevel.Reset();
                GameMessages.tooLowHarvestLevel.SetItem(ItemHandler.getItemByInventoryItem(with));
                GameMessages.tooLowHarvestLevel.PrintMessage();
            }
        }
    }
    public static boolean tryRemoveEnergy(int rem) {
        if(playerEnergy >= rem) {
            playerEnergy -= rem;
            return true;
        } else {
            return false;
        }
    }
    public static void addPlayerHealth(Integer add) {
        playerHealth += add;
        savePlayerHealth();
    }
    public static void removePlayerHealth(Integer remove) {
        playerHealth -= remove;
        savePlayerHealth();
    }
    public static void setPlayerHealth(Integer set) {
        playerHealth = set;
        savePlayerHealth();
    }
    public static boolean inventoryHasItem(InventoryItem compar) {
        boolean has = false;
        for(InventoryItem v : inventory) {
            if(v.ITEM_CLASS == compar.ITEM_CLASS) {
                has = true;
            }
        }
        return has;
    }
    public static boolean removeInventoryItem(ItemClasses id, Integer count) {
        for(int i = 0;i <inventory.size();i++) {
            InventoryItem fsa = inventory.get(i);
            if(fsa.ITEM_CLASS == id) {
                if(fsa.COUNT >= count) {
                    inventory.get(i).COUNT-=count;
                    saveInventory();
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    public static boolean amountBiggerThanInventoryItem(ItemClasses id, Integer count) {
        for(int i = 0;i <inventory.size();i++) {
            InventoryItem fsa = inventory.get(i);
            if(fsa.ITEM_CLASS == id) {
                if(count >= fsa.COUNT) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    public static boolean amountSmallerThanInventoryItem(ItemClasses id, Integer count) {
        for(int i = 0;i <inventory.size();i++) {
            InventoryItem fsa = inventory.get(i);
            if(fsa.ITEM_CLASS == id) {
                if(count <= fsa.COUNT) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean inventoryHasItem(Item compar) {
        boolean has = false;
        for(InventoryItem v : inventory) {
            if(v.ITEM_CLASS == compar.getItemClass()) {
                has = true;
            }
        }
        return has;
    }
    public static boolean inventoryHasItem(ItemClasses compar) {
        boolean has = false;
        for(InventoryItem v : inventory) {
            if(v.ITEM_CLASS.getID() == compar.getID()) {
                has = true;
            }
        }
        return has;
    }
    public static boolean inventoryHasItem(CraftingItem compar) {
        boolean has = false;
        for(InventoryItem v : inventory) {
            if(v.ITEM_CLASS == ItemHandler.getItemByName(compar.ITEM).getItemClass()) {
                has = true;
            }
        }
        return has;
    }
    public static Integer attackPlayer(AreaEntity attacker) {
        Integer s = Integer.valueOf(EntityHandler.getEntityByClass(attacker.ENTITY_CLASS).attackDamage());
        if(playerHealth-s >= minPlayerHealth) {
            playerHealth -= s;
        } else {
            playerDeath();
        }
        return s;
    }
    public static void getAttackedByAreaEntities() {
        for(int i = 0; i < Area.localEntities.size(); i++) {
            if(Area.localEntities.get(i).ATTACKING_PLAYER) {
                Integer oofPower = Player.attackPlayer(Area.localEntities.get(i));
                GameMessages.attackedByEntity.Reset();
                GameMessages.attackedByEntity.SetEntity(EntityHandler.getEntityByAreaEntity(Area.localEntities.get(i)));
                GameMessages.attackedByEntity.SetLoss(Float.valueOf(oofPower));
                GameMessages.attackedByEntity.PrintMessage();
            }
        }
    }
    public static void experienceAdd(int xp) {
        xpPoints+=xp;
        levelUpAttempt();
    }
    public static void addExperience(AreaEntity deadEntity) {
        int xp = EntityHandler.getEntityByAreaEntity(deadEntity).getXpOnDeath();
        experienceAdd(xp);
        Main.addText(xp + " experience gained");
    }
    public static void playerDeath() {
        Main.addText("You died");
        dead = true;
    }
    public static void savePlayerHealth() {
        if(playerHealth >= maxPlayerHealth) {
            playerHealth = maxPlayerHealth;
        }
        if(playerHealth <= minPlayerHealth) {
            playerHealth = minPlayerHealth;
            dead = true;
        }
    }
    public static void setDead(Boolean dea) {
        dead = dea;
        if(!dea) {
            //death

        } else {
            //no death

        }
    }

    public Player() {
        nextlevelXp = (int)Math.floor(level*150);
        inventory.add(new InventoryItem(2,ItemClasses.BREAD));
        inventory.add(new InventoryItem(1,ItemClasses.BACON));
        addPlayerMoney(ArtUtils.randomFloat(100,200f));
    }

    public static void addEnergy(Integer add) {
        playerEnergy += add;
        preventOverflow();
    }
    public static void removeEnergy(Integer rem) {
        playerEnergy -= rem;
        preventOverflow();
    }
    public static void setEnergy(Integer set) {
        playerEnergy = set;
        preventOverflow();
    }
    public static void saveInventory() {
        for(int i = 0;i < inventory.size();i++) {
            if(inventory.get(i).COUNT < 1) {
                inventory.remove(i);
            }
        }
        for(int i = 0;i < inventory.size();i++) {
            for(int l = 0;l < inventory.size();l++) {
                if(inventory.get(i) != inventory.get(l) && inventory.get(i).ITEM_CLASS == inventory.get(l).ITEM_CLASS) {
                    inventory.get(i).COUNT += inventory.get(l).COUNT;
                    inventory.remove(l);
                }
            }
        }
    }
    public static void addInventoryItem(InventoryItem item) {
        boolean done = false;
        if(equippedItem != null) {
            if(equippedItem.ITEM_CLASS.getID() == item.ITEM_CLASS.getID()) {
                equippedItem.COUNT += item.COUNT;
                done = true;
            }
        }
        if(! done) {
            inventory.add(item);
            saveInventory();
        }
        Main.addText("Added " + item.COUNT + " * " + ItemHandler.getItemByInventoryItem(item).getItemName() + " to player inventory");
    }
    public static void noPrintAddInventoryItem(InventoryItem item) {
        boolean done = false;
        if(equippedItem != null) {
            if(equippedItem.ITEM_CLASS == item.ITEM_CLASS) {
                equippedItem.COUNT += item.COUNT;
                done = true;
            }
        }
        if(! done) {
            inventory.add(item);
            saveInventory();
        }
    }
    public static Integer eatFood(Item item) {
        if(Player.equippedItem != null) {
            if(Player.equippedItem.ITEM_CLASS.getID() == item.getItemClass().getID()) {
                if(item.isFood()) {
                    Integer prev = playerEnergy;
                    Random random = new Random();
                    Integer a = random.nextInt((item.getMinAndMaxFoodValue()[1]-item.getMinAndMaxFoodValue()[0])+1)+item.getMinAndMaxFoodValue()[0];
                    Player.addEnergy(a);
                    Player.equippedItem.COUNT -= 1;
                    if(Player.equippedItem.COUNT <= 0) {
                        Player.equippedItem = null;
                    }
                    Integer energyDifference = playerEnergy-prev;
                    return energyDifference;
                }
            }
        }
        {
            for(int i = 0;i < inventory.size();i++) {
                if(item == ItemHandler.getItemByInventoryItem(inventory.get(i))) {
                    if(item.isFood()) {
                        Integer prev = playerEnergy;
                        Random random = new Random();
                        Integer a = random.nextInt((item.getMinAndMaxFoodValue()[1]-item.getMinAndMaxFoodValue()[0])+1)+item.getMinAndMaxFoodValue()[0];
                        Player.addEnergy(a);
                        inventory.get(i).COUNT -= 1;
                        if(inventory.get(i).COUNT <= 0) {
                            inventory.remove(i);
                        }
                        Integer energyDifference = playerEnergy-prev;
                        return energyDifference;
                    }
                    break;
                }
            }
        }
        return Reference.EMPTY_NUMBER;
    }
    public static void preventOverflow() {
        if(playerEnergy >= maxPlayerEnergy) {
            playerEnergy = maxPlayerEnergy;
        }
        if(playerEnergy <= minPlayerEnergy) {
            playerEnergy = minPlayerEnergy;
        }
    }
}
