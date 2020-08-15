package uk.co.breadhub.events.utils;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;
import uk.co.breadhub.events.Main;
import uk.co.breadhub.events.utils.i1_15.StatisticType;

import java.io.File;
import java.util.*;

public class PlayerStatisticsUtil {
    private static Player player;
    private static Statistic statistic;


    public PlayerStatisticsUtil(Player player) {

    }

    private static Set<PlayerStatisticsUtil> stats = new HashSet<PlayerStatisticsUtil>();
    private static Map<UUID, PlayerStatisticsUtil> map = new HashMap<UUID, PlayerStatisticsUtil>();

    private static UUID uuid;
    private static Map<StatisticType, Long> statistics;

    public PlayerStatisticsUtil(UUID uuid) {
        PlayerStatisticsUtil.uuid = uuid;
        statistics = new HashMap<StatisticType, Long>();
        for (StatisticType type: StatisticType.values()){
            statistics.put(type, (long) Bukkit.getPlayer(player.getUniqueId()).getStatistic(Statistic.valueOf(type.name())));
        }
        stats.add(this);
        map.put(uuid, this);
    }

    public static PlayerStatisticsUtil getStats(Player p) {
        if (map.containsKey(p.getUniqueId())) return map.get(p.getUniqueId());
        else return new PlayerStatisticsUtil(p.getUniqueId());
    }

    public void setStatistic(StatisticType stat, long value) {
        statistics.put(stat, value);
    }

    public void addStatistic(StatisticType stat, long addition) {
        setStatistic(stat, getStatistic(stat, Bukkit.getPlayer(uuid)) + addition);
    }


    public static void unregister(Player p) {
        if (map.containsKey(p.getUniqueId())) {
            PlayerStatisticsUtil ps = map.get(p.getUniqueId());

            stats.remove(ps);
            map.remove(p.getUniqueId());
        }
    }

    public long getStatistic(StatisticType stat, Player player) {
        switch (stat) {
            case PLAY_ONE_MINUTE: {
                return Long.parseLong(String.valueOf(Bukkit.getPlayer(player.getUniqueId()).getStatistic(Statistic.valueOf("PLAY_ONE_MINUTE")) * 1000L));
            }
            default: {
                if (statistics.containsKey(stat)) return statistics.get(stat);
                else return 0;
            }
        }
    }

    public static Player getPlayer() {
        return player;
    }
}
