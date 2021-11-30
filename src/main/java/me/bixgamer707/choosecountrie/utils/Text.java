package me.bixgamer707.choosecountrie.utils;

import me.bixgamer707.choosecountrie.file.YamlFile;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
    private static final Pattern HEX_PATTERN = Pattern.compile("#[a-fA-F0-9]{6}}");
    public static String hexColors(String text) {
        if (Bukkit.getVersion().contains("1.16") || Bukkit.getVersion().contains("1.17") || Bukkit.getVersion().contains("1.18")) {
            Matcher match = HEX_PATTERN.matcher(text);
            while (match.find()) {
                String color = text.substring(match.start(), match.end());
                text = text.replace(color, ChatColor.of(color) + "");
                match = HEX_PATTERN.matcher(text);
            }
        }
        return ChatColor.translateAlternateColorCodes('&', text);
    }
    public static String colorize(YamlFile config, YamlFile messagesEN, YamlFile messagesES, String path){
        if(config.getString("language").equalsIgnoreCase("en")) {
            return hexColors(config.getString("Prefix") + " " + messagesEN.getString(path));
        }else if(config.getString("language").equalsIgnoreCase("es")){
            return hexColors(config.getString("Prefix") + " " + messagesES.getString(path));
        }else{
            return hexColors(config.getString("Prefix")+" "+messagesEN.getString(path));
        }
    }
}
