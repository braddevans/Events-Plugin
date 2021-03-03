package uk.co.breadhub.events.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import uk.co.breadhub.events.Main;
import uk.co.breadhub.events.entities.Statistics;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Statistics stats;
        stats = new Statistics(player);
        stats.checkForNulls();
        Main.getInstance().playerStats.put(player, stats);
        System.out.println(Main.getInstance().playerStats.get(player).toString());
    }

    @EventHandler
    public void onPlayerDisconnect(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        // remove players from scoreboard to save on memory
        Main.getInstance().playerStats.remove(player);
    }
}
