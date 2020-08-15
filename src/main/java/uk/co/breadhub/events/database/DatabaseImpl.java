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

	public static void addPlayerStats(String playername, UUID uuid) {
		try {
			PreparedStatement ps = getConnection().prepareStatement("INSERT INTO `playerStatistics` (`UUID`, `PlayerName`) VALUES (?,?) ON DUPLICATE KEY UPDATE PlayerName=?;");
			ps.setString(1, uuid.toString());
			ps.setString(2, playername);
			ps.setString(3, playername);
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	public static String getPlayerFromUUID(UUID uuid) {
		try {
			PreparedStatement ps = getConnection().prepareStatement("SELECT PlayerName FROM UUIDPlayerDB WHERE UUID=?");
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