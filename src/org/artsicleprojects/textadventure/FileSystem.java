package org.artsicleprojects.textadventure;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.artsicleprojects.ArtUtils.ArtUtils;
import org.artsicleprojects.artcoder.ArtCoder;
import org.artsicleprojects.textadventure.AreaCreatables.AreaEntity;
import org.artsicleprojects.textadventure.AreaCreatables.AreaMineable;
import org.artsicleprojects.textadventure.AreaCreatables.AreaNpc;
import org.artsicleprojects.textadventure.AreaCreatables.InventoryItem;
import org.artsicleprojects.textadventure.Areas.AreaHandler;

import java.io.*;
import java.util.*;

public class FileSystem {
    static Gson gson = new Gson();

    public static void AutoSaveGame(String name) {
        String path = "C:/"+Reference.NAME+"/saves/"+name+".zar";
        if(!new File(path).exists()) {
            try {
                new File(path).createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        Main.autosaveFileName = name;
    }

    public static void OverwriteSaveGame(String name) {
        try {
            if(! new File("C:/"+Reference.NAME+"/saves").exists()) {
                new File("C:/"+Reference.NAME+"/saves").mkdirs();
            }
            String path = "C:/"+Reference.NAME+"/saves/"+name+".zar";
            PrintWriter writer = new PrintWriter(path);
            if(!new File(path).exists()) {
                new File(path).createNewFile();
            }
            writer.write("");
            writer.close();
            writeToFile(path,name);
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void SaveGame(String name) {
        if(! new File("C:/"+Reference.NAME+"/saves").exists()) {
            new File("C:/"+Reference.NAME+"/saves").mkdirs();
        }
        String path = "C:/"+Reference.NAME+"/saves/"+name+".zar";
        File file = new File(path);
        if(! new File(path).exists()) {
            try {
                if(file.createNewFile()) {
                    writeToFile(path,name);
                    Main.addText("Saved game file to '"+name+".zar'");
                } else {
                    Main.addText("ERROR! Attemped to save game over a file that currently exists");
                    return;
                }
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        } else {
            Main.addText("ERROR! Attemped to save game over a file that currently exists");
            return;
        }
    }

    public static void writeToFile(String pathToFile,String name) {
        try {
            Main.deleteLogFile = false;
            FileWriter write = new FileWriter(pathToFile,true);
            PrintWriter writer = new PrintWriter(write);
            String player_energy = String.valueOf(Player.playerEnergy);
            String max_player_energy = String.valueOf(Player.maxPlayerEnergy);
            String player_health = String.valueOf(Player.playerHealth);
            String max_player_health = String.valueOf(Player.maxPlayerHealth);
            writer.println(ArtCoder.artCodeString("PLAYER_ENERGY@"+Player.playerEnergy));
            writer.println(ArtCoder.artCodeString("MONEY@"+Player.playerMoney));
            writer.println(ArtCoder.artCodeString("PLAYER_MAX_ENERGY@"+Player.maxPlayerEnergy));
            writer.println(ArtCoder.artCodeString("PLAYER_HEALTH@"+Player.playerHealth));
            writer.println(ArtCoder.artCodeString("PLAYER_MAX_HEALTH@"+Player.maxPlayerHealth));
            writer.println(ArtCoder.artCodeString("EQUIPPED_ITEM@"+gson.toJson(Player.equippedItem)));
            writer.println(ArtCoder.artCodeString("INVENTORY@"+gson.toJson(Player.inventory)));
            writer.println(ArtCoder.artCodeString("LOCAL_ITEMS@"+gson.toJson(Area.localItems)));
            writer.println(ArtCoder.artCodeString("LOCAL_ENTITIES@"+gson.toJson(Area.localEntities)));
            writer.println(ArtCoder.artCodeString("LOCAL_MINEABLES@"+gson.toJson(Area.localMineables)));
            writer.println(ArtCoder.artCodeString("LOCAL_NPCS@"+gson.toJson(Area.localNpcs)));
            writer.println(ArtCoder.artCodeString("PLAYER_REST_ENERGY_ADDITION@"+Player.REST_ENERGY_ADDITION));
            writer.println(ArtCoder.artCodeString("PLAYER_LEVEL@"+Player.level));
            writer.println(ArtCoder.artCodeString("PLAYER_EXPERIENCE@"+Player.xpPoints));
            writer.println(ArtCoder.artCodeString("PLAYER_DEAD@"+Player.dead));
            writer.println(ArtCoder.artCodeString("BIOME@"+Area.currentArea.getName()));
            writer.println(ArtCoder.artCodeString("PLAYER_NEXT_LEVEL_EXPERIENCE@"+Player.nextlevelXp));
            writer.println(ArtCoder.artCodeString("LAUNCH_DATE@"+String.valueOf(Main.launchDate.getTime())));
            writer.close();
        } catch(IOException ex)  {
            ex.printStackTrace();
        }
    }

    private static String getLoadGameString(String gkey,String name) {
        String str = "";
        File toDelete = new File("C:/" + Reference.NAME + "/logs/log" + Main.date.format(Main.launchDate) + ".txt");
        Main.deleteLogFile = true;
        String path = "C:/"+Reference.NAME+"/saves/"+name+".zar";
        File file = new File(path);
        if(file.exists()) {
            try {
                FileReader reader = new FileReader(file);
                BufferedReader breader = new BufferedReader(reader);
                List<String> strings = new ArrayList<>();
                String stri = "";
                while((str = breader.readLine()) != null) {
                    strings.add(stri);
                }
                HashMap<String,String> values = new HashMap<>();
                for(int i = 0;i < strings.size();i++) {
                    String currLineArtCoded = strings.get(i);
                    String currLineString = ArtCoder.deArtCodeString(strings.get(i));
                    ArtUtils.println(strings.get(i));
                    String[] currValue = ArtCoder.deArtCodeString(strings.get(i)).split("@");
                    values.put(currValue[0],currValue[1]);
                }
                for(Map.Entry<String,String> table : values.entrySet()) {
                    String key = table.getKey();
                    if(key.equalsIgnoreCase(gkey)) {
                        stri = table.getValue();
                        ArtUtils.print(stri);
                    }
                }
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }

        toDelete.delete();
        return str;
    }

    public static void DeleteGame(String name) {
        String path = "C:/"+Reference.NAME+"/saves/"+name+".zar";
        if(new File(path).exists()) {
            //new File("C:/" + Reference.NAME + "/logs/log" + Main.date.format(new Date(Long.valueOf(getLoadGameString("LAUNCH_DATE",name)) + ".txt"))).delete();
            File toDelete = new File(path);
            toDelete.delete();
            Main.addText("Deleted file '"+name+".zar'");
        } else {
            Main.addText("'"+name+".zar'"+Reference.FILE_NO_EXIST_MESSAGE);
        }
    }

    public static String[] getGames(String name) {
        return new String[0];
    }

    public static String[] getGamesNoExtension() {
        String path = "C:/"+Reference.NAME+"/saves/";
        String[] defaultReturn = new String[]{"No files found"};
        if(new File(path).listFiles().length == 0) {
            return defaultReturn;
        } else {
            ArrayList<String> strings = new ArrayList<>();
            for(File f : new File(path).listFiles()) {
                strings.add(f.getName());
            }
            String set[] = new String[strings.size()];
            String[] str = strings.toArray(set);
            return str;
        }
    }

    public static String[] listDataFromSave(String name) {
        String path = "C:/"+Reference.NAME+"/saves/"+name+".zar";
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();
        File file = new File(path);
        if(file.exists()) {
            try {
                FileReader reader = new FileReader(file);
                BufferedReader breader = new BufferedReader(reader);
                String str = "";
                while((str = breader.readLine()) != null) {
                    strings.add(str);
                }
                for(int i = 0;i < strings.size();i++) {
                    String currArtcoded = strings.get(i);
                    String currString = ArtCoder.deArtCodeString(strings.get(i));
                    values.add(currString);
                }

            } catch(IOException ex) {
                ex.printStackTrace();
            }
        } else {
            Main.addText("'"+name+".zar'"+Reference.FILE_NO_EXIST_MESSAGE);
        }

        String[] ex = new String[strings.size()];
        return values.toArray(ex);
    }

    public static void LoadGame(String name) {
        File toDelete = new File("C:/" + Reference.NAME + "/logs/log" + Main.date.format(Main.launchDate) + ".txt");
        Main.deleteLogFile = true;
        String path = "C:/"+Reference.NAME+"/saves/"+name+".zar";
        File file = new File(path);
        if(file.exists()) {
            try {
                FileReader reader = new FileReader(file);
                BufferedReader breader = new BufferedReader(reader);
                List<String> strings = new ArrayList<>();
                String str;
                while((str = breader.readLine()) != null) {
                    strings.add(str);
                }
                HashMap<String,String> values = new HashMap<>();
                for(int i = 0;i < strings.size();i++) {
                    String currLineArtCoded = strings.get(i);
                    String currLineString = ArtCoder.deArtCodeString(strings.get(i));
                    String[] currValue = ArtCoder.deArtCodeString(strings.get(i)).split("@");
                    values.put(currValue[0],currValue[1]);
                }
                for(Map.Entry<String,String> table : values.entrySet()) {
                    String key = table.getKey();
                    String value = table.getValue();
                    Boolean boolvalue = false;
                    Integer intvalue = 0;
                    Long longvalue = 0l;
                    if(!value.equalsIgnoreCase("null")) {
                        if(isAllNumeric(value)) {
                            longvalue = Long.parseLong(value);
                        }
                        System.out.println(key + " " + value);
                        if(!key.equalsIgnoreCase("LAUNCH_DATE")) {
                            if(isAllNumeric(value)) {
                                intvalue = Integer.parseInt(value);
                            }
                        }
                        if(value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
                            boolvalue = Boolean.parseBoolean(value);
                        }
                    }
                    if(key.equalsIgnoreCase("INVENTORY")) {
                        List<InventoryItem> inventoryFromFile;
                        inventoryFromFile = gson.fromJson(table.getValue(),new TypeToken<List<InventoryItem>>(){}.getType());
                        Player.inventory = inventoryFromFile;
                    } else if(is(key,"PLAYER_ENERGY")) {
                        Player.playerEnergy = intvalue;
                    } else if(is(key,"PLAYER_MAX_ENERGY")) {
                        Player.maxPlayerEnergy = intvalue;
                    } else if(is(key,"PLAYER_HEALTH")) {
                        Player.playerHealth = intvalue;
                    } else if(is(key,"PLAYER_MAX_HEALTH")) {
                        Player.maxPlayerHealth = intvalue;
                    } else if(is(key,"EQUIPPED_ITEM")) {
                        InventoryItem savedItem;
                        savedItem = gson.fromJson(value,InventoryItem.class);
                        Player.equippedItem = savedItem;
                    } else if(is(key,"PLAYER_MIN_HEALTH")) {
                        Player.minPlayerHealth = intvalue;
                    } else if(is(key,"PLAYER_MIN_ENERGY")) {
                        Player.minPlayerEnergy = intvalue;
                    } else if(is(key,"PLAYER_LEVEL")) {
                        Player.level = intvalue;
                    } else if(is(key,"PLAYER_EXPERIENCE")) {
                        Player.xpPoints = intvalue;
                    } else if(is(key,"PLAYER_DEAD")) {
                        Player.dead = boolvalue;
                    } else if(is(key,"PLAYER_NEXT_LEVEL_EXPERIENCE")) {
                        Player.nextlevelXp = intvalue;
                    } else if(is(key,"LAUNCH_DATE")) {
                        Main.launchDate = new Date(longvalue);
                        String all = "";
                        String cur = "";
                        FileReader read = new FileReader(new File("C:/Zarphorus/logs/log" + Main.date.format(Main.launchDate) + ".txt"));
                        BufferedReader br = new BufferedReader(read);
                        while((cur = br.readLine()) != null) {
                            all += cur + System.lineSeparator();
                        }
                        Main.deleteLogFile = false;
                        Main.console.setText(all);
                        Main.addText("Loaded log file ' log" + Main.date.format(Main.launchDate) + ".txt");
                    } else if(is(key,"LOCAL_ENTITIES")) {
                        List<AreaEntity> inventoryFromFile;
                        inventoryFromFile = gson.fromJson(table.getValue(),new TypeToken<List<AreaEntity>>(){}.getType());
                        Area.localEntities = inventoryFromFile;
                    } else if(is(key,"LOCAL_ITEMS")) {
                        ArrayList<InventoryItem> inventoryItemsFromFile;
                        inventoryItemsFromFile = gson.fromJson(table.getValue(),new TypeToken<List<InventoryItem>>(){}.getType());
                        Area.localItems = inventoryItemsFromFile;
                    } else if(is(key,"LOCAL_MINEABLES")) {
                        ArrayList<AreaMineable> areaMineablesFromFile;
                        areaMineablesFromFile = gson.fromJson(table.getValue(),new TypeToken<List<AreaMineable>>(){}.getType());
                        Area.localMineables = areaMineablesFromFile;
                    } else if(is(key,"LOCAL_NPCS")) {
                        ArrayList<AreaNpc> areaNpcsFromFile;
                        areaNpcsFromFile = gson.fromJson(table.getValue(),new TypeToken<List<AreaNpc>>(){}.getType());
                        Area.localNpcs = areaNpcsFromFile;
                    } else if(is(key,"BIOME")) {
                        org.artsicleprojects.textadventure.Areas.Area area = AreaHandler.getAreaByName(value);
                    } else if(is(key,"MONEY")) {
                        Player.playerMoney = Float.valueOf(value);
                    }
                }
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        } else {
            Main.addText("'"+name+".zar'"+Reference.FILE_NO_EXIST_MESSAGE);
        }

        toDelete.delete();
    }

    public static boolean is(String compar1,String compar2) {
        if(compar1.equalsIgnoreCase(compar2)) {
            return true;
        }
        return false;
    }

    public static boolean eis(String compar1,String compar2) {
        if(compar1.equals(compar2)) {
            return true;
        }
        return false;
    }

    public static boolean isAllNumeric(String input) {
        boolean numeric = true;
        for(int i = 0; i < input.length();i++) {
            if(!Character.isDigit(input.charAt(i))) {
                numeric = false;
            }
        }
        return numeric;
    }
}
