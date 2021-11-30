package me.bixgamer707.choosecountrie.managers;

import me.bixgamer707.choosecountrie.ChooseCountrie;
import me.bixgamer707.choosecountrie.file.YamlFile;
import me.bixgamer707.choosecountrie.user.Players;

import java.util.ArrayList;
import java.util.UUID;

public class PlayersManager {
    private final ChooseCountrie plugin;
    public PlayersManager(ChooseCountrie plugin){
        this.plugin = plugin;
    }
    private final ArrayList<Players> players = new ArrayList<>();

    public void addPlayer(Players player){
        players.add(player);
    }
    public Players getPlayer(UUID uuid){
        for (Players value : players) {
            if (value.getUuid().equals(uuid)) {
                return value;
            }
        }
        return null;
    }

    public void savePlayers(){
        YamlFile player = plugin.getFileManager().getPlayers();
        player.set("Players",null);
        for(Players pl : players){
            player.set("Players."+pl.getUuid()+".countrie",pl.getCountrie());
        }
        player.save();
    }
    public void loadPlayers() {
        YamlFile player = plugin.getFileManager().getPlayers();
        if(player.contains("Players")){
            for(String key : player.getConfigurationSection("Players").getKeys(false)){
                Players pl = new Players(UUID.fromString(key));
                pl.setCountrie(player.getString("Players."+key+".countrie"));
                players.add(pl);
            }
        }
    }
}
