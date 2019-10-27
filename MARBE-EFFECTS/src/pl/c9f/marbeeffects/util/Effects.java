package pl.c9f.marbeeffects.util;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.potion.PotionEffectType;
   
public final class Effects {
	private static final Map<String, PotionEffectType> EFFECTS = new HashMap<>();
	
	
	public Effects(){
		EFFECTS.put("ABSORPTION", PotionEffectType.ABSORPTION);
		EFFECTS.put("BLINDNESS", PotionEffectType.BLINDNESS);
		EFFECTS.put("CONFUSION", PotionEffectType.CONFUSION);
		EFFECTS.put("DAMAGE_RESISTANCE", PotionEffectType.DAMAGE_RESISTANCE);
		EFFECTS.put("FAST_DIGGING", PotionEffectType.FAST_DIGGING);
		EFFECTS.put("FIRE_RESISTANCE", PotionEffectType.FIRE_RESISTANCE);
		EFFECTS.put("HARM", PotionEffectType.HARM);
		EFFECTS.put("HEAL", PotionEffectType.HEAL);
		EFFECTS.put("HEALTH_BOOST", PotionEffectType.HEALTH_BOOST);
		EFFECTS.put("HUNGER", PotionEffectType.HUNGER);
		EFFECTS.put("INCREASE_DAMAGE", PotionEffectType.INCREASE_DAMAGE);
		EFFECTS.put("INVISIBILITY", PotionEffectType.INVISIBILITY);
		EFFECTS.put("JUMP", PotionEffectType.JUMP);
		EFFECTS.put("NIGHT_VISION", PotionEffectType.NIGHT_VISION);
		EFFECTS.put("POISON", PotionEffectType.POISON);
		EFFECTS.put("REGENERATION", PotionEffectType.REGENERATION);
		EFFECTS.put("SATURATION", PotionEffectType.SATURATION);
		EFFECTS.put("SLOW", PotionEffectType.SLOW);
		EFFECTS.put("SLOW_DIGGING", PotionEffectType.SLOW_DIGGING);
		EFFECTS.put("SPEED", PotionEffectType.SPEED);
		EFFECTS.put("WATER_BREATHING", PotionEffectType.WATER_BREATHING);
		EFFECTS.put("WEAKNESS", PotionEffectType.WEAKNESS);
		EFFECTS.put("WITHER", PotionEffectType.WITHER);
	}  
	
	public static PotionEffectType getEffect(String string) {
		String effectName = string.toUpperCase();
		if (EFFECTS.get(effectName) != null) {
			return (PotionEffectType)EFFECTS.get(effectName);
		}
		return null;
	}
}

