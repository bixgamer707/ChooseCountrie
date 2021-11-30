package me.bixgamer707.choosecountrie.setup;

import me.bixgamer707.choosecountrie.ChooseCountrie;
import me.bixgamer707.choosecountrie.commands.MainCommand;
import me.bixgamer707.choosecountrie.enums.Color;
import me.bixgamer707.choosecountrie.events.InventoryListener;
import me.bixgamer707.choosecountrie.events.JoinListener;
import me.bixgamer707.choosecountrie.placeholders.Placeholders;
import me.bixgamer707.choosecountrie.tabcomplete.Tab;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import java.util.logging.Logger;

public class SetupManager {
    private final ChooseCountrie plugin;

    public SetupManager(ChooseCountrie plugin){
        this.plugin = plugin;
    }
    private void registerCommands(){
        plugin.getCommand("countrie").setExecutor(new MainCommand(plugin));
    }

    private void registerListeners(Listener... listeners){
        for(Listener listener : listeners){
            Bukkit.getPluginManager().registerEvents(listener,plugin);
        }
    }

    private void registerTabComplete(){
        plugin.getCommand("countrie").setTabCompleter(new Tab());
    }

    public void registerAll(){
        sendConsoleMsg(
                Color.WHITE+"----------------------------------"+Color.RESET,
                Color.GREEN+"Has been activated "+Color.GRAY+"("+Color.BLUE+"version: "+Color.YELLOW+plugin.getDescription().getVersion()+Color.GRAY+")"+Color.RESET,
                Color.CYAN+"Thanks for using the plugin, "+Color.AQUA+"~bixgamer707"+Color.RESET,
                Color.WHITE+"----------------------------------"+ Color.RESET
        );
        registerCommands();
        //Register listeners
        registerListeners(
            new InventoryListener(plugin),
                new JoinListener(plugin)
        );
        registerTabComplete();
        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null){
            new Placeholders(plugin).register();
        }
    }

    public void unRegisterAll(){
        sendConsoleMsg(
                Color.WHITE+"----------------------------------"+Color.RESET,
                Color.YELLOW+"Has been deactivate"+Color.RESET,
                Color.RED+"Thanks for using the plugin!!"+Color.RESET,
                Color.WHITE+"----------------------------------"+Color.RESET
        );
    }

    private void sendConsoleMsg(String... msg){
        for(String string : msg){
           getLogger().info(string);
        }
    }

    public Logger getLogger(){
        return plugin.getLogger();
    }
}
