package me.charlie.pvpgame.instance;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;


public class InstanceScore implements Listener {

	@EventHandler
	public void onHit(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			//CANCEL DAMAGE (Without Canceling Event I Think We Still Want KB And Stuff)
			event.setDamage(0);
		}
	}
}
