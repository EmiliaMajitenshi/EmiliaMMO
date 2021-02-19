package me.EmiliaMMO.data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.EmiliaMMO.Main;

/**
 * Collection of methods for reading and writing data in player config files.
 */
public class PlayerConfigurationUtils {

    private static Main core = Main.getInstance();

    private static File getPlayerDataFile(Player player) {
        return new File(core.getDataFolder(), "userdata" + File.separator + player.getUniqueId() + ".yml");
    }

    private static File getPlayerDataFile(OfflinePlayer player) {
        return new File(core.getDataFolder(), "userdata" + File.separator + player.getUniqueId() + ".yml");
    }

    protected static void playerConfigSet(Player player, String key, String value) {
        try {
            File playerDataFile = getPlayerDataFile(player);
            FileConfiguration playerDataConfig = YamlConfiguration.loadConfiguration(playerDataFile);

            playerDataConfig.set(key, value);
            playerDataConfig.save(playerDataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static void playerConfigSet(OfflinePlayer player, String key, String value) {
        try {
            File playerDataFile = getPlayerDataFile(player);
            FileConfiguration playerDataConfig = YamlConfiguration.loadConfiguration(playerDataFile);

            playerDataConfig.set(key, value);
            playerDataConfig.save(playerDataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static String playerConfigGetString(Player player, String key) {
        File playerDataFile = getPlayerDataFile(player);
        FileConfiguration playerDataConfig = YamlConfiguration.loadConfiguration(playerDataFile);
        return playerDataConfig.getString(key);
    }

    protected static String playerConfigGetString(OfflinePlayer player, String key) {
        File playerDataFile = getPlayerDataFile(player);
        FileConfiguration playerDataConfig = YamlConfiguration.loadConfiguration(playerDataFile);
        return playerDataConfig.getString(key);
    }

    protected static List<String> playerConfigGetStringList(Player player, String key) {
        File playerDataFile = getPlayerDataFile(player);
        FileConfiguration playerDataConfig = YamlConfiguration.loadConfiguration(playerDataFile);
        return playerDataConfig.getStringList(key);
    }

    protected static List<String> playerConfigGetStringList(OfflinePlayer player, String key) {
        File playerDataFile = getPlayerDataFile(player);
        FileConfiguration playerDataConfig = YamlConfiguration.loadConfiguration(playerDataFile);
        return playerDataConfig.getStringList(key);
    }

    protected static Integer playerConfigGetInt(Player player, String key) {
        File playerDataFile = getPlayerDataFile(player);
        FileConfiguration playerDataConfig = YamlConfiguration.loadConfiguration(playerDataFile);
        return playerDataConfig.getInt(key);
    }

    protected static Integer playerConfigGetInt(OfflinePlayer player, String key) {
        File playerDataFile = getPlayerDataFile(player);
        FileConfiguration playerDataConfig = YamlConfiguration.loadConfiguration(playerDataFile);
        return playerDataConfig.getInt(key);
    }

    protected static Long playerConfigGetLong(Player player, String key) {
        File playerDataFile = getPlayerDataFile(player);
        FileConfiguration playerDataConfig = YamlConfiguration.loadConfiguration(playerDataFile);
        return playerDataConfig.getLong(key);
    }

    protected static Long playerConfigGetLong(OfflinePlayer player, String key) {
        File playerDataFile = getPlayerDataFile(player);
        FileConfiguration playerDataConfig = YamlConfiguration.loadConfiguration(playerDataFile);
        return playerDataConfig.getLong(key);
    }

    protected static Double playerConfigGetDouble(Player player, String key) {
        File playerDataFile = getPlayerDataFile(player);
        FileConfiguration playerDataConfig = YamlConfiguration.loadConfiguration(playerDataFile);
        return playerDataConfig.getDouble(key);
    }

    protected static Double playerConfigGetDouble(OfflinePlayer player, String key) {
        File playerDataFile = getPlayerDataFile(player);
        FileConfiguration playerDataConfig = YamlConfiguration.loadConfiguration(playerDataFile);
        return playerDataConfig.getDouble(key);
    }

    protected static Boolean playerConfigGetBoolean(Player player, String key) {
        File playerDataFile = getPlayerDataFile(player);
        FileConfiguration playerDataConfig = YamlConfiguration.loadConfiguration(playerDataFile);
        return playerDataConfig.getBoolean(key);
    }

    protected static Boolean playerConfigGetBoolean(OfflinePlayer player, String key) {
        File playerDataFile = getPlayerDataFile(player);
        FileConfiguration playerDataConfig = YamlConfiguration.loadConfiguration(playerDataFile);
        return playerDataConfig.getBoolean(key);
    }

    protected static Location playerConfigGetLocation(Player player, String key) {
        File playerDataFile = getPlayerDataFile(player);
        FileConfiguration playerDataConfig = YamlConfiguration.loadConfiguration(playerDataFile);
        List<Double> cords = new ArrayList<Double>();
        for (String cord : playerDataConfig.getString(key).split(" ")) {
            cords.add(Double.parseDouble(cord));
        }
        return new Location(Bukkit.getWorld(playerConfigGetString(player, "pos.world")), cords.get(0), cords.get(1),
                cords.get(2));
    }

    protected static ItemStack[] playerConfigGetItemStacks(Player player, String key) {
        File playerDataFile = getPlayerDataFile(player);
        FileConfiguration playerDataConfig = YamlConfiguration.loadConfiguration(playerDataFile);
        List<?> itemStackList = playerDataConfig.getList(key);
        return itemStackList != null ? itemStackList.toArray(new ItemStack[0]) : new ItemStack[0];
    }
}
