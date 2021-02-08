package me.charlie.pvpgame;

import me.charlie.pvpgame.utils.Utils;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
	
	public static HashMap<Player, Integer> scores = new HashMap<Player,Integer>();
	public static Score s;
	
    @Override
    public void onEnable() {
    	//Create Score And Register It
    	s = new Score();
    	getServer().getPluginManager().registerEvents(s, this);
    	
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
