package me.EmiliaMMO.data.players;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import me.EmiliaMMO.data.PlayerConfigurationUtils;

// Configurator to fetch or modify data from the Player.yml files.
public class PlayerConfigurator extends PlayerConfigurationUtils {
    public static String getPlayerClassString(Player player) {
        return playerConfigGetString(player, "current_class");
    }
}
