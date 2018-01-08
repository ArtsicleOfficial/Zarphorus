package org.artsicleprojects.textadventure.Commands;

import org.artsicleprojects.ArtUtils.ArtUtils;
import org.artsicleprojects.textadventure.*;
import org.artsicleprojects.textadventure.AreaCreatables.InventoryItem;
import org.artsicleprojects.textadventure.Items.ItemHandler;
import org.artsicleprojects.textadventure.Player;


public class Drop implements Command
{
	@Override
	public String[] getCommand()
	{
		return new String[]{"drop"};
	}

	@Override
	public boolean commandPerformed(String[] args)
	{
		if(args[0].equalsIgnoreCase(Reference.NO_ARGUMENTS_MESSAGE) || args.length == 1) {
			return false;
		}
		if (ArtUtils.isStringAllNumeric(args[1]))
		{
			String zer = args[0];
			Integer one = Integer.valueOf(args[1]);
			Boolean isItem = false;
			for (int i = 0; i < ItemHandler.items.size(); i++)
			{
				if (ItemHandler.items.get(i) == ItemHandler.getItemByName(zer))
				{
					isItem = true;
					break;
				}
			}
			if (isItem)
			{
				Boolean inInventory = false;
				Integer itemInventory = 0;
				InventoryItem item = null;
				for(int l = 0;l < Player.inventory.size();l++) {
					if(ItemHandler.getItemByInventoryItem(Player.inventory.get(l)).getItemName() == zer) {
						inInventory = true;
						itemInventory = l;
						item = Player.inventory.get(l);
					}
				}
				if(inInventory) {
					if(item.COUNT >= one) {
						Area.addItemToArea(new InventoryItem(one,item.ITEM_CLASS));
						item.COUNT -= one;
						if(item.COUNT <= 0) {
							Player.inventory.remove(item);
						}
						Main.addText("Dropped " + one + " of '" + zer + "' (" + ItemHandler.getItemByName(zer).getItemName() + ") onto the ground");
					} else {
						Main.addText("Not enough of '" + ItemHandler.getItemByClass(item.ITEM_CLASS).getItemName() + "' in inventory");
					}
				} else {
					Main.addText("'" + zer + "' (" + ItemHandler.getItemByName(zer).getItemName() + ") is not in your inventory");
				}
			} else
			{
				Main.addText("'" + zer + "' is not an item");
			}
			return true;
		}
		return false;
	}

	@Override
	public String getCommandFailMessage()
	{
		return "drop <##itemname> <##amount>";
	}

	@Override
	public String getHelpMessage() {
		return "Drops item specified";
	}

	@Override
	public boolean canUseIfDead() {
		return false;
	}
}
