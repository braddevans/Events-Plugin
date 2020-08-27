package uk.co.breadhub.events.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import uk.co.breadhub.events.Main;
import uk.co.breadhub.events.utils.PlayerStatisticsUtil;
import uk.co.breadhub.events.utils.ScoreboardSign;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        ScoreboardSign scoreboard = new ScoreboardSign(player, "TestScore");
        scoreboard.create();
        scoreboard.setLine(0, "TestPlayer");
        Main.getInstance().boards.put(player, scoreboard);
    }
}
