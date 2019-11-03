package pl.c9f.marbeeffects;

import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;
import pl.c9f.marbeeffects.command.EffectCommand;
import pl.c9f.marbeeffects.inventory.EffectInventory;
import pl.c9f.marbeeffects.listener.InventoryClickListener;
import pl.c9f.marbeeffects.manager.EffectManager;
import pl.c9f.marbeeffects.store.Settings;
@Getter
public class MarbeEffectsPlugin extends JavaPlugin{
	private EffectManager effectManager;
	private EffectInventory effectInventory;

	
	@Override
	public void onEnable(){
		this.getLogger().info("Loading plugin..");
		this.effectInventory = new EffectInventory(this);
		this.effectManager = new EffectManager(this);
		new MarbeEffectsInitializer(this.getLogger()).initialize(
				new Settings(this),
				new EffectCommand(this),
				this.effectManager,
				new InventoryClickListener(this),
				this.effectInventory
				);
		this.getLogger().info("Loaded plugin!");
	}

}
