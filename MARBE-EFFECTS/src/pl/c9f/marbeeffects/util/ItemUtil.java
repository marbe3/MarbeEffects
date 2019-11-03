package pl.c9f.marbeeffects.util; 

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;


public final class ItemUtil {
	private static final Random RANDOM = new Random();
	private ItemUtil() {
	}
	@SuppressWarnings("deprecation")
	public static ItemStack parseItemStack(String itemStack) {
		ItemStack is = new ItemStack(Material.AIR);
		String[] strings = itemStack.split(" ");
		String[] item = strings[0].split(":");
		if (item.length > 1) {
			Material m = Material.getMaterial(Integer.parseInt(item[0]));
			is.setType(m);
			is.setDurability(Short.parseShort(item[1]));
		}
		else if (IntUtil.isInt(item[0])) {
			Material m = Material.getMaterial(Integer.parseInt(item[0]));
			is.setType(m);
		} else {
			Material m = Material.getMaterial(item[0]);
			is.setType(m);
		}   
		int amount = 1;
		if (IntUtil.isInt(strings[1])) {
			amount = Integer.parseInt(strings[1]);
		}
		is.setAmount(amount);
		for (int i = 2; i < strings.length; i++) {
			String s = strings[i];
			String[] trim = s.split(":");
			if (trim.length >= 1) {
				if (trim[0].equalsIgnoreCase("name")) {
					ItemMeta im = is.getItemMeta();
					String name = ColorUtil.fixColor(trim[1].replace("_", " "));
					
					im.setDisplayName(name);
					is.setItemMeta(im);
				} else if (trim[0].equalsIgnoreCase("lore")) {
					ItemMeta im = is.getItemMeta();
					trim[1] = trim[1].replace("_", " ");
					String[] lorestring = trim[1].split("&nl");
					List<String> lore = new ArrayList<>();
					for (String s1 : lorestring) {
						lore.add(ColorUtil.fixColor(s1));
					}
					im.setLore(lore);
					is.setItemMeta(im);
				}
				else if (trim[0].equalsIgnoreCase("owner")) {
					is.setType(Material.SKULL);
					SkullMeta im = (SkullMeta)is.getItemMeta();
					im.setOwner(ColorUtil.fixColor(trim[1]));
				} else {
					Enchantment e = Enchantment.getByName(trim[0]);
					if (e != null) {
						int lvl = Integer.parseInt(trim[1]);
						ItemMeta im = is.getItemMeta();
						is.setItemMeta(im);
						is.addUnsafeEnchantment(e, lvl);
					}
				} } }
		return is;
	} 
    public static ItemStack getRandomGlass() {
    	ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) (RANDOM.nextInt(15 - 1) + 1));
		ItemMeta glassMeta = glass.getItemMeta();
		glassMeta.setDisplayName(" ");
		glass.setItemMeta(glassMeta);
		return glass;
    }
    
    public static int getAmountOfItem(final Material material, final Player player, final short durability) {
        int amount = 0;
        ItemStack[] contents;
        for (int length = (contents = player.getInventory().getContents()).length, i = 0; i < length; ++i) {
            final ItemStack itemStack = contents[i];
            if (itemStack != null && itemStack.getType().equals((Object)material) && itemStack.getDurability() == durability) {
                amount += itemStack.getAmount();
            }
        }
        return amount;
    }

}

