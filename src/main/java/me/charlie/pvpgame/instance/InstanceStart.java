package me.charlie.pvpgame.instance;

import org.bukkit.entity.Player;

public class InstanceStart {
	InstanceMain im;

	public InstanceStart(InstanceMain im) {
		this.im = im;
	}

	public void newPlayer(Player p) {
		im.players.add(p);
	}

}
