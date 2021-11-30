package me.bixgamer707.choosecountrie.commands;

import me.bixgamer707.choosecountrie.ChooseCountrie;
import me.bixgamer707.choosecountrie.file.YamlFile;
import me.bixgamer707.choosecountrie.managers.InventorysManager;
import me.bixgamer707.choosecountrie.utils.Text;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;

public class MainCommand implements CommandExecutor {
    private final ChooseCountrie plugin;
    public MainCommand(ChooseCountrie plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)){
            plugin.getLogger().log(Level.INFO,"Cannot execute commands in the console");
            return false;
        }else{
            Player player = (Player) sender;
            YamlFile config = plugin.getFileManager().getConfig();
            YamlFile messagesEN = plugin.getFileManager().getMessagesEN();
            YamlFile messagesES = plugin.getFileManager().getMessagesES();
            if(args.length > 0){
                if(args[0].equalsIgnoreCase("reload")) {
                    if (player.hasPermission("choosecountry.reload") || player.hasPermission("coosecountry.*")) {
                        config.reload();
                        messagesEN.reload();
                        messagesES.reload();
                        player.sendMessage(Text.colorize(config, messagesEN, messagesES, "reload-message"));
                    } else {
                        player.sendMessage(Text.colorize(config, messagesEN, messagesES, "no-permission"));
                    }
                }else if(args[0].equalsIgnoreCase("additem")){
                    if(player.hasPermission("choosecountry.additem") || player.hasPermission("coosecountry.*")){
                        if(args.length > 3){
                            String name = args[1];
                            if(config.getString("Inventory.items."+name+".item") == null){
                                ItemStack item = player.getInventory().getItemInMainHand();
                                if(!item.getType().equals(Material.AIR)){
                                    config.set("Inventory.items."+name+".item",item);
                                    config.set("Inventory.items."+name+".countrie",args[2]);
                                    try{
                                        int i = Integer.parseInt(args[3]);
                                        config.set("Inventory.items."+name+".slot",i);
                                    }catch (NumberFormatException e){
                                        player.sendMessage(Text.colorize(config,messagesEN,messagesES,"number-exception"));
                                    }
                                    config.save();
                                }else{
                                    player.sendMessage(Text.colorize(config,messagesEN,messagesES,"item-error"));
                                }
                            }else{
                                player.sendMessage(Text.colorize(config,messagesEN,messagesES,"already-exist-item"));
                            }
                        }else{
                            player.sendMessage(Text.colorize(config,messagesEN,messagesES,"use-correct-additem"));
                        }
                    } else {
                        player.sendMessage(Text.colorize(config, messagesEN, messagesES, "no-permission"));
                    }
                }else{
                    InventorysManager im = new InventorysManager(plugin);
                    im.createInventory(player);
                }
            }else{
                InventorysManager im = new InventorysManager(plugin);
                im.createInventory(player);
            }
        }
        return true;
    }
}
