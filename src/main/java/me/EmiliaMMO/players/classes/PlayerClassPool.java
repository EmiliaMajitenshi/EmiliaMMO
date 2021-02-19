package me.EmiliaMMO.players.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.entity.Player;

import me.EmiliaMMO.data.players.PlayerConfigurator;

public class PlayerClassPool {
    private static List<PlayerClass> playerClassList = new ArrayList<>();

    private static Map<String, PlayerClass> playerClassMap = new HashMap<>();

    public static PlayerClass getClass(String className) {
        return playerClassMap.get(className);
    }

    public static PlayerClass getPlayerClass(Player player) {
        return getClass(PlayerConfigurator.getPlayerClassString(player));
    }

    public static List<PlayerClass> getAllClasses() {
        return new ArrayList<>(playerClassList);
    }

    public static List<String> getAllClassNames() {
        return new ArrayList<>(playerClassMap.keySet());
    }

    public static int getClassCount() {
        return playerClassMap.size();
    }

    public static void registerClass(PlayerClass playerClass) {
        playerClassMap.put(playerClass.getClassName(), playerClass);
        playerClassList.add(playerClass);
        playerClassList.sort((class1, class2) -> class2.getClassName().compareTo(class1.getClassName()));
    }
}
