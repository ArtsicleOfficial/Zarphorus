package org.artsicleprojects.textadventure.Crafts;

import com.google.gson.*;
import org.artsicleprojects.textadventure.AreaCreatables.InventoryItem;
import org.artsicleprojects.textadventure.Items.ItemHandler;
import org.artsicleprojects.textadventure.Main;
import org.artsicleprojects.textadventure.Player;
import org.artsicleprojects.textadventure.Reference;

import java.io.*;
import java.util.*;

public class Crafting {
    public static List<String> getRecipeNames() {
        List<String> files = new ArrayList<>();
        if(new File("src/Crafting").listFiles().length >= 1) {
            for(File file : new File("src/Crafting").listFiles()) {
                files.add(file.getName().replace(".json",""));
            }
        } else {
            files.add("No recipes found!");
        }
        return files;
    }
    public static List<String> getIngredients(String recipeName) {
        List<String> ingredients = new ArrayList<>();
        File isFile = null;
        if(new File("src/Crafting/" + recipeName + ".json").exists()) {
            isFile = new File("src/Crafting/" + recipeName + ".json");
        }
        if(isFile != null) {
            try {
                List<String> strings = new ArrayList<>();
                String all = "";
                FileReader s = new FileReader(isFile);
                BufferedReader reader = new BufferedReader(s);
                String l;
                while((l = reader.readLine()) != null) {
                    strings.add(l);
                    all += l+"\n";
                }
                ArrayList<JsonObject> objs = getObjectsFromArray(all,"ingredients");
                List<CraftingItem> items = new ArrayList<>();
                for(int i = 0;i < objs.size();i++) {
                    if(objs.get(i).has("ingredient")) {
                        CraftingItem item = new CraftingItem();
                        item.COUNT = Integer.valueOf(parseNV(objs.get(i),"count"));
                        item.TYPE = parseNV(objs.get(i),"type");
                        item.ITEM = parseNV(objs.get(i),"ingredient");
                        items.add(item);
                    }
                }

                for(CraftingItem item : items) {
                    ingredients.add(item.COUNT + " * " + item.ITEM);
                }
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }
        return ingredients;
    }
    public static void craftItem(String toCraft) {
        boolean isAny = false;
        boolean any = false;
        for(File f : new File("src/Crafting/").listFiles()) {
            //JsonObject l = new JsonParser().parse()
            String n = f.getName().replace(".json","");

            if(n.equalsIgnoreCase(toCraft)) {
                isAny = true;
            }
            if(n.equalsIgnoreCase(toCraft)) {
                any = true;
            }
            if(n.equalsIgnoreCase(toCraft)) {

                try {
                    List<String> strings = new ArrayList<>();
                    String all = "";
                    FileReader s = new FileReader(f);
                    BufferedReader reader = new BufferedReader(s);
                    String l;
                    while((l = reader.readLine()) != null) {
                        strings.add(l);
                        all += l+"\n";
                    }
                    String ingredients = getArrayFromAll(all,"ingredients");
                    JsonArray ingredientsO = getArrayOFromAll(all,"ingredients");
                    ArrayList<JsonObject> objs = getObjectsFromArray(all,"ingredients");
                    String result = parseNV(all,"result");
                    Integer resultCount = Integer.parseInt(parseNV(all,"resultCount"));
                    Gson gson = new Gson();
                    ArrayList<CraftingItem> items = new ArrayList<>();
                    for(int i = 0;i < objs.size();i++) {
                        if(objs.get(i).has("ingredient")) {
                            CraftingItem item = new CraftingItem();
                            item.COUNT = Integer.valueOf(parseNV(objs.get(i),"count"));
                            item.TYPE = parseNV(objs.get(i),"type");
                            item.ITEM = parseNV(objs.get(i),"ingredient");
                            items.add(item);
                        }
                    }
                    boolean canCraft = true;
                    for(int i = 0;i < items.size();i++) {
                        CraftingItem item = items.get(i);
                        if(! Player.inventoryHasItem(item)) {
                            canCraft = false;
                            Main.addText("You do not have '" + item.ITEM + "'.");
                        }
                    }
                    for(int i = 0;i < items.size();i++) {
                        CraftingItem item = items.get(i);
                        for(int z = 0;z < Player.inventory.size();z++) {
                            if(Player.inventory.get(z).ITEM_CLASS == ItemHandler.getItemByName(item.ITEM).getItemClass())
                            if(!(Player.inventory.get(z).COUNT >= item.COUNT)) {
                                canCraft = false;
                                Main.addText("Not enough of '" + item.ITEM + "' to craft.");
                                return;
                            }
                        }
                    }
                    if(canCraft) {
                        boolean craftCan = true;
                        if(craftCan) {
                            for(int i = 0;i < items.size();i++) {
                                Player.removeInventoryItem(ItemHandler.getItemByName(items.get(i).ITEM).getItemClass(),items.get(i).COUNT);
                                isAny = false;
                            }
                            Player.addInventoryItem(new InventoryItem(resultCount,ItemHandler.getItemByName(result).getItemClass()));
                            Main.addText("Crafted");
                            return;
                        }
                    }
                } catch(IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        if(!any) {
            Main.addText("'" + toCraft  + "' is not a crafting recipe");
        }
    }

    private static String parse(String input) {
        String l = "";
        return l;
    }

    private static String parseNV(String all,String get) {
        String l = "";
        JsonParser parser = new JsonParser();
        JsonObject elem = parser.parse(all).getAsJsonObject();
        l = elem.get(get).getAsString();
        return l;
    }

    private static String parseNV(JsonObject from,String get) {
        String l = "";
        JsonParser parser = new JsonParser();
        l = from.get(get).getAsString();
        return l;
    }

    private static JsonObject getObject(String all,String objectName) {
        JsonObject l = null;
        JsonParser parser = new JsonParser();
        JsonObject elem = parser.parse(all).getAsJsonObject();
        if(elem.get(objectName).isJsonObject()) {
            l = elem.get(objectName).getAsJsonObject();
        }
        return l;
    }

    private static JsonObject getObject(JsonObject from,String objectName) {
        JsonObject l = null;
        JsonParser parser = new JsonParser();
        if(from.get(objectName).isJsonObject()) {
            l = from.get(objectName).getAsJsonObject();
        }
        return l;
    }

    private static Map<String,String> getNVsFromArray(String all,String arrayName) {
        Map<String,String> l = new LinkedHashMap<>();
        JsonParser parser = new JsonParser();
        JsonObject elem = parser.parse(all).getAsJsonObject();
        if(elem.get(arrayName).isJsonArray()) {
            JsonArray arr = elem.get(arrayName).getAsJsonArray();
            for(JsonElement e : arr) {
                if(e.isJsonObject()) {
                    JsonObject objectFromE = e.getAsJsonObject();
                    for(Map.Entry<String,JsonElement> f : objectFromE.entrySet()) {
                        Map<String,String> keyAndValue = new HashMap<>();
                        l.put(f.getKey(),f.getValue().getAsString());
                    }
                }
            }
        }
        return l;
    }

    private static Map<String,String> getNVsFromObject(String all,JsonObject array) {
        Map<String,String> l = new LinkedHashMap<>();
        JsonParser parser = new JsonParser();
        JsonObject elem = parser.parse(all).getAsJsonObject();
        for(Map.Entry<String,JsonElement> f : array.entrySet()) {
            l.put(f.getKey(),f.getValue().toString());
        }
        return l;
    }

    private static Map<String,String> getNVsFromArray(String all,JsonArray array) {
        Map<String,String> l = new LinkedHashMap<>();
        JsonParser parser = new JsonParser();
        JsonObject elem = parser.parse(all).getAsJsonObject();
        for(JsonElement e : array) {
            if(e.isJsonObject()) {
                JsonObject objectFromE = e.getAsJsonObject();
                for(Map.Entry<String,JsonElement> f : objectFromE.entrySet()) {
                    Map<String,String> keyAndValue = new HashMap<>();
                    l.put(f.getKey(),f.getValue().getAsString());
                }
            }
        }
        return l;
    }

    private static List<String> getArrayFromObject(String all,String from,String arrayName) {
        List<String> l = new ArrayList<>();
        JsonParser parser = new JsonParser();
        JsonObject elem = parser.parse(all).getAsJsonObject();
        JsonObject fro = elem.get(from).getAsJsonObject();
        if(fro.get(arrayName).isJsonArray()) {
            JsonArray ele = elem.get(arrayName).getAsJsonArray();
            for(JsonElement e : ele) {
                l.add(e.getAsString());
            }
            return l;
        } else {
            l.add(Reference.FAIL_MESSAGE);
            return l;
        }
    }

    private static String getArrayFromAll(String all,String arrayName) {
        String l = Reference.FAIL_MESSAGE;
        JsonParser parser = new JsonParser();
        JsonObject elem = parser.parse(all).getAsJsonObject();
        if(elem.get(arrayName).isJsonArray()) {
            return elem.get(arrayName).toString();
        } else {
            return null;
        }
    }

    private static ArrayList<JsonObject> getObjectsFromArray(String all,String arrayName) {
        ArrayList<JsonObject> objs = new ArrayList<>();
        JsonParser parser = new JsonParser();
        JsonObject elem = parser.parse(all).getAsJsonObject();
        if(elem.get(arrayName).isJsonArray()) {
            for(JsonElement e : elem.get(arrayName).getAsJsonArray()) {
                if(e.isJsonObject()) {
                    objs.add(e.getAsJsonObject());
                }
            }
            return objs;
        }
        return null;
    }

    private static JsonArray getArrayOFromAll(String all,String arrayName) {
        String l = Reference.FAIL_MESSAGE;
        JsonParser parser = new JsonParser();
        JsonObject elem = parser.parse(all).getAsJsonObject();
        if(elem.get(arrayName).isJsonArray()) {
            return elem.get(arrayName).getAsJsonArray();
        } else {
            return null;
        }
    }

    private static String getObjectFromAll(String all,String arrayName) {
        String l = Reference.FAIL_MESSAGE;
        JsonParser parser = new JsonParser();
        JsonObject elem = parser.parse(all).getAsJsonObject();
        if(elem.get(arrayName).isJsonArray()) {
            return elem.getAsString();
        } else {

            return l;
        }
    }
}
