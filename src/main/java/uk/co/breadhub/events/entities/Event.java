package uk.co.breadhub.events.entities;

import org.bukkit.configuration.ConfigurationSection;
import uk.co.breadhub.events.Main;

import java.util.ArrayList;
import java.util.List;

public class Event {

    private static ConfigurationSection config;
    public static long starttime;
    public static int id;
    public static String name;
    public static String description;
    public static boolean canExpire;
    public static long expireTime;
    public static boolean active;
    private static List<String> commandsOnCompletion = new ArrayList<>();

    public Event(int ID, String Name, long startTime, boolean canExpire, long expireTime, List<String> commands, boolean active) {
        Event.id = ID;
        Event.name = Name;
        Event.starttime = startTime;
        Event.canExpire = canExpire;
        Event.expireTime = expireTime;
        Event.commandsOnCompletion = commands;
        Event.active = active;
    }

    public Event(int ID, String Name, boolean active, ConfigurationSection section) {
        Event.id = ID;
        Event.name = Name;
        Event.starttime = 0;
        Event.canExpire = false;
        Event.expireTime = 0;
        Event.active = active;
        Event.config = section;
    }

    public Event(int ID, String Name, String discription, List<String> runCommands, boolean active, ConfigurationSection section) {
        Event.id = ID;
        Event.name = Name;
        Event.description = discription;
        Event.starttime = 0;
        Event.canExpire = false;
        Event.commandsOnCompletion = runCommands;
        Event.expireTime = 0;
        Event.active = active;
        Event.config = section;
    }

    public static List<String> getCommandsOnCompletion() {
        return commandsOnCompletion;
    }

    public static void setCommandsOnCompletion(List<String> commandsOnCompletion) {
        Event.commandsOnCompletion = commandsOnCompletion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        Event.id = id;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        Event.expireTime = expireTime;
    }

    public long getStarttime() {
        return starttime;
    }

    public void setStarttime(long starttime) {
        Event.starttime = starttime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Event.name = name;
    }

    public boolean isCanExpire() {
        return canExpire;
    }

    public void setCanExpire(boolean canExpire) {
        Event.canExpire = canExpire;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        Event.active = active;
    }

    public static String getDescription() {
        return description;
    }

    public static void setDescription(String description) {
        Event.description = description;
    }

    public void register() {
        Main.events.putIfAbsent(getName(), this);
    }
}
