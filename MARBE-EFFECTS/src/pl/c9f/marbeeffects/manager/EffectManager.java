package pl.c9f.marbeeffects.manager;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import pl.c9f.marbeeffects.MarbeEffectsPlugin;
import pl.c9f.marbeeffects.data.Effect;
import pl.c9f.marbeeffects.initializer.Initializer;
import pl.c9f.marbeeffects.util.Effects;
import pl.c9f.marbeeffects.util.ItemUtil;

public class EffectManager implements Initializer{
	private final MarbeEffectsPlugin plugin;
	private Map<ItemStack, Effect> effectMap = new ConcurrentHashMap<>();
	
	public EffectManager(MarbeEffectsPlugin plugin) {
		this.plugin = plugin;
	}
	@Override
	@SuppressWarnings("deprecation")
	public void initialize() {
		final ConfigurationSection cs = plugin.getConfig().getConfigurationSection("effects");
		for(String s : cs.getKeys(false)) {
			int item = plugin.getConfig().getInt(cs.getName() + "." + s + "." + "item");
			String icon = plugin.getConfig().getString(cs.getName() + "." + s + "."  + "icon");
			int price = plugin.getConfig().getInt(cs.getName() + "." + s  + "." + "price");
			String effect = plugin.getConfig().getString(cs.getName() + "." + s + "." + "effect");
			int duration = plugin.getConfig().getInt(cs.getName() + "." + s + "." + "duration");
			int amplifier = plugin.getConfig().getInt(cs.getName() + "." + s + "." + "amplifier");
			Material item2 = Material.getMaterial(item);
			ItemStack icon2 = ItemUtil.parseItemStack(icon);
			PotionEffect effect2 = new PotionEffect(Effects.getEffect(effect), duration * 20, amplifier);
			effectMap.put(icon2, new Effect(icon2, price, item2, effect2));
		}
	}
	public int getAmount() {
		return effectMap.values().size();
	}
	public Collection<Effect> getAllEffects() {
		return effectMap.values();
	}
	
	public Effect getEffect(ItemStack item) {
		return effectMap.get(item);
	    }
	public Set<ItemStack> getKeys() {
		return effectMap.keySet();
	}
	public int getNeededSlots() {;
		return plugin.getEffectManager().getAmount() / 9 * 9 + 9;
	}
}
