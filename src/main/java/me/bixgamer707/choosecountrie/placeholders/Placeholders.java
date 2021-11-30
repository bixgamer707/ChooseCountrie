package me.bixgamer707.choosecountrie.placeholders;

import me.bixgamer707.choosecountrie.ChooseCountrie;
import me.bixgamer707.choosecountrie.user.Players;
import org.bukkit.entity.Player;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;

public class Placeholders extends PlaceholderExpansion {
    private final ChooseCountrie plugin;
    public Placeholders(ChooseCountrie plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean persist() {
        return true;
    }
    @Override
    public boolean canRegister() {
        return true;
    }
    @Override
    public String getAuthor() {
        return "bixgamer707";
    }
    @Override
    public String getIdentifier() {
        return "choosecountrie";
    }

    @Override
    public String getVersion() {
        return plugin.getDescription().getVersion();
    }


    @Override
    public String onPlaceholderRequest(Player player, String identifier) {

        if (player == null) {
            return "";
        }

        if (identifier.equals("countrie")) {
            Players pl = plugin.getPm().getPlayer(player.getUniqueId());
            if (pl != null) {
                return pl.getCountrie();
            } else {
                return "none";
            }
        }
        return null;
    }
}
