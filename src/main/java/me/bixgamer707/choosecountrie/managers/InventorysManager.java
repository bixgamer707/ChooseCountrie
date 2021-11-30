package me.bixgamer707.choosecountrie.managers;

import me.bixgamer707.choosecountrie.ChooseCountrie;
import me.bixgamer707.choosecountrie.file.YamlFile;
import me.bixgamer707.choosecountrie.utils.Text;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventorysManager {
    private final ChooseCountrie plugin;
    public InventorysManager(ChooseCountrie plugin){
        this.plugin = plugin;
    }
    public void createInventory(Player player){
        YamlFile config = plugin.getFileManager().getConfig();
        Inventory inv;
        if(!config.getString("Inventory.type").equalsIgnoreCase("none")){
            inv = Bukkit.createInventory(null, InventoryType.valueOf(config.getString("Inventory.type")), Text.hexColors(config.getString("Inventory.title")));
        }else{
            inv = Bukkit.createInventory(null,config.getInt("Inventory.size"),Text.hexColors(config.getString("Inventory.title")));
        }
        if(!config.contains("Inventory.items")){
            player.sendMessage(Text.colorize(config,plugin.getFileManager().getMessagesEN(),plugin.getFileManager().getMessagesES(),"no-items-inv"));
            return;
        }
        for(String key : config.getConfigurationSection("Inventory.items").getKeys(false)){
            ItemStack item = config.getItemStack("Inventory.items."+key+".item");
            inv.setItem(config.getInt("Inventory.items."+key+".slot"),item);
        }
        player.openInventory(inv);
    }

}
