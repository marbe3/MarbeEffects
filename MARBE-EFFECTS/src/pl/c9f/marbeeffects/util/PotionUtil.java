package pl.c9f.marbeeffects.util;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public final class PotionUtil {
	
	private PotionUtil() {
	}
	
    public static PotionEffect potionEffectFromString(final String string) {
        final String[] split = string.split(":");
        return new PotionEffect(PotionEffectType.getByName(split[0]), Integer.parseInt(split[1]) * 20, Integer.parseInt(split[2]) - 1);
    }
}
