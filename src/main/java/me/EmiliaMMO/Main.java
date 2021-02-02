package me.EmiliaMMO;

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import me.EmiliaMMO.listeners.PlayerListeners;

public class Main extends JavaPlugin {
    public static final int MAX_PLAYER_LEVEL = 60;

    @Override
    public void onEnable() {
        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents((Listener) new PlayerListeners(), (Plugin) this);
    }

    @Override
    public void onDisable() {
    }

}