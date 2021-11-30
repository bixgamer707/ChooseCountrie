package me.bixgamer707.choosecountrie.file;

import me.bixgamer707.choosecountrie.ChooseCountrie;

public class FileManager {

    private final ChooseCountrie plugin;
    public FileManager(ChooseCountrie plugin){
        this.plugin = plugin;
    }

    public YamlFile config,messagesEN,messagesES,players;
    public void registerYmls(){
        config = new YamlFile(plugin,"config.yml");
        messagesEN = new YamlFile(plugin,"messages_EN.yml");
        messagesES = new YamlFile(plugin,"messages_ES.yml");
        players = new YamlFile(plugin,"players.yml");
    }

    public YamlFile getConfig() {
        return config;
    }
    public YamlFile getMessagesEN() {
        return messagesEN;
    }
    public YamlFile getMessagesES() {
        return messagesES;
    }
    public YamlFile getPlayers() {
        return players;
    }
}