package uk.co.breadhub.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import uk.co.breadhub.events.entities.Event;
import uk.co.breadhub.events.entities.Statistics;
import uk.co.breadhub.events.listeners.CommandListener;
import uk.co.breadhub.events.listeners.PlayerListener;
import uk.co.breadhub.events.utils.EventsUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class Main extends JavaPlugin implements Listener {
    public static Main instance;
    public static HashMap<String, Event> events = new HashMap<>();
    private final File eventsFolder = new File(getDataFolder().getAbsolutePath() + File.separator + "events");
    public Map<Player, Statistics> playerStats = new HashMap<>();

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        // setup config
        if (! instance.getDataFolder().exists()) {
            try {
                instance.getDataFolder().mkdir();
                saveDefaultConfig();
            }
            catch (Exception ignored) {
            }
        }

        if (! eventsFolder.exists()) {
            eventsFolder.mkdirs();
        }

        EventsUtil.loadEventConfigs();

        // register listeners
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);

        // register commands
        getCommand("event").setExecutor(new CommandListener());
        getCommand("events").setExecutor(new CommandListener());
        getCommand("eventadmin").setExecutor(new CommandListener());
        getCommand("eventsadmin").setExecutor(new CommandListener());

    }

    public File getEventsFolder() {
        return eventsFolder;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
