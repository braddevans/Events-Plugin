package uk.co.breadhub.events;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import uk.co.breadhub.events.entities.Event;
import uk.co.breadhub.events.entities.Statistics;
import uk.co.breadhub.events.listeners.CommandListener;
import uk.co.breadhub.events.listeners.PlayerListener;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Main extends JavaPlugin implements Listener {
    public static Main instance;
    private final File eventsFolder = new File(getDataFolder().getAbsolutePath() + File.separator + "events");
    public Map<Player, Statistics> playerStats = new HashMap<>();
    public static HashMap<String,Event> events = new HashMap<>();

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

        // setup database

        // register listeners
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);

        // register commands
        getCommand("event").setExecutor(new CommandListener());
        getCommand("events").setExecutor(new CommandListener());
        getCommand("eventadmin").setExecutor(new CommandListener());
        getCommand("eventsadmin").setExecutor(new CommandListener());

    }

    public static void loadEventConfigs() {
        List<File> fileList = getSubFilesFromFile(Main.getInstance().getEventsFolder());
        for (File file : fileList) {
            if (file == null) {
                continue;
            }
            YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
            //Some codes
            if (config.getKeys(false).isEmpty()) {
                continue;
            }
            for (String key : config.getKeys(false)) {
                ConfigurationSection objectSection = config.getConfigurationSection(key);
                Event event = createEventData(objectSection);
                event.register();
            }
        }
    }

    public static Event createEventData(ConfigurationSection section) {
        String key = section.getName();
        boolean active = section.getBoolean("active");
        List<String> runCommands = section.getStringList("runCommands");
        return new Event(events.size(), key, runCommands, active);
    }


    public static List<File> getSubFilesFromFile(File file) {
        List<File> files = new ArrayList<>();
        File[] allFiles = file.listFiles();
        if (allFiles == null) {
            return files;
        }
        for (File subFile : allFiles) {
            if (! subFile.getName().endsWith(".yml")) {
                continue;
            }
            if (subFile.isFile()) {
                files.add(subFile);
            }
            else {
                files.addAll(getSubFilesFromFile(subFile));
            }
        }
        return files;
    }

    public File getEventsFolder() {
        return eventsFolder;
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
