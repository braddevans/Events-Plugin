package uk.co.breadhub.events.utils;

import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import uk.co.breadhub.events.Main;
import uk.co.breadhub.events.entities.Event;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EventsUtil {

    public static boolean createEvent(String name, boolean StartNow, boolean canExpire, long expireTime) {
        boolean created = false;
        if (! getEventNames().contains(name)) {
            if (Main.events.size() == 0) {
                Main.events.putIfAbsent(name, new Event(0, name, System.currentTimeMillis(), canExpire, expireTime, new ArrayList<>(), StartNow));
            }
            else {
                Main.events.putIfAbsent(name, new Event(Main.events.size(), name, System.currentTimeMillis(), canExpire, expireTime, new ArrayList<>(), StartNow));
            }
            created = true;
        }
        else {
            System.out.println(ChatColor.RED + "Cannot Create A Event That already Exists in memory!");
        }
        return created;
    }

    public static boolean startEventByName(String eventname) {
        boolean eventStarted = false;
        if (getEventNames().contains(eventname)) {
            for (Event event : EventsUtil.getEvents().values()) {
                if (event.getName().equalsIgnoreCase(eventname)) {
                    event.setActive(true);
                    eventStarted = true;
                }
            }
        }
        else {
            System.out.println("Could Not Start Event By Name: " + eventname);
        }
        return eventStarted;
    }

    public static void toggleEventByName(String eventname) {

    }

    public static HashMap<String, Event> getEvents() {
        return Main.events;
    }

    public static List<String> getEventNames() {
        List<String> events = new ArrayList<>();
        for (Event event : EventsUtil.getEvents().values()) {
            events.add(event.getName());
        }
        return events;
    }

    public static List<String> getActiveEvents() {
        List<String> active = new ArrayList<>();
        for (Event event : EventsUtil.getEvents().values()) {
            if (event.isActive() && ! active.contains(event.getName())) {
                active.add(event.getName());
            }
        }
        return active;
    }

    public static void loadEventConfigs() {
        List<File> fileList = MiscUtils.getSubFilesFromFile(Main.getInstance().getEventsFolder());
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
        String discription = section.getString("discription");
        boolean active = section.getBoolean("active");
        List<String> runCommands = section.getStringList("runCommands");
        return new Event(Main.events.size(), key, discription, runCommands, active, section);
    }
}
