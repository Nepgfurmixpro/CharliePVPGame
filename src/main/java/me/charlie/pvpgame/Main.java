package me.charlie.pvpgame;

import me.charlie.pvpgame.utils.Utils;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
    	Utils.Info("------------------");
        Utils.Info("Enabling PVP Game");
        Utils.Info("------------------");
    }

    @Override
    public void onDisable() {
    	Utils.Info("------------------");
        Utils.Info("Disabling PVP Game");
        Utils.Info("------------------");
    }
}
