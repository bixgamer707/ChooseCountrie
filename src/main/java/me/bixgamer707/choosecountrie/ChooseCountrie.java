package me.bixgamer707.choosecountrie;

import me.bixgamer707.choosecountrie.file.FileManager;
import me.bixgamer707.choosecountrie.managers.PlayersManager;
import me.bixgamer707.choosecountrie.setup.SetupManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChooseCountrie extends JavaPlugin {

    private SetupManager sm;
    private FileManager fm;
    private PlayersManager pm;
    @Override
    public void onEnable() {
        fm = new FileManager(this);
        sm = new SetupManager(this);
        pm = new PlayersManager(this);
        fm.registerYmls();
        sm.registerAll();
        pm.loadPlayers();
    }

    @Override
    public void onDisable() {
        sm.unRegisterAll();
        pm.savePlayers();
    }

    public FileManager getFileManager() {
        return fm;
    }
    public PlayersManager getPm() {
        return pm;
    }
}
