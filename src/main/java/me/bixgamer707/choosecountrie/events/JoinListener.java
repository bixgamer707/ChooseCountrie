package me.bixgamer707.choosecountrie.events;

import me.bixgamer707.choosecountrie.ChooseCountrie;
import me.bixgamer707.choosecountrie.user.Players;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    private final ChooseCountrie plugin;
    public JoinListener(ChooseCountrie plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        Players pl = plugin.getPm().getPlayer(player.getUniqueId());
        if(pl != null){
            return;
        }
        pl = new Players(player.getUniqueId());
        plugin.getPm().addPlayer(pl);
    }
}
