package uk.co.breadhub.testplugin.utils;

import org.bukkit.Statistic;
import org.bukkit.entity.Player;

public class PlayerStatisticsUtil {
    private static Player player;
    private static Statistic statistic;


    public PlayerStatisticsUtil(Player player) {

    }

    public static Statistic getStatistic() {
        return statistic;
    }

    public static Player getPlayer() {
        return player;
    }
}
