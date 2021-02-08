package me.charlie.pvpgame.instance;

import java.util.ArrayList;

import org.bukkit.Server;
import org.bukkit.entity.Player;

import me.charlie.pvpgame.Main;

public class InstanceMain {
	InstanceScore is;
	ArrayList<Player> players = new ArrayList<Player>();
	
	
	
	public InstanceMain(Server s) {
		//Create The Score Class, And Add Its Listener
		is = new InstanceScore();
		s.getPluginManager().registerEvents(is, new Main());
	}
}
