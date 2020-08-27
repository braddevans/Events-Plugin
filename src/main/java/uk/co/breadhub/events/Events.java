package uk.co.breadhub.events;

import org.bukkit.ChatColor;
import uk.co.breadhub.events.entities.Event;

import java.util.ArrayList;
import java.util.List;

public class Events {
    private static final ArrayList<Event> events = new ArrayList<>();

    public static boolean createEvent(String name, boolean StartNow, boolean canExpire, long expireTime) {
        boolean created = false;
        if (!getEventNames().contains(name)) {
            if (events.size() == 0) {
                events.add(new Event(1, name, System.currentTimeMillis(), canExpire, expireTime, StartNow));
            } else {
                events.add(new Event(events.size(), name, System.currentTimeMillis(), canExpire, expireTime, StartNow));
            }
            created = true;
        } else {
            System.out.println(ChatColor.RED + "Cannot Create A Event That already Exists in memory!");
        }
        return created;
    }

    public static boolean startEventByName(String eventname) {
        boolean eventStarted = false;
        if (getEventNames().contains(eventname)){
            for(Event event : getEvents()){
                if (event.getName().toLowerCase().equals(eventname.toLowerCase())){
                    event.setActive(true);
                    eventStarted = true;
                }
            }
        } else {
            System.out.println("Could Not Start Event By Name: " + eventname);
        }
        return eventStarted;
    }

    public static void toggleEventByName(String eventname) {

    }

    public static ArrayList<Event> getEvents() {
        return events;
    }

    public static List<String> getEventNames() {
        List<String> events = new ArrayList<>();
        for (Event event : Events.getEvents()) {
            events.add(event.getName());
        }
        return events;
    }

    public static List<String> getActiveEvents() {
        List<String> active = new ArrayList<>();
        for (Event event : Events.getEvents()) {
            if (event.isActive() && !active.contains(event.getName())) {
                active.add(event.getName());
            }
        }
        return active;
    }
}
