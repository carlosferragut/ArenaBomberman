package mc.alk.paintball;

import mc.alk.arena.objects.ArenaParams;
import mc.alk.arena.objects.MatchEventHandler;
import mc.alk.arena.objects.arenas.Arena;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PaintballArena extends Arena{
	/**
	 * We must override this constructor, but we can do nothing with it but give it to the super
	 */
	public PaintballArena(Arena arena) {
		super(arena);
	}

	/**
	 * We must override this constructor, but we can do nothing with it but give it to the super
	 */
	public PaintballArena(String arena, ArenaParams q) {
		super(arena, q);
	}
	
	/**
	 * This is how you create customized events.  You specify a method as a @MatchEventHandler
	 * and give it at least one bukkit event as the first argument.  In this case its EntityDamageByEntityEvent
	 * These events will ONLY be called when a match is ongoing
	 * If the event returns a player (in this case it does) then the event only gets called when
	 * 1) match is ongoing
	 * 2) player is still alive in the match
	 *
	 * @param event
	 */
	@MatchEventHandler
	public void onEntityDamage(EntityDamageByEntityEvent event) {
		if (event.isCancelled())
			return;
		Entity damager = event.getDamager();
		if (damager.getType() != EntityType.SNOWBALL)
			return;
		event.setDamage(20);
	}
	
}