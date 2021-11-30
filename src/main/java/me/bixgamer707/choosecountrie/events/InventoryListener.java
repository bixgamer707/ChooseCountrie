package me.bixgamer707.choosecountrie.events;

import me.bixgamer707.choosecountrie.ChooseCountrie;
import me.bixgamer707.choosecountrie.file.YamlFile;
import me.bixgamer707.choosecountrie.user.Players;
import me.bixgamer707.choosecountrie.utils.Text;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class InventoryListener implements Listener {
    private final ChooseCountrie plugin;
    public InventoryListener(ChooseCountrie plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        Players pl = plugin.getPm().getPlayer(player.getUniqueId());
        YamlFile config = plugin.getFileManager().getConfig();
        if(pl == null){
            return;
        }
        if(!config.getString("Inventory.type").equalsIgnoreCase("none")){
            if(!event.getInventory().getType().equals(InventoryType.valueOf(config.getString("Inventory.type")))){
                return;
            }
            if(!event.getView().getTitle().equalsIgnoreCase(Text.hexColors(config.getString("Inventory.title")))){
                return;
            }
            event.setCancelled(true);
            for(String key : config.getConfigurationSection("Inventory.items").getKeys(false)){
                int pos = config.getInt("Inventory.items."+key+".slot");
                if(event.getSlot() == pos){
                    pl.setCountrie(config.getString("Inventory.items."+key+".countrie"));
                    player.sendMessage(Text.colorize(plugin.getFileManager().getConfig(),plugin.getFileManager().getMessagesEN(),plugin.getFileManager().getMessagesES(),"change-countrie"));
                }
            }
        }else{
            if(!event.getView().getTitle().equalsIgnoreCase(Text.hexColors(config.getString("Inventory.title")))){
                return;
            }
            event.setCancelled(true);
            for(String key : config.getConfigurationSection("Inventory.items").getKeys(false)){
                int pos = config.getInt("Inventory.items."+key+".slot");
                if(event.getSlot() == pos){
                    pl.setCountrie(config.getString("Inventory.items."+key+".countrie"));
                    player.sendMessage(Text.colorize(plugin.getFileManager().getConfig(),plugin.getFileManager().getMessagesEN(),plugin.getFileManager().getMessagesES(),"change-countrie"));
                }
            }
        }
    }
}
