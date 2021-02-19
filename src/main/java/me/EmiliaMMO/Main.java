package me.EmiliaMMO;

import java.util.logging.Level;

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.EmiliaMMO.system.annotations.AnnotationLoader;
import me.EmiliaMMO.system.listeners.PlayerListeners;

public class Main extends JavaPlugin {
    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        PluginManager manager = getServer().getPluginManager();

        AnnotationLoader.init();
        getLogger().log(Level.INFO, "Finished Loading Data from Predefined Classes!");

        manager.registerEvents((Listener) new PlayerListeners(), (Plugin) this);
        getLogger().log(Level.INFO, "Registered EventListeners!");
    }

    @Override
    public void onDisable() {
    }

    public static Main getInstance() {
        return instance;
    }

}