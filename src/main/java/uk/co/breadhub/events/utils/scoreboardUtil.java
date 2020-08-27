package uk.co.breadhub.events.utils;

import com.google.common.base.Splitter;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class scoreboardUtil {

    private Scoreboard scoreboard;
    private Objective objective;
    private BiMap<String, ScoreboardutilEntry> entries;

    private int teamId;

    public scoreboardUtil(String title) {
        this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        this.objective = scoreboard.registerNewObjective("spigobjective", "dummy");
        this.objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        setTitle(title);

        this.entries = HashBiMap.create();
        this.teamId = 1;
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    public Objective getObjective() {
        return objective;
    }

    public void setTitle(String title) {
        objective.setDisplayName(title);
    }

    public BiMap<String, ScoreboardutilEntry> getEntries() {
        return HashBiMap.create(entries);
    }

    public ScoreboardutilEntry getEntry(String key) {
        return entries.get(key);
    }

    public ScoreboardutilEntry add(String name, int value) {
        return add((String) null, name, value, true);
    }

    public ScoreboardutilEntry add(Enum key, String name, int value) {
        return add(key.name(), name, value);
    }

    public ScoreboardutilEntry add(String key, String name, int value) {
        return add(key, name, value, false);
    }

    public ScoreboardutilEntry add(Enum key, String name, int value, boolean overwrite) {
        return add(key.name(), name, value, overwrite);
    }

    public ScoreboardutilEntry add(String key, String name, int value, boolean overwrite) {
        if (key == null && !contains(name)) {
            throw new IllegalArgumentException("Entry could not be found with the supplied name and no key was supplied");
        }

        if (overwrite && contains(name)) {
            ScoreboardutilEntry entry = getEntryByName(name);
            if (key != null && entries.get(key) != entry) {
                throw new IllegalArgumentException("Supplied key references a different score than the one to be overwritten");
            }

            entry.setValue(value);
            return entry;
        }

        if (entries.get(key) != null) {
            throw new IllegalArgumentException("Score already exists with that key");
        }

        int count = 0;
        String origName = name;
        if (!overwrite) {
            Map<Integer, String> created = create(name);
            for (Entry<Integer, String> entry : created.entrySet()) {
                count = entry.getKey();
                name = entry.getValue();
            }
        }

        ScoreboardutilEntry entry = new ScoreboardutilEntry(key, this, value, origName, count);
        entry.update(name);
        entries.put(key, entry);
        return entry;
    }

    public void remove(String key) {
        remove(getEntry(key));
    }

    public void remove(ScoreboardutilEntry entry) {
        if (entry.getScoreboardutil() != this) {
            throw new IllegalArgumentException("Supplied entry does not belong to this Scoreboardutil");
        }

        String key = entries.inverse().get(entry);
        if (key != null) {
            entries.remove(key);
        }

        entry.remove();
    }

    private Map<Integer, String> create(String name) {
        // Bukkit.getLogger().info("Name: '" + name + "' (" + name.length() + ") contains? " + contains(name));
        int count = 0;
        while (contains(name)) {
            name = ChatColor.RESET + name;
            count++;
            // Bukkit.getLogger().info("Name: '" + name + "' (" + name.length() + ") contains? " + contains(name) + " (" + ++count + ")");
        }

        if (name.length() > 48) {
            name = name.substring(0, 47);
            // Bukkit.getLogger().info("Name: '" + name + "' (" + name.length() + ") contains? " + contains(name) + " (trim)");
        }

        if (contains(name)) {
            throw new IllegalArgumentException("Could not find a suitable replacement name for '" + name + "'");
        }

        Map<Integer, String> created = new HashMap<>();
        created.put(count, name);
        return created;
    }

    public int getTeamId() {
        return teamId++;
    }

    public ScoreboardutilEntry getEntryByName(String name) {
        for (ScoreboardutilEntry entry : entries.values()) {
            if (entry.getName().equals(name)) {
                return entry;
            }
        }

        return null;
    }

    public boolean contains(String name) {
        for (ScoreboardutilEntry entry : entries.values()) {
            if (entry.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    public void add(Player player) {
        player.setScoreboard(scoreboard);
    }

    public class ScoreboardutilEntry {

        private String key;
        private scoreboardUtil Scoreboardutil;
        private String name;
        private Team team;
        private Score score;
        private int value;

        private String origName;
        private int count;

        public ScoreboardutilEntry(String key, scoreboardUtil Scoreboardutil, int value) {
            this.key = key;
            this.Scoreboardutil = Scoreboardutil;
            this.value = value;
            this.count = 0;
        }

        public ScoreboardutilEntry(String key, scoreboardUtil Scoreboardutil, int value, String origName, int count) {
            this.key = key;
            this.Scoreboardutil = Scoreboardutil;
            this.value = value;
            this.origName = origName;
            this.count = count;
        }

        public String getKey() {
            return key;
        }

        public scoreboardUtil getScoreboardutil() {
            return Scoreboardutil;
        }

        public String getName() {
            return name;
        }

        public Team getTeam() {
            return team;
        }

        public Score getScore() {
            return score;
        }

        public int getValue() {
            return score != null ? (value = score.getScore()) : value;
        }

        public void setValue(int value) {
            if (!score.isScoreSet()) {
                score.setScore(-1);
            }

            score.setScore(value);
        }

        public void update(String newName) {
            int value = getValue();
            if (origName != null && newName.equals(origName)) {
                // String oldName = newName;
                for (int i = 0; i < count; i++) {
                    newName = ChatColor.RESET + newName;
                }

                // Bukkit.getLogger().info("Changed '" + oldName + "' (" + oldName.length() + ") into '" + newName + "' (" + newName.length() + ")");
            } else if (newName.equals(name)) {
                // Bukkit.getLogger().info("Not updating '" + newName + "' because it matches previous name");
                return;
            }

            create(newName);
            setValue(value);
        }

        void remove() {
            if (score != null) {
                score.getScoreboard().resetScores(score.getEntry());
            }

            if (team != null) {
                team.unregister();
            }
        }

        private void create(String name) {
            this.name = name;
            remove();

            if (name.length() <= 16) {
                int value = getValue();
                score = Scoreboardutil.getObjective().getScore(name);
                score.setScore(value);
                return;
            }

            // Credit to RainoBoy97 for this section here.
            team = Scoreboardutil.getScoreboard().registerNewTeam("Scoreboardutil-" + Scoreboardutil.getTeamId());
            Iterator<String> iterator = Splitter.fixedLength(16).split(name).iterator();
            team.setPrefix(iterator.next());
            String entry = iterator.next();
            score = Scoreboardutil.getObjective().getScore(entry);
            if (name.length() > 32)
                team.setSuffix(iterator.next());

            team.addEntry(entry);
        }

    }

}