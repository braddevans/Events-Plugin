package uk.co.breadhub.events.entities;

import org.bukkit.Statistic;
import org.bukkit.entity.Player;

import java.util.Objects;

public class Statistics {

    //=====================================================//
    // todo: depends on external materials or entities     //
    //=====================================================//
    //public long drop = 0;
    //public long pickup = 0;
    //public long mine_block = 0;
    //public long use_item = 0;
    //public long break_item = 0;
    //public long craft_item = 0;
    //public long kill_entity = 0;
    //public long entity_killed_by = 0;

    public static Statistics instance;
    public long damage_dealt = 0;
    public long damage_taken = 0;
    public long deaths = 0;
    public long mob_kills = 0;
    public long player_kills = 0;
    public long fish_caught = 0;
    public long animals_bred = 0;
    public long leave_game = 0;
    public long jump = 0;
    public long drop_count = 0;
    public long play_one_minute = 0;
    public long walk_one_cm = 0;
    public long walk_on_water_one_cm = 0;
    public long fall_one_cm = 0;
    public long sneak_time = 0;
    public long climb_one_cm = 0;
    public long fly_one_cm = 0;
    public long walk_under_water_one_cm = 0;
    public long minecart_one_cm = 0;
    public long boat_one_cm = 0;
    public long pig_one_cm = 0;
    public long horse_one_cm = 0;
    public long sprint_one_cm = 0;
    public long crouch_one_cm = 0;
    public long aviate_one_cm = 0;
    public long time_since_death = 0;
    public long talked_to_villager = 0;
    public long traded_with_villager = 0;
    public long cake_slices_eaten = 0;
    public long cauldron_filled = 0;
    public long cauldron_used = 0;
    public long armor_cleaned = 0;
    public long banner_cleaned = 0;
    public long brewingstand_interaction = 0;
    public long beacon_interaction = 0;
    public long dropper_inspected = 0;
    public long hopper_inspected = 0;
    public long dispenser_inspected = 0;
    public long noteblock_played = 0;
    public long noteblock_tuned = 0;
    public long flower_potted = 0;
    public long trapped_chest_triggered = 0;
    public long enderchest_opened = 0;
    public long item_enchanted = 0;
    public long record_played = 0;
    public long furnace_interaction = 0;
    public long crafting_table_interaction = 0;
    public long chest_opened = 0;
    public long sleep_in_bed = 0;
    public long shulker_box_opened = 0;
    public long time_since_rest = 0;
    public long swim_one_cm = 0;
    public long damage_dealt_absorbed = 0;
    public long damage_dealt_resisted = 0;
    public long damage_blocked_by_shield = 0;
    public long damage_absorbed = 0;
    public long damage_resisted = 0;
    public long clean_shulker_box = 0;
    public long open_barrel = 0;
    public long interact_with_blast_furnace = 0;
    public long interact_with_smoker = 0;
    public long interact_with_lectern = 0;
    public long interact_with_campfire = 0;
    public long interact_with_cartography_table = 0;
    public long interact_with_loom = 0;
    public long interact_with_stonecutter = 0;
    public long bell_ring = 0;
    public long raid_trigger = 0;
    public long raid_win = 0;
    public long interact_with_anvil = 0;
    public long interact_with_grindstone = 0;

    public Statistics() {
    }

    public Statistics(Player player) {
        instance = this;
        //=====================================================//
        // todo: depends on external materials or entities     //
        //=====================================================//
        //drop = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("DROP"))));
        //pickup = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("PICKUP"))));
        //mine_block = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("MINE_BLOCK"))));
        //use_item = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("USE_ITEM"))));
        //break_item = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("BREAK_ITEM"))));
        //craft_item = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("CRAFT_ITEM"))));
        //kill_entity = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("KILL_ENTITY"))));
        //entity_killed_by = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("ENTITY_KILLED_BY"))));

        damage_dealt = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("DAMAGE_DEALT"))));
        damage_taken = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("DAMAGE_TAKEN"))));
        deaths = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("DEATHS"))));
        mob_kills = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("MOB_KILLS"))));
        player_kills = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("PLAYER_KILLS"))));
        fish_caught = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("FISH_CAUGHT"))));
        animals_bred = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("ANIMALS_BRED"))));
        leave_game = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("LEAVE_GAME"))));
        jump = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("JUMP"))));
        drop_count = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("DROP_COUNT"))));
        play_one_minute = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("PLAY_ONE_MINUTE"))));
        walk_one_cm = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("WALK_ONE_CM"))));
        walk_on_water_one_cm = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("WALK_ON_WATER_ONE_CM"))));
        fall_one_cm = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("FALL_ONE_CM"))));
        sneak_time = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("SNEAK_TIME"))));
        climb_one_cm = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("CLIMB_ONE_CM"))));
        fly_one_cm = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("FLY_ONE_CM"))));
        walk_under_water_one_cm = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("WALK_UNDER_WATER_ONE_CM"))));
        minecart_one_cm = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("MINECART_ONE_CM"))));
        boat_one_cm = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("BOAT_ONE_CM"))));
        pig_one_cm = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("PIG_ONE_CM"))));
        horse_one_cm = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("HORSE_ONE_CM"))));
        sprint_one_cm = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("SPRINT_ONE_CM"))));
        crouch_one_cm = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("CROUCH_ONE_CM"))));
        aviate_one_cm = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("AVIATE_ONE_CM"))));
        time_since_death = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("TIME_SINCE_DEATH"))));
        talked_to_villager = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("TALKED_TO_VILLAGER"))));
        traded_with_villager = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("TRADED_WITH_VILLAGER"))));
        cake_slices_eaten = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("CAKE_SLICES_EATEN"))));
        cauldron_filled = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("CAULDRON_FILLED"))));
        cauldron_used = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("CAULDRON_USED"))));
        armor_cleaned = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("ARMOR_CLEANED"))));
        banner_cleaned = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("BANNER_CLEANED"))));
        brewingstand_interaction = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("BREWINGSTAND_INTERACTION"))));
        beacon_interaction = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("BEACON_INTERACTION"))));
        dropper_inspected = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("DROPPER_INSPECTED"))));
        hopper_inspected = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("HOPPER_INSPECTED"))));
        dispenser_inspected = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("DISPENSER_INSPECTED"))));
        noteblock_played = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("NOTEBLOCK_PLAYED"))));
        noteblock_tuned = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("NOTEBLOCK_TUNED"))));
        flower_potted = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("FLOWER_POTTED"))));
        trapped_chest_triggered = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("TRAPPED_CHEST_TRIGGERED"))));
        enderchest_opened = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("ENDERCHEST_OPENED"))));
        item_enchanted = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("ITEM_ENCHANTED"))));
        record_played = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("RECORD_PLAYED"))));
        furnace_interaction = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("FURNACE_INTERACTION"))));
        crafting_table_interaction = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("CRAFTING_TABLE_INTERACTION"))));
        chest_opened = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("CHEST_OPENED"))));
        sleep_in_bed = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("SLEEP_IN_BED"))));
        shulker_box_opened = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("SHULKER_BOX_OPENED"))));
        time_since_rest = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("TIME_SINCE_REST"))));
        swim_one_cm = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("SWIM_ONE_CM"))));
        damage_dealt_absorbed = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("DAMAGE_DEALT_ABSORBED"))));
        damage_dealt_resisted = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("DAMAGE_DEALT_RESISTED"))));
        damage_blocked_by_shield = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("DAMAGE_BLOCKED_BY_SHIELD"))));
        damage_absorbed = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("DAMAGE_ABSORBED"))));
        damage_resisted = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("DAMAGE_RESISTED"))));
        clean_shulker_box = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("CLEAN_SHULKER_BOX"))));
        open_barrel = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("OPEN_BARREL"))));
        interact_with_blast_furnace = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("INTERACT_WITH_BLAST_FURNACE"))));
        interact_with_smoker = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("INTERACT_WITH_SMOKER"))));
        interact_with_lectern = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("INTERACT_WITH_LECTERN"))));
        interact_with_campfire = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("INTERACT_WITH_CAMPFIRE"))));
        interact_with_cartography_table = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("INTERACT_WITH_CARTOGRAPHY_TABLE"))));
        interact_with_loom = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("INTERACT_WITH_LOOM"))));
        interact_with_stonecutter = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("INTERACT_WITH_STONECUTTER"))));
        bell_ring = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("BELL_RING"))));
        raid_trigger = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("RAID_TRIGGER"))));
        raid_win = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("RAID_WIN"))));
        interact_with_anvil = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("INTERACT_WITH_ANVIL"))));
        interact_with_grindstone = Long.parseLong(String.valueOf(player.getStatistic(Statistic.valueOf("INTERACT_WITH_GRINDSTONE"))));
    }

    public long getDamage_dealt() {
        return damage_dealt;
    }

    public void setDamage_dealt(long damage_dealt) {
        this.damage_dealt = damage_dealt;
    }

    public long getDamage_taken() {
        return damage_taken;
    }

    public void setDamage_taken(long damage_taken) {
        this.damage_taken = damage_taken;
    }

    public long getDeaths() {
        return deaths;
    }

    public void setDeaths(long deaths) {
        this.deaths = deaths;
    }

    public long getMob_kills() {
        return mob_kills;
    }

    public void setMob_kills(long mob_kills) {
        this.mob_kills = mob_kills;
    }

    public long getPlayer_kills() {
        return player_kills;
    }

    public void setPlayer_kills(long player_kills) {
        this.player_kills = player_kills;
    }

    public long getFish_caught() {
        return fish_caught;
    }

    public void setFish_caught(long fish_caught) {
        this.fish_caught = fish_caught;
    }

    public long getAnimals_bred() {
        return animals_bred;
    }

    public void setAnimals_bred(long animals_bred) {
        this.animals_bred = animals_bred;
    }

    public long getLeave_game() {
        return leave_game;
    }

    public void setLeave_game(long leave_game) {
        this.leave_game = leave_game;
    }

    public long getJump() {
        return jump;
    }

    public void setJump(long jump) {
        this.jump = jump;
    }

    public long getDrop_count() {
        return drop_count;
    }

    public void setDrop_count(long drop_count) {
        this.drop_count = drop_count;
    }

    public long getPlay_one_minute() {
        return play_one_minute;
    }

    public void setPlay_one_minute(long play_one_minute) {
        this.play_one_minute = play_one_minute;
    }

    public long getWalk_one_cm() {
        return walk_one_cm;
    }

    public void setWalk_one_cm(long walk_one_cm) {
        this.walk_one_cm = walk_one_cm;
    }

    public long getWalk_on_water_one_cm() {
        return walk_on_water_one_cm;
    }

    public void setWalk_on_water_one_cm(long walk_on_water_one_cm) {
        this.walk_on_water_one_cm = walk_on_water_one_cm;
    }

    public long getFall_one_cm() {
        return fall_one_cm;
    }

    public void setFall_one_cm(long fall_one_cm) {
        this.fall_one_cm = fall_one_cm;
    }

    public long getSneak_time() {
        return sneak_time;
    }

    public void setSneak_time(long sneak_time) {
        this.sneak_time = sneak_time;
    }

    public long getClimb_one_cm() {
        return climb_one_cm;
    }

    public void setClimb_one_cm(long climb_one_cm) {
        this.climb_one_cm = climb_one_cm;
    }

    public long getFly_one_cm() {
        return fly_one_cm;
    }

    public void setFly_one_cm(long fly_one_cm) {
        this.fly_one_cm = fly_one_cm;
    }

    public long getWalk_under_water_one_cm() {
        return walk_under_water_one_cm;
    }

    public void setWalk_under_water_one_cm(long walk_under_water_one_cm) {
        this.walk_under_water_one_cm = walk_under_water_one_cm;
    }

    public long getMinecart_one_cm() {
        return minecart_one_cm;
    }

    public void setMinecart_one_cm(long minecart_one_cm) {
        this.minecart_one_cm = minecart_one_cm;
    }

    public long getBoat_one_cm() {
        return boat_one_cm;
    }

    public void setBoat_one_cm(long boat_one_cm) {
        this.boat_one_cm = boat_one_cm;
    }

    public long getPig_one_cm() {
        return pig_one_cm;
    }

    public void setPig_one_cm(long pig_one_cm) {
        this.pig_one_cm = pig_one_cm;
    }

    public long getHorse_one_cm() {
        return horse_one_cm;
    }

    public void setHorse_one_cm(long horse_one_cm) {
        this.horse_one_cm = horse_one_cm;
    }

    public long getSprint_one_cm() {
        return sprint_one_cm;
    }

    public void setSprint_one_cm(long sprint_one_cm) {
        this.sprint_one_cm = sprint_one_cm;
    }

    public long getCrouch_one_cm() {
        return crouch_one_cm;
    }

    public void setCrouch_one_cm(long crouch_one_cm) {
        this.crouch_one_cm = crouch_one_cm;
    }

    public long getAviate_one_cm() {
        return aviate_one_cm;
    }

    public void setAviate_one_cm(long aviate_one_cm) {
        this.aviate_one_cm = aviate_one_cm;
    }

    public long getTime_since_death() {
        return time_since_death;
    }

    public void setTime_since_death(long time_since_death) {
        this.time_since_death = time_since_death;
    }

    public long getTalked_to_villager() {
        return talked_to_villager;
    }

    public void setTalked_to_villager(long talked_to_villager) {
        this.talked_to_villager = talked_to_villager;
    }

    public long getTraded_with_villager() {
        return traded_with_villager;
    }

    public void setTraded_with_villager(long traded_with_villager) {
        this.traded_with_villager = traded_with_villager;
    }

    public long getCake_slices_eaten() {
        return cake_slices_eaten;
    }

    public void setCake_slices_eaten(long cake_slices_eaten) {
        this.cake_slices_eaten = cake_slices_eaten;
    }

    public long getCauldron_filled() {
        return cauldron_filled;
    }

    public void setCauldron_filled(long cauldron_filled) {
        this.cauldron_filled = cauldron_filled;
    }

    public long getCauldron_used() {
        return cauldron_used;
    }

    public void setCauldron_used(long cauldron_used) {
        this.cauldron_used = cauldron_used;
    }

    public long getArmor_cleaned() {
        return armor_cleaned;
    }

    public void setArmor_cleaned(long armor_cleaned) {
        this.armor_cleaned = armor_cleaned;
    }

    public long getBanner_cleaned() {
        return banner_cleaned;
    }

    public void setBanner_cleaned(long banner_cleaned) {
        this.banner_cleaned = banner_cleaned;
    }

    public long getBrewingstand_interaction() {
        return brewingstand_interaction;
    }

    public void setBrewingstand_interaction(long brewingstand_interaction) {
        this.brewingstand_interaction = brewingstand_interaction;
    }

    public long getBeacon_interaction() {
        return beacon_interaction;
    }

    public void setBeacon_interaction(long beacon_interaction) {
        this.beacon_interaction = beacon_interaction;
    }

    public long getDropper_inspected() {
        return dropper_inspected;
    }

    public void setDropper_inspected(long dropper_inspected) {
        this.dropper_inspected = dropper_inspected;
    }

    public long getHopper_inspected() {
        return hopper_inspected;
    }

    public void setHopper_inspected(long hopper_inspected) {
        this.hopper_inspected = hopper_inspected;
    }

    public long getDispenser_inspected() {
        return dispenser_inspected;
    }

    public void setDispenser_inspected(long dispenser_inspected) {
        this.dispenser_inspected = dispenser_inspected;
    }

    public long getNoteblock_played() {
        return noteblock_played;
    }

    public void setNoteblock_played(long noteblock_played) {
        this.noteblock_played = noteblock_played;
    }

    public long getNoteblock_tuned() {
        return noteblock_tuned;
    }

    public void setNoteblock_tuned(long noteblock_tuned) {
        this.noteblock_tuned = noteblock_tuned;
    }

    public long getFlower_potted() {
        return flower_potted;
    }

    public void setFlower_potted(long flower_potted) {
        this.flower_potted = flower_potted;
    }

    public long getTrapped_chest_triggered() {
        return trapped_chest_triggered;
    }

    public void setTrapped_chest_triggered(long trapped_chest_triggered) {
        this.trapped_chest_triggered = trapped_chest_triggered;
    }

    public long getEnderchest_opened() {
        return enderchest_opened;
    }

    public void setEnderchest_opened(long enderchest_opened) {
        this.enderchest_opened = enderchest_opened;
    }

    public long getItem_enchanted() {
        return item_enchanted;
    }

    public void setItem_enchanted(long item_enchanted) {
        this.item_enchanted = item_enchanted;
    }

    public long getRecord_played() {
        return record_played;
    }

    public void setRecord_played(long record_played) {
        this.record_played = record_played;
    }

    public long getFurnace_interaction() {
        return furnace_interaction;
    }

    public void setFurnace_interaction(long furnace_interaction) {
        this.furnace_interaction = furnace_interaction;
    }

    public long getCrafting_table_interaction() {
        return crafting_table_interaction;
    }

    public void setCrafting_table_interaction(long crafting_table_interaction) {
        this.crafting_table_interaction = crafting_table_interaction;
    }

    public long getChest_opened() {
        return chest_opened;
    }

    public void setChest_opened(long chest_opened) {
        this.chest_opened = chest_opened;
    }

    public long getSleep_in_bed() {
        return sleep_in_bed;
    }

    public void setSleep_in_bed(long sleep_in_bed) {
        this.sleep_in_bed = sleep_in_bed;
    }

    public long getShulker_box_opened() {
        return shulker_box_opened;
    }

    public void setShulker_box_opened(long shulker_box_opened) {
        this.shulker_box_opened = shulker_box_opened;
    }

    public long getTime_since_rest() {
        return time_since_rest;
    }

    public void setTime_since_rest(long time_since_rest) {
        this.time_since_rest = time_since_rest;
    }

    public long getSwim_one_cm() {
        return swim_one_cm;
    }

    public void setSwim_one_cm(long swim_one_cm) {
        this.swim_one_cm = swim_one_cm;
    }

    public long getDamage_dealt_absorbed() {
        return damage_dealt_absorbed;
    }

    public void setDamage_dealt_absorbed(long damage_dealt_absorbed) {
        this.damage_dealt_absorbed = damage_dealt_absorbed;
    }

    public long getDamage_dealt_resisted() {
        return damage_dealt_resisted;
    }

    public void setDamage_dealt_resisted(long damage_dealt_resisted) {
        this.damage_dealt_resisted = damage_dealt_resisted;
    }

    public long getDamage_blocked_by_shield() {
        return damage_blocked_by_shield;
    }

    public void setDamage_blocked_by_shield(long damage_blocked_by_shield) {
        this.damage_blocked_by_shield = damage_blocked_by_shield;
    }

    public long getDamage_absorbed() {
        return damage_absorbed;
    }

    public void setDamage_absorbed(long damage_absorbed) {
        this.damage_absorbed = damage_absorbed;
    }

    public long getDamage_resisted() {
        return damage_resisted;
    }

    public void setDamage_resisted(long damage_resisted) {
        this.damage_resisted = damage_resisted;
    }

    public long getClean_shulker_box() {
        return clean_shulker_box;
    }

    public void setClean_shulker_box(long clean_shulker_box) {
        this.clean_shulker_box = clean_shulker_box;
    }

    public long getOpen_barrel() {
        return open_barrel;
    }

    public void setOpen_barrel(long open_barrel) {
        this.open_barrel = open_barrel;
    }

    public long getInteract_with_blast_furnace() {
        return interact_with_blast_furnace;
    }

    public void setInteract_with_blast_furnace(long interact_with_blast_furnace) {
        this.interact_with_blast_furnace = interact_with_blast_furnace;
    }

    public long getInteract_with_smoker() {
        return interact_with_smoker;
    }

    public void setInteract_with_smoker(long interact_with_smoker) {
        this.interact_with_smoker = interact_with_smoker;
    }

    public long getInteract_with_lectern() {
        return interact_with_lectern;
    }

    public void setInteract_with_lectern(long interact_with_lectern) {
        this.interact_with_lectern = interact_with_lectern;
    }

    public long getInteract_with_campfire() {
        return interact_with_campfire;
    }

    public void setInteract_with_campfire(long interact_with_campfire) {
        this.interact_with_campfire = interact_with_campfire;
    }

    public long getInteract_with_cartography_table() {
        return interact_with_cartography_table;
    }

    public void setInteract_with_cartography_table(long interact_with_cartography_table) {
        this.interact_with_cartography_table = interact_with_cartography_table;
    }

    public long getInteract_with_loom() {
        return interact_with_loom;
    }

    public void setInteract_with_loom(long interact_with_loom) {
        this.interact_with_loom = interact_with_loom;
    }

    public long getInteract_with_stonecutter() {
        return interact_with_stonecutter;
    }

    public void setInteract_with_stonecutter(long interact_with_stonecutter) {
        this.interact_with_stonecutter = interact_with_stonecutter;
    }

    public long getBell_ring() {
        return bell_ring;
    }

    public void setBell_ring(long bell_ring) {
        this.bell_ring = bell_ring;
    }

    public long getRaid_trigger() {
        return raid_trigger;
    }

    public void setRaid_trigger(long raid_trigger) {
        this.raid_trigger = raid_trigger;
    }

    public long getRaid_win() {
        return raid_win;
    }

    public void setRaid_win(long raid_win) {
        this.raid_win = raid_win;
    }

    public long getInteract_with_anvil() {
        return interact_with_anvil;
    }

    public void setInteract_with_anvil(long interact_with_anvil) {
        this.interact_with_anvil = interact_with_anvil;
    }

    public long getInteract_with_grindstone() {
        return interact_with_grindstone;
    }

    public void setInteract_with_grindstone(long interact_with_grindstone) {
        this.interact_with_grindstone = interact_with_grindstone;
    }

    @Override
    public String toString() {
        return "Statistics{" +
               "damage_dealt=" + damage_dealt +
               ", damage_taken=" + damage_taken +
               ", deaths=" + deaths +
               ", mob_kills=" + mob_kills +
               ", player_kills=" + player_kills +
               ", fish_caught=" + fish_caught +
               ", animals_bred=" + animals_bred +
               ", leave_game=" + leave_game +
               ", jump=" + jump +
               ", drop_count=" + drop_count +
               ", play_one_minute=" + play_one_minute +
               ", walk_one_cm=" + walk_one_cm +
               ", walk_on_water_one_cm=" + walk_on_water_one_cm +
               ", fall_one_cm=" + fall_one_cm +
               ", sneak_time=" + sneak_time +
               ", climb_one_cm=" + climb_one_cm +
               ", fly_one_cm=" + fly_one_cm +
               ", walk_under_water_one_cm=" + walk_under_water_one_cm +
               ", minecart_one_cm=" + minecart_one_cm +
               ", boat_one_cm=" + boat_one_cm +
               ", pig_one_cm=" + pig_one_cm +
               ", horse_one_cm=" + horse_one_cm +
               ", sprint_one_cm=" + sprint_one_cm +
               ", crouch_one_cm=" + crouch_one_cm +
               ", aviate_one_cm=" + aviate_one_cm +
               ", time_since_death=" + time_since_death +
               ", talked_to_villager=" + talked_to_villager +
               ", traded_with_villager=" + traded_with_villager +
               ", cake_slices_eaten=" + cake_slices_eaten +
               ", cauldron_filled=" + cauldron_filled +
               ", cauldron_used=" + cauldron_used +
               ", armor_cleaned=" + armor_cleaned +
               ", banner_cleaned=" + banner_cleaned +
               ", brewingstand_interaction=" + brewingstand_interaction +
               ", beacon_interaction=" + beacon_interaction +
               ", dropper_inspected=" + dropper_inspected +
               ", hopper_inspected=" + hopper_inspected +
               ", dispenser_inspected=" + dispenser_inspected +
               ", noteblock_played=" + noteblock_played +
               ", noteblock_tuned=" + noteblock_tuned +
               ", flower_potted=" + flower_potted +
               ", trapped_chest_triggered=" + trapped_chest_triggered +
               ", enderchest_opened=" + enderchest_opened +
               ", item_enchanted=" + item_enchanted +
               ", record_played=" + record_played +
               ", furnace_interaction=" + furnace_interaction +
               ", crafting_table_interaction=" + crafting_table_interaction +
               ", chest_opened=" + chest_opened +
               ", sleep_in_bed=" + sleep_in_bed +
               ", shulker_box_opened=" + shulker_box_opened +
               ", time_since_rest=" + time_since_rest +
               ", swim_one_cm=" + swim_one_cm +
               ", damage_dealt_absorbed=" + damage_dealt_absorbed +
               ", damage_dealt_resisted=" + damage_dealt_resisted +
               ", damage_blocked_by_shield=" + damage_blocked_by_shield +
               ", damage_absorbed=" + damage_absorbed +
               ", damage_resisted=" + damage_resisted +
               ", clean_shulker_box=" + clean_shulker_box +
               ", open_barrel=" + open_barrel +
               ", interact_with_blast_furnace=" + interact_with_blast_furnace +
               ", interact_with_smoker=" + interact_with_smoker +
               ", interact_with_lectern=" + interact_with_lectern +
               ", interact_with_campfire=" + interact_with_campfire +
               ", interact_with_cartography_table=" + interact_with_cartography_table +
               ", interact_with_loom=" + interact_with_loom +
               ", interact_with_stonecutter=" + interact_with_stonecutter +
               ", bell_ring=" + bell_ring +
               ", raid_trigger=" + raid_trigger +
               ", raid_win=" + raid_win +
               ", interact_with_anvil=" + interact_with_anvil +
               ", interact_with_grindstone=" + interact_with_grindstone +
               '}';
    }

    public void checkForNulls() {
        if (Objects.isNull(instance.damage_dealt)) {
            instance.damage_dealt = 0;
        }

        if (Objects.isNull(instance.damage_taken)) {
            instance.damage_taken = 0;
        }

        if (Objects.isNull(instance.deaths)) {
            instance.deaths = 0;
        }

        if (Objects.isNull(instance.mob_kills)) {
            instance.mob_kills = 0;
        }

        if (Objects.isNull(instance.player_kills)) {
            instance.player_kills = 0;
        }

        if (Objects.isNull(instance.fish_caught)) {
            instance.fish_caught = 0;
        }

        if (Objects.isNull(instance.animals_bred)) {
            instance.animals_bred = 0;
        }

        if (Objects.isNull(instance.leave_game)) {
            instance.leave_game = 0;
        }

        if (Objects.isNull(instance.jump)) {
            instance.jump = 0;
        }

        if (Objects.isNull(instance.drop_count)) {
            instance.drop_count = 0;
        }

        if (Objects.isNull(instance.play_one_minute)) {
            instance.play_one_minute = 0;
        }

        if (Objects.isNull(instance.walk_one_cm)) {
            instance.walk_one_cm = 0;
        }

        if (Objects.isNull(instance.walk_on_water_one_cm)) {
            instance.walk_on_water_one_cm = 0;
        }

        if (Objects.isNull(instance.fall_one_cm)) {
            instance.fall_one_cm = 0;
        }

        if (Objects.isNull(instance.sneak_time)) {
            instance.sneak_time = 0;
        }

        if (Objects.isNull(instance.climb_one_cm)) {
            instance.climb_one_cm = 0;
        }

        if (Objects.isNull(instance.fly_one_cm)) {
            instance.fly_one_cm = 0;
        }

        if (Objects.isNull(instance.walk_under_water_one_cm)) {
            instance.walk_under_water_one_cm = 0;
        }

        if (Objects.isNull(instance.minecart_one_cm)) {
            instance.minecart_one_cm = 0;
        }

        if (Objects.isNull(instance.boat_one_cm)) {
            instance.boat_one_cm = 0;
        }

        if (Objects.isNull(instance.pig_one_cm)) {
            instance.pig_one_cm = 0;
        }

        if (Objects.isNull(instance.horse_one_cm)) {
            instance.horse_one_cm = 0;
        }

        if (Objects.isNull(instance.sprint_one_cm)) {
            instance.sprint_one_cm = 0;
        }

        if (Objects.isNull(instance.crouch_one_cm)) {
            instance.crouch_one_cm = 0;
        }

        if (Objects.isNull(instance.aviate_one_cm)) {
            instance.aviate_one_cm = 0;
        }

        if (Objects.isNull(instance.time_since_death)) {
            instance.time_since_death = 0;
        }

        if (Objects.isNull(instance.talked_to_villager)) {
            instance.talked_to_villager = 0;
        }

        if (Objects.isNull(instance.traded_with_villager)) {
            instance.traded_with_villager = 0;
        }

        if (Objects.isNull(instance.cake_slices_eaten)) {
            instance.cake_slices_eaten = 0;
        }

        if (Objects.isNull(instance.cauldron_filled)) {
            instance.cauldron_filled = 0;
        }

        if (Objects.isNull(instance.cauldron_used)) {
            instance.cauldron_used = 0;
        }

        if (Objects.isNull(instance.armor_cleaned)) {
            instance.armor_cleaned = 0;
        }

        if (Objects.isNull(instance.banner_cleaned)) {
            instance.banner_cleaned = 0;
        }

        if (Objects.isNull(instance.brewingstand_interaction)) {
            instance.brewingstand_interaction = 0;
        }

        if (Objects.isNull(instance.beacon_interaction)) {
            instance.beacon_interaction = 0;
        }

        if (Objects.isNull(instance.dropper_inspected)) {
            instance.dropper_inspected = 0;
        }

        if (Objects.isNull(instance.hopper_inspected)) {
            instance.hopper_inspected = 0;
        }

        if (Objects.isNull(instance.dispenser_inspected)) {
            instance.dispenser_inspected = 0;
        }

        if (Objects.isNull(instance.noteblock_played)) {
            instance.noteblock_played = 0;
        }

        if (Objects.isNull(instance.noteblock_tuned)) {
            instance.noteblock_tuned = 0;
        }

        if (Objects.isNull(instance.flower_potted)) {
            instance.flower_potted = 0;
        }

        if (Objects.isNull(instance.trapped_chest_triggered)) {
            instance.trapped_chest_triggered = 0;
        }

        if (Objects.isNull(instance.enderchest_opened)) {
            instance.enderchest_opened = 0;
        }

        if (Objects.isNull(instance.item_enchanted)) {
            instance.item_enchanted = 0;
        }

        if (Objects.isNull(instance.record_played)) {
            instance.record_played = 0;
        }

        if (Objects.isNull(instance.furnace_interaction)) {
            instance.furnace_interaction = 0;
        }

        if (Objects.isNull(instance.crafting_table_interaction)) {
            instance.crafting_table_interaction = 0;
        }

        if (Objects.isNull(instance.chest_opened)) {
            instance.chest_opened = 0;
        }

        if (Objects.isNull(instance.sleep_in_bed)) {
            instance.sleep_in_bed = 0;
        }

        if (Objects.isNull(instance.shulker_box_opened)) {
            instance.shulker_box_opened = 0;
        }

        if (Objects.isNull(instance.time_since_rest)) {
            instance.time_since_rest = 0;
        }

        if (Objects.isNull(instance.swim_one_cm)) {
            instance.swim_one_cm = 0;
        }

        if (Objects.isNull(instance.damage_dealt_absorbed)) {
            instance.damage_dealt_absorbed = 0;
        }

        if (Objects.isNull(instance.damage_dealt_resisted)) {
            instance.damage_dealt_resisted = 0;
        }

        if (Objects.isNull(instance.damage_blocked_by_shield)) {
            instance.damage_blocked_by_shield = 0;
        }

        if (Objects.isNull(instance.damage_absorbed)) {
            instance.damage_absorbed = 0;
        }

        if (Objects.isNull(instance.damage_resisted)) {
            instance.damage_resisted = 0;
        }

        if (Objects.isNull(instance.clean_shulker_box)) {
            instance.clean_shulker_box = 0;
        }

        if (Objects.isNull(instance.open_barrel)) {
            instance.open_barrel = 0;
        }

        if (Objects.isNull(instance.interact_with_blast_furnace)) {
            instance.interact_with_blast_furnace = 0;
        }

        if (Objects.isNull(instance.interact_with_smoker)) {
            instance.interact_with_smoker = 0;
        }

        if (Objects.isNull(instance.interact_with_lectern)) {
            instance.interact_with_lectern = 0;
        }

        if (Objects.isNull(instance.interact_with_campfire)) {
            instance.interact_with_campfire = 0;
        }

        if (Objects.isNull(instance.interact_with_cartography_table)) {
            instance.interact_with_cartography_table = 0;
        }

        if (Objects.isNull(instance.interact_with_loom)) {
            instance.interact_with_loom = 0;
        }

        if (Objects.isNull(instance.interact_with_stonecutter)) {
            instance.interact_with_stonecutter = 0;
        }

        if (Objects.isNull(instance.bell_ring)) {
            instance.bell_ring = 0;
        }

        if (Objects.isNull(instance.raid_trigger)) {
            instance.raid_trigger = 0;
        }

        if (Objects.isNull(instance.raid_win)) {
            instance.raid_win = 0;
        }

        if (Objects.isNull(instance.interact_with_anvil)) {
            instance.interact_with_anvil = 0;
        }

        if (Objects.isNull(instance.interact_with_grindstone)) {
            instance.interact_with_grindstone = 0;
        }
    }
}
