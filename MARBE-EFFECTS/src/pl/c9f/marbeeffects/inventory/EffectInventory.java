package pl.c9f.marbeeffects.inventory;

import java.util.stream.IntStream;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import pl.c9f.marbeeffects.MarbeEffectsPlugin;
import pl.c9f.marbeeffects.manager.EffectManager;
import pl.c9f.marbeeffects.store.Settings;
import pl.c9f.marbeeffects.util.ColorUtil;
import pl.c9f.marbeeffects.util.ItemUtil;


public class EffectInventory {
	private final MarbeEffectsPlugin plugin;
	public Inventory inventory;

	public EffectInventory(MarbeEffectsPlugin plugin) {
		this.plugin = plugin;	
	}
	
	public void open(Player player) {
		this.inventory = Bukkit.createInventory(player, plugin.getEffectManager().getNeededSlots(), ColorUtil.fixColor(Settings.GUI_NAME));
		IntStream.range(0, inventory.getSize()).forEach(i -> inventory.setItem(i, ItemUtil.getRandomGlass()));
		final EffectManager effectManager = plugin.getEffectManager();
		int i = 0;
		for (ItemStack icon : effectManager.getKeys()) {		
			inventory.setItem(i, icon);
			i++;
		}
		player.openInventory(inventory);
	}
}
