package pl.c9f.marbeeffects.data;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class Effect {
	private ItemStack icon;
	private int price;
	private Material item;
	private PotionEffect effect;
	public Effect(ItemStack icon, int price, Material item, PotionEffect effect) {
		this.icon = icon;
		this.price = price;
		this.item = item;
		this.effect = effect;
	}
	
	public ItemStack getIcon() {
		return icon;
	}
	public void setIcon(ItemStack icon) {
		this.icon = icon;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Material getItem() {
		return item;
	}
	public void setItem(Material item) {
		this.item = item;
	}

	public PotionEffect getEffect() {
		return effect;
	}

	public void setEffect(PotionEffect effect) {
		this.effect = effect;
	} 
	
}
