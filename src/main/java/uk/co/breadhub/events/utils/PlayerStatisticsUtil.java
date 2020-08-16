package uk.co.breadhub.events.utils;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import uk.co.breadhub.events.database.DatabaseImpl;
import uk.co.breadhub.events.utils.i1_15.StatisticType;

import java.util.*;

public class PlayerStatisticsUtil {
    private static final Set<PlayerStatisticsUtil> stats = new HashSet<>();
    private static final Map<UUID, PlayerStatisticsUtil> map = new HashMap<>();

    private static UUID uuid;
    private static Map<StatisticType, Long> statistics;

    public PlayerStatisticsUtil(UUID uuid) {
        PlayerStatisticsUtil.uuid = uuid;
        statistics = new HashMap<>();
        for (StatisticType type : StatisticType.values()) {
            statistics.put(type, (long) Bukkit.getPlayer(uuid).getStatistic(Statistic.valueOf(type.name())));
        }
        stats.add(this);
        map.put(uuid, this);
        // add to database
        DatabaseImpl.addPlayerStats(uuid,
                getStatistic(StatisticType.DAMAGE_DEALT),
                getStatistic(StatisticType.DAMAGE_TAKEN),
                getStatistic(StatisticType.DEATHS),
                getStatistic(StatisticType.MOB_KILLS),
                getStatistic(StatisticType.PLAYER_KILLS),
                getStatistic(StatisticType.FISH_CAUGHT),
                getStatistic(StatisticType.ANIMALS_BRED),
                getStatistic(StatisticType.LEAVE_GAME),
                getStatistic(StatisticType.JUMP),
                getStatistic(StatisticType.DROP_COUNT),
                getStatistic(StatisticType.DROP),
                getStatistic(StatisticType.PICKUP),
                getStatistic(StatisticType.PLAY_ONE_MINUTE),
                getStatistic(StatisticType.WALK_ONE_CM),
                getStatistic(StatisticType.WALK_ON_WATER_ONE_CM),
                getStatistic(StatisticType.FALL_ONE_CM),
                getStatistic(StatisticType.SNEAK_TIME),
                getStatistic(StatisticType.CLIMB_ONE_CM),
                getStatistic(StatisticType.FLY_ONE_CM),
                getStatistic(StatisticType.WALK_UNDER_WATER_ONE_CM),
                getStatistic(StatisticType.MINECART_ONE_CM),
                getStatistic(StatisticType.BOAT_ONE_CM),
                getStatistic(StatisticType.PIG_ONE_CM),
                getStatistic(StatisticType.HORSE_ONE_CM),
                getStatistic(StatisticType.SPRINT_ONE_CM),
                getStatistic(StatisticType.CROUCH_ONE_CM),
                getStatistic(StatisticType.AVIATE_ONE_CM),
                getStatistic(StatisticType.MINE_BLOCK),
                getStatistic(StatisticType.USE_ITEM),
                getStatistic(StatisticType.BREAK_ITEM),
                getStatistic(StatisticType.CRAFT_ITEM),
                getStatistic(StatisticType.KILL_ENTITY),
                getStatistic(StatisticType.ENTITY_KILLED_BY),
                getStatistic(StatisticType.TIME_SINCE_DEATH),
                getStatistic(StatisticType.TALKED_TO_VILLAGER),
                getStatistic(StatisticType.TRADED_WITH_VILLAGER),
                getStatistic(StatisticType.CAKE_SLICES_EATEN),
                getStatistic(StatisticType.CAULDRON_FILLED),
                getStatistic(StatisticType.CAULDRON_USED),
                getStatistic(StatisticType.ARMOR_CLEANED),
                getStatistic(StatisticType.BANNER_CLEANED),
                getStatistic(StatisticType.BREWINGSTAND_INTERACTION),
                getStatistic(StatisticType.BEACON_INTERACTION),
                getStatistic(StatisticType.DROPPER_INSPECTED),
                getStatistic(StatisticType.HOPPER_INSPECTED),
                getStatistic(StatisticType.DISPENSER_INSPECTED),
                getStatistic(StatisticType.NOTEBLOCK_PLAYED),
                getStatistic(StatisticType.NOTEBLOCK_TUNED),
                getStatistic(StatisticType.FLOWER_POTTED),
                getStatistic(StatisticType.TRAPPED_CHEST_TRIGGERED),
                getStatistic(StatisticType.ENDERCHEST_OPENED),
                getStatistic(StatisticType.ITEM_ENCHANTED),
                getStatistic(StatisticType.RECORD_PLAYED),
                getStatistic(StatisticType.FURNACE_INTERACTION),
                getStatistic(StatisticType.CRAFTING_TABLE_INTERACTION),
                getStatistic(StatisticType.CHEST_OPENED),
                getStatistic(StatisticType.SLEEP_IN_BED),
                getStatistic(StatisticType.SHULKER_BOX_OPENED),
                getStatistic(StatisticType.TIME_SINCE_REST),
                getStatistic(StatisticType.SWIM_ONE_CM),
                getStatistic(StatisticType.DAMAGE_DEALT_ABSORBED),
                getStatistic(StatisticType.DAMAGE_DEALT_RESISTED),
                getStatistic(StatisticType.DAMAGE_BLOCKED_BY_SHIELD),
                getStatistic(StatisticType.DAMAGE_ABSORBED),
                getStatistic(StatisticType.DAMAGE_RESISTED),
                getStatistic(StatisticType.CLEAN_SHULKER_BOX),
                getStatistic(StatisticType.OPEN_BARREL),
                getStatistic(StatisticType.INTERACT_WITH_BLAST_FURNACE),
                getStatistic(StatisticType.INTERACT_WITH_SMOKER),
                getStatistic(StatisticType.INTERACT_WITH_LECTERN),
                getStatistic(StatisticType.INTERACT_WITH_CAMPFIRE),
                getStatistic(StatisticType.INTERACT_WITH_CARTOGRAPHY_TABLE),
                getStatistic(StatisticType.INTERACT_WITH_LOOM),
                getStatistic(StatisticType.INTERACT_WITH_STONECUTTER),
                getStatistic(StatisticType.BELL_RING),
                getStatistic(StatisticType.RAID_TRIGGER),
                getStatistic(StatisticType.RAID_WIN),
                getStatistic(StatisticType.INTERACT_WITH_ANVIL),
                getStatistic(StatisticType.INTERACT_WITH_GRINDSTONE)
        );
    }

    public static PlayerStatisticsUtil getStats(Player p) {
        if (map.containsKey(p.getUniqueId())) return map.get(p.getUniqueId());
        else return new PlayerStatisticsUtil(p.getUniqueId());
    }

    public void setStatistic(StatisticType stat, long value) {
        statistics.put(stat, value);
    }

    public void addToStatistic(StatisticType stat, long addition) {
        setStatistic(stat, getStatistic(stat) + addition);
    }


    public static void unregister(Player p) {
        if (map.containsKey(p.getUniqueId())) {
            PlayerStatisticsUtil ps = map.get(p.getUniqueId());

            stats.remove(ps);
            map.remove(p.getUniqueId());
        }
    }

    public long getStatistic(StatisticType stat) {
        switch (stat) {
            default: {
                if (statistics.containsKey(stat)) return statistics.get(stat);
                else return 0;
            }
        }
    }
}
