package org.artsicleprojects.textadventure.Commands;

import org.artsicleprojects.textadventure.Crafts.Crafting;
import org.artsicleprojects.textadventure.Items.Item;
import org.artsicleprojects.textadventure.Items.ItemHandler;
import org.artsicleprojects.textadventure.Main;
import org.artsicleprojects.textadventure.Reference;

import java.util.ArrayList;
import java.util.List;

public class Craft implements Command {
    @Override
    public String[] getCommand() {
        return new String[]{"craft","crafting"};
    }

    @Override
    public boolean commandPerformed(String[] args) {
        if(args[0] != Reference.NO_ARGUMENTS_MESSAGE) {
            if(args.length == 1) {
                Crafting.craftItem(args[0]);
                return true;
            }
            if(args.length == 2) {
                if(args[0].equalsIgnoreCase("list")) {
                    if(args[1].equalsIgnoreCase("recipes")) {
                        List<String> recipes = Crafting.getRecipeNames();
                        for(String string : recipes) {
                            Main.addText(string);
                        }
                        return true;
                    }
                } else if(args[0].equalsIgnoreCase("ingredients")) {
                    List<String> ingredients = Crafting.getIngredients(args[1]);
                    for(String ingredient : ingredients) {
                        Main.addText(ingredient);
                    }
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public String getCommandFailMessage() {
        return "USAGE: craft <##craftingrecipe> OR craft list recipes OR craft ingredients <##craftingrecipe>";
    }

    @Override
    public String getHelpMessage() {
        return "Craft items";
    }

    @Override
    public boolean canUseIfDead() {
        return false;
    }
}
