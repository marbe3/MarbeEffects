package pl.c9f.marbeeffects;

import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;
import pl.c9f.marbeeffects.command.EffectCommand;
import pl.c9f.marbeeffects.inventory.EffectInventory;
import pl.c9f.marbeeffects.listener.InventoryClickListener;
import pl.c9f.marbeeffects.manager.EffectManager;
import pl.c9f.marbeeffects.store.Settings;
import pl.c9f.marbeeffects.util.Effects;
import pl.c9f.marbeeffects.util.Enchantments;
@Getter
public class MarbeEffectsPlugin extends JavaPlugin{
	private EffectManager effectManager;
	private EffectInventory effectInventory;

	
	@Override
	public void onEnable(){
		Effects.loadEffects();
		Enchantments.loadEnchantments();
		new Settings(this).load();
		this.effectInventory = new EffectInventory(this);
		this.getCommand("efekty").setExecutor(new EffectCommand(this));
		this.effectManager = new EffectManager(this);
		this.effectManager.loadAll();
		this.getServer().getPluginManager().registerEvents(new InventoryClickListener(this), this);
	}

}
