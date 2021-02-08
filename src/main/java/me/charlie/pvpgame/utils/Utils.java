package me.charlie.pvpgame.utils;

import me.charlie.pvpgame.Main;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Utils {
    public static void Info(String log) {
        System.out.println("[" + JavaPlugin.getPlugin(Main.class).getName() + "] " + log);
    }

    public static String Color(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
