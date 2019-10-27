package pl.c9f.marbeeffects.store;

import pl.c9f.marbeeffects.MarbeEffectsPlugin;

public class Settings {
	private final MarbeEffectsPlugin plugin;
    public static String GUI_NAME;
    public static String NO_MONEY_MESSAGE;
    public static String SUCCESSFUL_BUY_MESSAGE;
    
    public Settings(MarbeEffectsPlugin plugin){
    	this.plugin = plugin;
    }
    public void load() {
    	this.plugin.saveDefaultConfig();
        GUI_NAME = this.plugin.getConfig().getString("gui-name");
        NO_MONEY_MESSAGE = this.plugin.getConfig().getString("no-money-message");
        SUCCESSFUL_BUY_MESSAGE = this.plugin.getConfig().getString("successful-buy-message");
    }
}
