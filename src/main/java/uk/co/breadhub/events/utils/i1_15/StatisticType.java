package uk.co.breadhub.events.utils.i1_15;

// enum for 1.15 statistics
public enum StatisticType {
    DAMAGE_DEALT(0),
    DAMAGE_TAKEN(0),
    DEATHS(0),
    MOB_KILLS(0),
    PLAYER_KILLS(0),
    FISH_CAUGHT(0),
    ANIMALS_BRED(0),
    LEAVE_GAME(0),
    JUMP(0),
    DROP_COUNT(0),
    PLAY_ONE_MINUTE(0),
    WALK_ONE_CM(0),
    WALK_ON_WATER_ONE_CM(0),
    FALL_ONE_CM(0),
    SNEAK_TIME(0),
    CLIMB_ONE_CM(0),
    FLY_ONE_CM(0),
    WALK_UNDER_WATER_ONE_CM(0),
    MINECART_ONE_CM(0),
    BOAT_ONE_CM(0),
    PIG_ONE_CM(0),
    HORSE_ONE_CM(0),
    SPRINT_ONE_CM(0),
    CROUCH_ONE_CM(0),
    AVIATE_ONE_CM(0),
    TIME_SINCE_DEATH(0),
    TALKED_TO_VILLAGER(0),
    TRADED_WITH_VILLAGER(0),
    CAKE_SLICES_EATEN(0),
    CAULDRON_FILLED(0),
    CAULDRON_USED(0),
    ARMOR_CLEANED(0),
    BANNER_CLEANED(0),
    BREWINGSTAND_INTERACTION(0),
    BEACON_INTERACTION(0),
    DROPPER_INSPECTED(0),
    HOPPER_INSPECTED(0),
    DISPENSER_INSPECTED(0),
    NOTEBLOCK_PLAYED(0),
    NOTEBLOCK_TUNED(0),
    FLOWER_POTTED(0),
    TRAPPED_CHEST_TRIGGERED(0),
    ENDERCHEST_OPENED(0),
    ITEM_ENCHANTED(0),
    RECORD_PLAYED(0),
    FURNACE_INTERACTION(0),
    CRAFTING_TABLE_INTERACTION(0),
    CHEST_OPENED(0),
    SLEEP_IN_BED(0),
    SHULKER_BOX_OPENED(0),
    TIME_SINCE_REST(0),
    SWIM_ONE_CM(0),
    DAMAGE_DEALT_ABSORBED(0),
    DAMAGE_DEALT_RESISTED(0),
    DAMAGE_BLOCKED_BY_SHIELD(0),
    DAMAGE_ABSORBED(0),
    DAMAGE_RESISTED(0),
    CLEAN_SHULKER_BOX(0),
    OPEN_BARREL(0),
    INTERACT_WITH_BLAST_FURNACE(0),
    INTERACT_WITH_SMOKER(0),
    INTERACT_WITH_LECTERN(0),
    INTERACT_WITH_CAMPFIRE(0),
    INTERACT_WITH_CARTOGRAPHY_TABLE(0),
    INTERACT_WITH_LOOM(0),
    INTERACT_WITH_STONECUTTER(0),
    BELL_RING(0),
    RAID_TRIGGER(0),
    RAID_WIN(0),
    INTERACT_WITH_ANVIL(0),
    INTERACT_WITH_GRINDSTONE(0);

    public int statvalue;

    StatisticType(int statvalue){
        this.statvalue = statvalue;
    }

    public static int getByKeyName(String namekey) {
        int stat = 0;
        for (StatisticType value : values()) {
            if (value.name().toLowerCase().equals(namekey.toLowerCase())) {
                stat = value.statvalue;
            }
        }
        return stat;
    }
}
