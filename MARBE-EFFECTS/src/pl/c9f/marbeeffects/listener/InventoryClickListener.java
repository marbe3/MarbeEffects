package pl.c9f.marbeeffects.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import pl.c9f.marbeeffects.MarbeEffectsPlugin;
import pl.c9f.marbeeffects.data.Effect;
import pl.c9f.marbeeffects.store.Settings;
import pl.c9f.marbeeffects.util.ColorUtil;
import pl.c9f.marbeeffects.util.ItemUtil;

public class InventoryClickListener implements Listener{
    private final MarbeEffectsPlugin plugin;

    public InventoryClickListener(MarbeEffectsPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getInventory() == null) return;
        if (event.getCurrentItem() == null) return;  
        if (event.getCurrentItem().getType() == Material.AIR) return;
        final Player player = (Player) event.getWhoClicked();   
        if (event.getInventory().equals(plugin.getEffectInventory().inventory)){
            event.setCancelled(true);
            final ItemStack icon = event.getCurrentItem();  		
    		final Effect effect = plugin.getEffectManager().getEffect(icon);
    		if(effect == null) return;
    		if(player.getInventory().contains(effect.getItem(), effect.getPrice())){
    			int i = ItemUtil.getAmountOfItem(effect.getItem(), player, (short) 0) - effect.getPrice();
    			player.getInventory().remove(effect.getItem());
    			player.getInventory().addItem(new ItemStack(effect.getItem(), i));
    			player.removePotionEffect(effect.getEffect().getType());  			
    			player.addPotionEffect(effect.getEffect());
    			player.sendMessage(ColorUtil.fixColor(Settings.SUCCESSFUL_BUY_MESSAGE));
    			
    		} else {
    			player.sendMessage(ColorUtil.fixColor(Settings.NO_MONEY_MESSAGE));
    		}		
        }
    }
}
