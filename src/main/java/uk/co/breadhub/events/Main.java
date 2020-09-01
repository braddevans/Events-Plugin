package uk.co.breadhub.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import uk.co.breadhub.events.entities.Event;
import uk.co.breadhub.events.entities.Statistics;
import uk.co.breadhub.events.listeners.CommandListener;
import uk.co.breadhub.events.listeners.PlayerListener;
import uk.co.breadhub.events.utils.scoreboardUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Main extends JavaPlugin implements Listener {
    public static Main instance;
    public Map<Player, scoreboardUtil> boards = new HashMap<>();
    public Map<Event, Boolean> events = new HashMap<>();
    public Map<Event, Boolean> scoreboardEvents = new HashMap<>();

    // todo: clear on player leave / sever shutdown
    public Map<Player, Statistics> playerStats = new HashMap<>();
    public List<String> eventlist = new ArrayList<>();


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
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);

        // register commands
        getCommand("event").setExecutor(new CommandListener());
        getCommand("events").setExecutor(new CommandListener());
        getCommand("eventadmin").setExecutor(new CommandListener());
        getCommand("eventsadmin").setExecutor(new CommandListener());

        //iterate through events in config.yml
        eventlist = getConfig().getStringList("Events.all");
        for (String event : eventlist) {
            boolean isEnabled = getConfig().getBoolean("Events." + event + ".Enabled");
            events.put(new Event(events.size() + 1, event, isEnabled), isEnabled);
            if (getConfig().getString("Events." + event + ".uses").toLowerCase().equals("scoreboard") && getConfig().getString("Events." + event + ".uses") != null) {
                scoreboardEvents.put(new Event(events.size() + 1, event, isEnabled), isEnabled);
                // add current online players to scoreboard
                // MiscUtils.createScoreboardForPlayer();
            }
        }

        // pick a random event id from a list every x hours set in config
        // and disable event created by this when those hours are up
        // randomEventPicker();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
