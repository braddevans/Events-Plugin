package uk.co.breadhub.events;

import org.bukkit.plugin.java.JavaPlugin;
import uk.co.breadhub.events.listeners.CommandListener;

public final class Main extends JavaPlugin {
    public static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        // setup config
        if (!instance.getDataFolder().exists()) {
            try {
                instance.getDataFolder().mkdir();
                saveDefaultConfig();
            } catch (Exception ignored) {
            }
        }

        // setup database

        // register listeners

        // register commands
        getCommand("events").setExecutor(new CommandListener());
        getCommand("eventsadmin").setExecutor(new CommandListener());
        getCommand("eventadmin").setExecutor(new CommandListener());
        getCommand("event").setExecutor(new CommandListener());


        // pick a random event id from a list every x hours set in config
        // and disable event created by this when those hours are up
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
