package pl.c9f.marbeeffects.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.c9f.marbeeffects.MarbeEffectsPlugin;
import pl.c9f.marbeeffects.inventory.EffectInventory;

public class EffectCommand implements CommandExecutor{	
	private final MarbeEffectsPlugin plugin;
	
	public EffectCommand(MarbeEffectsPlugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String arg2, String[] arg) {
		if(command.getName().equalsIgnoreCase("efekty")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("Only for players");
				return true;
			}
			final Player player = (Player) sender;
			final EffectInventory inventory = plugin.getEffectInventory();	
			inventory.open(player);
			return true;
		}	
		return false;
	}

}
