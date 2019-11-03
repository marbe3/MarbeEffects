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
import pl.c9f.marbeeffects.util.ItemUtil;
import pl.c9f.marbeeffects.util.PotionUtil;

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
			final Material item3 = Material.getMaterial(cs.getInt(s + ".item"));
			final ItemStack icon3 = ItemUtil.parseItemStack(cs.getString(s + ".icon"));
			final int price3 = cs.getInt(s + ".price");
			final PotionEffect effect3 = PotionUtil.potionEffectFromString(cs.getString(s + ".effect"));
			effectMap.put(icon3, new Effect(icon3, price3, item3, effect3));
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
