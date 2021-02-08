package me.charlie.pvpgame;

import me.charlie.pvpgame.utils.Utils;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Utils.Info("Enabling PVP Game");
    }

    @Override
    public void onDisable() {
        Utils.Info("Disabling PVP Game");
    }
}
