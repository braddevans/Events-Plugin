package uk.co.breadhub.testplugin.entities;


public class Event {

    public static long starttime;
    public static int id;
    public static String name;
    public static boolean canExpire;
    public static long expireTime;
    public static boolean active;


    public Event() {
    }

    public Event(int ID, String Name, long startTime, boolean canExpire, long expireTime, boolean active) {
        Event.id = ID;
        Event.name = Name;
        Event.starttime = startTime;
        Event.canExpire = canExpire;
        Event.expireTime = expireTime;
        Event.active = active;
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
}
