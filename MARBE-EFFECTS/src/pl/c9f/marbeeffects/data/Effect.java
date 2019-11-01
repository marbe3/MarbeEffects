package pl.c9f.marbeeffects.data;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class Effect {
	private ItemStack icon;
	private int price;
	private Material item;
	private PotionEffect effect;
	
	
}
