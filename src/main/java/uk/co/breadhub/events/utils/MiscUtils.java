package uk.co.breadhub.events.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import uk.co.breadhub.events.Main;

public class MiscUtils {
    public static String toColorText(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static void createOnlinePlayersScoreboard(Player player) {
        scoreboardUtil scoreboard = new scoreboardUtil("onlinePlayers");
        scoreboard.setTitle("--==Online Players==--");
        //scoreboard.add("line1", "a", 1);
        scoreboard.add("spacer1","", 0);
        for (int i = 0; i < Bukkit.getOnlinePlayers().size(); i++) {
            for (Player _player : Bukkit.getOnlinePlayers()){
                scoreboard.add("player" + i, player.getName(), 0);
            }
        }
        scoreboard.add("spacer2","", 0);
        scoreboard.add("spacer3","", 0);
        scoreboard.add("spacer4","", 0);
        scoreboard.add("spacer5","", 0);
        scoreboard.add("spacer6","", 0);
        scoreboard.add("spacer7","", 0);
        scoreboard.add("spacer8","", 0);
        scoreboard.add("spacer9","", 0);
        scoreboard.add("spacer10","", 0);
        scoreboard.add("spacer11","", 0);
        scoreboard.add("spacer12","", 0);
        scoreboard.add("spacer13","", 0);
        scoreboard.add("spacer14","", 0);
        scoreboard.add("spacer15","", 0);
        scoreboard.add("spacer16","", 0);
        scoreboard.add("spacer17","", 0);
        scoreboard.add(player);
        Main.getInstance().boards.put(player, scoreboard);
    }

    public static void createScoreboardForPlayer(Player player) {
        scoreboardUtil scoreboard = new scoreboardUtil("TestScore");
        scoreboard.setTitle("Scoreboard");
        scoreboard.add("line1", "a", 1);
        scoreboard.add(player);
        Main.getInstance().boards.put(player, scoreboard);
    }
}
