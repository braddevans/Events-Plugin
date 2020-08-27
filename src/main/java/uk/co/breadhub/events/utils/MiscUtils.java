package uk.co.breadhub.events.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import uk.co.breadhub.events.Main;
import uk.co.breadhub.events.entities.Event;

public class MiscUtils {
    public static String toColorText(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static void createScoreboardForPlayer(Player player, Event event) {
        scoreboardUtil scoreboard = new scoreboardUtil("TestScore");
        scoreboard.setTitle("Scoreboard");
        scoreboard.add("line1", "a", 1);
        scoreboard.add(player);
        Main.getInstance().boards.put(player, scoreboard);
    }
}
