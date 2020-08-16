package uk.co.breadhub.events.database;

import uk.co.breadhub.events.Main;

import java.sql.*;
import java.util.UUID;

public class DatabaseImpl {
	private static String host = Main.getInstance().getConfig().getString("Database.Hostname");
	private static String port = Main.getInstance().getConfig().getString("Database.Port");
	private static String database = Main.getInstance().getConfig().getString("Database.Database");
	private static String username = Main.getInstance().getConfig().getString("Database.Username");
	private static String password = Main.getInstance().getConfig().getString("Database.Password");
	private static Connection con;

	public static void connect() {
		String UrlString = "jdbc:mysql://" + host + ":" + port + "/" + database + "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				con = DriverManager.getConnection(UrlString, username, password);
			} catch(Exception ex) {
				System.out.println("Failed to create the database connection. :");
				ex.printStackTrace();
			}
		} catch(ClassNotFoundException ex) {
			System.out.println("Driver not found.");
		}
	}

	public static Connection getConnection() {
		try {
			if(con == null || con.isClosed()) {
				connect();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void init() {
		String sql = "CREATE TABLE IF NOT EXISTS Events.playerStatistics(UUID VARCHAR(64) NOT NULL ," + "" +
				"DAMAGE_DEALT BIGINT(19) DEFAULT '0'," +
				"DAMAGE_TAKEN BIGINT(19) DEFAULT '0'," +
				"DEATHS BIGINT(19) DEFAULT '0'," +
				"MOB_KILLS BIGINT(19) DEFAULT '0'," +
				"PLAYER_KILLS BIGINT(19) DEFAULT '0'," +
				"FISH_CAUGHT BIGINT(19) DEFAULT '0'," +
				"ANIMALS_BRED BIGINT(19) DEFAULT '0'," +
				"LEAVE_GAME BIGINT(19) DEFAULT '0'," +
				"JUMP BIGINT(19) DEFAULT '0'," +
				"DROP_COUNT BIGINT(19) DEFAULT '0'," +
				"`DROP` BIGINT(19) DEFAULT '0'," +
				"PICKUP BIGINT(19) DEFAULT '0'," +
				"PLAY_ONE_MINUTE BIGINT(19) DEFAULT '0'," +
				"WALK_ONE_CM BIGINT(19) DEFAULT '0'," +
				"WALK_ON_WATER_ONE_CM BIGINT(19) DEFAULT '0'," +
				"FALL_ONE_CM BIGINT(19) DEFAULT '0'," +
				"SNEAK_TIME BIGINT(19) DEFAULT '0'," +
				"CLIMB_ONE_CM BIGINT(19) DEFAULT '0'," +
				"FLY_ONE_CM BIGINT(19) DEFAULT '0'," +
				"WALK_UNDER_WATER_ONE_CM BIGINT(19) DEFAULT '0'," +
				"MINECART_ONE_CM BIGINT(19) DEFAULT '0'," +
				"BOAT_ONE_CM BIGINT(19) DEFAULT '0'," +
				"PIG_ONE_CM BIGINT(19) DEFAULT '0'," +
				"HORSE_ONE_CM BIGINT(19) DEFAULT '0'," +
				"SPRINT_ONE_CM BIGINT(19) DEFAULT '0'," +
				"CROUCH_ONE_CM BIGINT(19) DEFAULT '0'," +
				"AVIATE_ONE_CM BIGINT(19) DEFAULT '0'," +
				"MINE_BLOCK BIGINT(19) DEFAULT '0'," +
				"USE_ITEM BIGINT(19) DEFAULT '0'," +
				"BREAK_ITEM BIGINT(19) DEFAULT '0'," +
				"CRAFT_ITEM BIGINT(19) DEFAULT '0'," +
				"KILL_ENTITY BIGINT(19) DEFAULT '0'," +
				"ENTITY_KILLED_BY BIGINT(19) DEFAULT '0'," +
				"TIME_SINCE_DEATH BIGINT(19) DEFAULT '0'," +
				"TALKED_TO_VILLAGER BIGINT(19) DEFAULT '0'," +
				"TRADED_WITH_VILLAGER BIGINT(19) DEFAULT '0'," +
				"CAKE_SLICES_EATEN BIGINT(19) DEFAULT '0'," +
				"CAULDRON_FILLED BIGINT(19) DEFAULT '0'," +
				"CAULDRON_USED BIGINT(19) DEFAULT '0'," +
				"ARMOR_CLEANED BIGINT(19) DEFAULT '0'," +
				"BANNER_CLEANED BIGINT(19) DEFAULT '0'," +
				"BREWINGSTAND_INTERACTION BIGINT(19) DEFAULT '0'," +
				"BEACON_INTERACTION BIGINT(19) DEFAULT '0'," +
				"DROPPER_INSPECTED BIGINT(19) DEFAULT '0'," +
				"HOPPER_INSPECTED BIGINT(19) DEFAULT '0'," +
				"DISPENSER_INSPECTED BIGINT(19) DEFAULT '0'," +
				"NOTEBLOCK_PLAYED BIGINT(19) DEFAULT '0'," +
				"NOTEBLOCK_TUNED BIGINT(19) DEFAULT '0'," +
				"FLOWER_POTTED BIGINT(19) DEFAULT '0'," +
				"TRAPPED_CHEST_TRIGGERED BIGINT(19) DEFAULT '0'," +
				"ENDERCHEST_OPENED BIGINT(19) DEFAULT '0'," +
				"ITEM_ENCHANTED BIGINT(19) DEFAULT '0'," +
				"RECORD_PLAYED BIGINT(19) DEFAULT '0'," +
				"FURNACE_INTERACTION BIGINT(19) DEFAULT '0'," +
				"CRAFTING_TABLE_INTERACTION BIGINT(19) DEFAULT '0'," +
				"CHEST_OPENED BIGINT(19) DEFAULT '0'," +
				"SLEEP_IN_BED BIGINT(19) DEFAULT '0'," +
				"SHULKER_BOX_OPENED BIGINT(19) DEFAULT '0'," +
				"TIME_SINCE_REST BIGINT(19) DEFAULT '0'," +
				"SWIM_ONE_CM BIGINT(19) DEFAULT '0'," +
				"DAMAGE_DEALT_ABSORBED BIGINT(19) DEFAULT '0'," +
				"DAMAGE_DEALT_RESISTED BIGINT(19) DEFAULT '0'," +
				"DAMAGE_BLOCKED_BY_SHIELD BIGINT(19) DEFAULT '0'," +
				"DAMAGE_ABSORBED BIGINT(19) DEFAULT '0'," +
				"DAMAGE_RESISTED BIGINT(19) DEFAULT '0'," +
				"CLEAN_SHULKER_BOX BIGINT(19) DEFAULT '0'," +
				"OPEN_BARREL BIGINT(19) DEFAULT '0'," +
				"INTERACT_WITH_BLAST_FURNACE BIGINT(19) DEFAULT '0'," +
				"INTERACT_WITH_SMOKER BIGINT(19) DEFAULT '0'," +
				"INTERACT_WITH_LECTERN BIGINT(19) DEFAULT '0'," +
				"INTERACT_WITH_CAMPFIRE BIGINT(19) DEFAULT '0'," +
				"INTERACT_WITH_CARTOGRAPHY_TABLE BIGINT(19) DEFAULT '0'," +
				"INTERACT_WITH_LOOM BIGINT(19) DEFAULT '0'," +
				"INTERACT_WITH_STONECUTTER BIGINT(19) DEFAULT '0'," +
				"BELL_RING BIGINT(19) DEFAULT '0'," +
				"RAID_TRIGGER BIGINT(19) DEFAULT '0'," +
				"RAID_WIN BIGINT(19) DEFAULT '0'," +
				"INTERACT_WITH_ANVIL BIGINT(19) DEFAULT '0'," +
				"INTERACT_WITH_GRINDSTONE BIGINT(19) DEFAULT '0', " +
				"PRIMARY KEY (`UUID`)) " + "ENGINE = InnoDB;";
		try {
			Statement stmt = getConnection().createStatement();
			stmt.executeUpdate(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void addPlayerStats(
			UUID uuid,
			long damage_dealt,
			long damage_taken,
			long deaths,
			long mob_kills,
			long player_kills,
			long fish_caught,
			long animals_bred,
			long leave_game,
			long jump,
			long drop_count,
			long drop,
			long pickup,
			long play_one_minute,
			long walk_one_cm,
			long walk_on_water_one_cm,
			long fall_one_cm,
			long sneak_time,
			long climb_one_cm,
			long fly_one_cm,
			long walk_under_water_one_cm,
			long minecart_one_cm,
			long boat_one_cm,
			long pig_one_cm,
			long horse_one_cm,
			long sprint_one_cm,
			long crouch_one_cm,
			long aviate_one_cm,
			long mine_block,
			long use_item,
			long break_item,
			long craft_item,
			long kill_entity,
			long entity_killed_by,
			long time_since_death,
			long talked_to_villager,
			long traded_with_villager,
			long cake_slices_eaten,
			long cauldron_filled,
			long cauldron_used,
			long armor_cleaned,
			long banner_cleaned,
			long brewingstand_interaction,
			long beacon_interaction,
			long dropper_inspected,
			long hopper_inspected,
			long dispenser_inspected,
			long noteblock_played,
			long noteblock_tuned,
			long flower_potted,
			long trapped_chest_triggered,
			long enderchest_opened,
			long item_enchanted,
			long record_played,
			long furnace_interaction,
			long crafting_table_interaction,
			long chest_opened,
			long sleep_in_bed,
			long shulker_box_opened,
			long time_since_rest,
			long swim_one_cm,
			long damage_dealt_absorbed,
			long damage_dealt_resisted,
			long damage_blocked_by_shield,
			long damage_absorbed,
			long damage_resisted,
			long clean_shulker_box,
			long open_barrel,
			long interact_with_blast_furnace,
			long interact_with_smoker,
			long interact_with_lectern,
			long interact_with_campfire,
			long interact_with_cartography_table,
			long interact_with_loom,
			long interact_with_stonecutter,
			long bell_ring,
			long raid_trigger,
			long raid_win,
			long interact_with_anvil,
			long interact_with_grindstone) {
		try {
			PreparedStatement ps = getConnection().prepareStatement("INSERT IGNORE INTO `playerStatistics` (" +
					"`UUID`, " +
					"`DAMAGE_DEALT`, " +
					"`DAMAGE_TAKEN`, " +
					"`DEATHS`, " +
					"`MOB_KILLS`, " +
					"`PLAYER_KILLS`, " +
					"`FISH_CAUGHT`, " +
					"`ANIMALS_BRED`, " +
					"`LEAVE_GAME`, " +
					"`JUMP`, " +
					"`DROP_COUNT`, " +
					"`DROP`, " +
					"`PICKUP`, " +
					"`PLAY_ONE_MINUTE`, " +
					"`WALK_ONE_CM`, " +
					"`WALK_ON_WATER_ONE_CM`, " +
					"`FALL_ONE_CM`, " +
					"`SNEAK_TIME`, " +
					"`CLIMB_ONE_CM`, " +
					"`FLY_ONE_CM`, " +
					"`WALK_UNDER_WATER_ONE_CM`, " +
					"`MINECART_ONE_CM`, " +
					"`BOAT_ONE_CM`, " +
					"`PIG_ONE_CM`, " +
					"`HORSE_ONE_CM`, " +
					"`SPRINT_ONE_CM`, " +
					"`CROUCH_ONE_CM`, " +
					"`AVIATE_ONE_CM`, " +
					"`MINE_BLOCK`, " +
					"`USE_ITEM`, " +
					"`BREAK_ITEM`, " +
					"`CRAFT_ITEM`, " +
					"`KILL_ENTITY`, " +
					"`ENTITY_KILLED_BY`, " +
					"`TIME_SINCE_DEATH`, " +
					"`TALKED_TO_VILLAGER`, " +
					"`TRADED_WITH_VILLAGER`, " +
					"`CAKE_SLICES_EATEN`, " +
					"`CAULDRON_FILLED`, " +
					"`CAULDRON_USED`, " +
					"`ARMOR_CLEANED`, " +
					"`BANNER_CLEANED`, " +
					"`BREWINGSTAND_INTERACTION`, " +
					"`BEACON_INTERACTION`, " +
					"`DROPPER_INSPECTED`, " +
					"`HOPPER_INSPECTED`, " +
					"`DISPENSER_INSPECTED`, " +
					"`NOTEBLOCK_PLAYED`, " +
					"`NOTEBLOCK_TUNED`, " +
					"`FLOWER_POTTED`, " +
					"`TRAPPED_CHEST_TRIGGERED`, " +
					"`ENDERCHEST_OPENED`, " +
					"`ITEM_ENCHANTED`, " +
					"`RECORD_PLAYED`, " +
					"`FURNACE_INTERACTION`, " +
					"`CRAFTING_TABLE_INTERACTION`, " +
					"`CHEST_OPENED`, " +
					"`SLEEP_IN_BED`, " +
					"`SHULKER_BOX_OPENED`, " +
					"`TIME_SINCE_REST`, " +
					"`SWIM_ONE_CM`, " +
					"`DAMAGE_DEALT_ABSORBED`, " +
					"`DAMAGE_DEALT_RESISTED`, " +
					"`DAMAGE_BLOCKED_BY_SHIELD`, " +
					"`DAMAGE_ABSORBED`, " +
					"`DAMAGE_RESISTED`, " +
					"`CLEAN_SHULKER_BOX`, " +
					"`OPEN_BARREL`, " +
					"`INTERACT_WITH_BLAST_FURNACE`, " +
					"`INTERACT_WITH_SMOKER`, " +
					"`INTERACT_WITH_LECTERN`, " +
					"`INTERACT_WITH_CAMPFIRE`, " +
					"`INTERACT_WITH_CARTOGRAPHY_TABLE`, " +
					"`INTERACT_WITH_LOOM`, " +
					"`INTERACT_WITH_STONECUTTER`, " +
					"`BELL_RING`, " +
					"`RAID_TRIGGER`, " +
					"`RAID_WIN`, " +
					"`INTERACT_WITH_ANVIL`, " +
					"`INTERACT_WITH_GRINDSTONE`) " +
					"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
			ps.setString(1, uuid.toString());
			ps.setLong(2, damage_dealt);
			ps.setLong(3, damage_taken);
			ps.setLong(4, deaths);
			ps.setLong(5, mob_kills);
			ps.setLong(6, player_kills);
			ps.setLong(7, fish_caught);
			ps.setLong(8, animals_bred);
			ps.setLong(9, leave_game);
			ps.setLong(10, jump);
			ps.setLong(11, drop_count);
			ps.setLong(12, drop);
			ps.setLong(12, pickup);
			ps.setLong(13, play_one_minute);
			ps.setLong(14, walk_one_cm);
			ps.setLong(15, walk_on_water_one_cm);
			ps.setLong(16, fall_one_cm);
			ps.setLong(17, sneak_time);
			ps.setLong(18, climb_one_cm);
			ps.setLong(19, fly_one_cm);
			ps.setLong(20, walk_under_water_one_cm);
			ps.setLong(21, minecart_one_cm);
			ps.setLong(22, boat_one_cm);
			ps.setLong(23, pig_one_cm);
			ps.setLong(24, horse_one_cm);
			ps.setLong(25, sprint_one_cm);
			ps.setLong(26, crouch_one_cm);
			ps.setLong(27, aviate_one_cm);
			ps.setLong(28, mine_block);
			ps.setLong(29, use_item);
			ps.setLong(10, break_item);
			ps.setLong(31, craft_item);
			ps.setLong(32, kill_entity);
			ps.setLong(33, entity_killed_by);
			ps.setLong(34, time_since_death);
			ps.setLong(35, talked_to_villager);
			ps.setLong(36, traded_with_villager);
			ps.setLong(37, cake_slices_eaten);
			ps.setLong(38, cauldron_filled);
			ps.setLong(39, cauldron_used);
			ps.setLong(40, armor_cleaned);
			ps.setLong(41, banner_cleaned);
			ps.setLong(42, brewingstand_interaction);
			ps.setLong(43, beacon_interaction);
			ps.setLong(44, dropper_inspected);
			ps.setLong(45, hopper_inspected);
			ps.setLong(46, dispenser_inspected);
			ps.setLong(47, noteblock_played);
			ps.setLong(48, noteblock_tuned);
			ps.setLong(49, flower_potted);
			ps.setLong(50, trapped_chest_triggered);
			ps.setLong(51, enderchest_opened);
			ps.setLong(52, item_enchanted);
			ps.setLong(53, record_played);
			ps.setLong(54, furnace_interaction);
			ps.setLong(55, crafting_table_interaction);
			ps.setLong(56, chest_opened);
			ps.setLong(57, sleep_in_bed);
			ps.setLong(58, shulker_box_opened);
			ps.setLong(59, time_since_rest);
			ps.setLong(60, swim_one_cm);
			ps.setLong(61, damage_dealt_absorbed);
			ps.setLong(62, damage_dealt_resisted);
			ps.setLong(63, damage_blocked_by_shield);
			ps.setLong(64, damage_absorbed);
			ps.setLong(65, damage_resisted);
			ps.setLong(66, clean_shulker_box);
			ps.setLong(67, open_barrel);
			ps.setLong(68, interact_with_blast_furnace);
			ps.setLong(69, interact_with_smoker);
			ps.setLong(70, interact_with_lectern);
			ps.setLong(71, interact_with_campfire);
			ps.setLong(72, interact_with_cartography_table);
			ps.setLong(73, interact_with_loom);
			ps.setLong(74, interact_with_stonecutter);
			ps.setLong(75, bell_ring);
			ps.setLong(76, raid_trigger);
			ps.setLong(77, raid_win);
			ps.setLong(78, interact_with_anvil);
			ps.setLong(79, interact_with_grindstone);
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	public static String getPlayerStatsByUuid(UUID uuid) {
		try {
			PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM playerStatistics WHERE UUID=?");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString("PlayerName");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}