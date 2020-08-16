package uk.co.breadhub.events.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import uk.co.breadhub.events.utils.PlayerStatisticsUtil;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        new PlayerStatisticsUtil(event.getPlayer().getUniqueId());
    }
}
