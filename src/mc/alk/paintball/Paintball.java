package mc.alk.paintball;

import mc.alk.arena.BattleArena;
import mc.alk.arena.util.Log;

import org.bukkit.plugin.java.JavaPlugin;
public class Paintball extends JavaPlugin{

	@Override
	public void onEnable(){
		/// Registers this plugin with BattleArena with a Paintball event
		/// this: our plugin
		/// "Paintball": The name of our event
		/// "pb": the name of our command ( who really wants to type in the entire word paintball?)
		/// PaintballArena.class: which arena should this event use
		BattleArena.registerMatchType(this, "Paintball", "pb", PaintballArena.class);

		Log.info("[" + getName()+ "] v" + getDescription().getVersion()+ " enabled!");
	}

	@Override
	public void onDisable(){
		Log.info("[" + getName()+ "] v" + getDescription().getVersion()+ " stopping!");
	}

}
