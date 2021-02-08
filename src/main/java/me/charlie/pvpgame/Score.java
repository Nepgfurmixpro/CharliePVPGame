package me.charlie.pvpgame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import fr.mrmicky.fastboard.FastBoard;
import net.md_5.bungee.api.ChatColor;

public class Score implements Listener {

	int sc;
	ArrayList<FastBoard> scoreboards = new ArrayList<FastBoard>();

	public Score() {
		// Loop Through Player
		for (Player p : Main.scores.keySet()) {
			// Create A Scoreboard, And Set The Title For Each Player.
			FastBoard f = new FastBoard(p);
			f.updateTitle(ChatColor.BOLD + "" + ChatColor.GOLD + "Leaderboard");
			scoreboards.add(f);
		}
		updateBoard();
	}

	@EventHandler
	public void onHit(EntityDamageByEntityEvent event) {
		// Is Attacker And Attacked A Player
		if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
			// Remove Damage
			event.setDamage(0);

			Player attacked = (Player) event.getEntity();
			Player attacker = (Player) event.getDamager();

			// Will This Attack Kill Attacked Player
			if (Main.scores.get(attacked) > sc) {
				// Remove Score Change From Attacked, And Add It To The Attacker
				Main.scores.put(attacked, Main.scores.get(attacked) - sc);
				Main.scores.put(attacker, Main.scores.get(attacker) + sc);
			} else {
				// Yes, Attacked Died
				Main.scores.remove(attacked);
				Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + attacked.getName() + " Is Out! "
						+ Main.scores.size() + " Players Remain!");
			}

		} else {
			event.setCancelled(true);
		}
	}

	public void updateBoard() {
		sortScore();

		// What Lines Should Be On The Leaderboard
		Collection<String> lines = new ArrayList<String>();
		for (Entry<Player, Integer> entry : Main.scores.entrySet()) {
			lines.add(entry.getKey().getName() + " - " + entry.getValue());
		}

		// Update The Lines For All Players
		for (FastBoard b : scoreboards) {
			b.updateLines(lines);
		}
	}

	public void sortScore() {
		// Temp Scores
		HashMap<Player, Integer> newList = new HashMap<Player, Integer>();

		// Sort
		for (int i = 0; i < Main.scores.size(); i++) {
			Player p = null;
			for (Entry<Player, Integer> entry : Main.scores.entrySet()) {

				if (p.equals(null)) {
					p = entry.getKey();
				} else if (entry.getValue() > Main.scores.get(p)) {
					p = entry.getKey();
				}

			}
			// Sorted 1 Item, Resetting To Sort More Items.
			newList.put(p, Main.scores.get(p));
			Main.scores.remove(p);
			p = null;
		}

		Main.scores = (HashMap<Player, Integer>) newList.clone();
	}
}
