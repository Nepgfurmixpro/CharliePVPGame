package me.charlie.pvpgame;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import net.md_5.bungee.api.ChatColor;

public class Score implements Listener {

	int sc;

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
				Main.scores.put(attacked, Main.scores.get(attacked) - sc);
				Main.scores.put(attacker, Main.scores.get(attacker) + sc);
			} else {
				//Yes, Attacked Died
				Main.scores.remove(attacked);
				Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + attacked.getName() + " Is Out! "
						+ Main.scores.size() + " Players Remain!");
			}

		} else {
			event.setCancelled(true);
		}
	}

}
