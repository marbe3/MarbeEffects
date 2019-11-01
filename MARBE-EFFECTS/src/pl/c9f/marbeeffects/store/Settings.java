package pl.c9f.marbeeffects.store;

import pl.c9f.marbeeffects.MarbeEffectsPlugin;
import pl.c9f.marbeeffects.initializer.Initializer;

public class Settings implements Initializer{
	private final MarbeEffectsPlugin plugin;
    public static String GUI_NAME;
    public static String NO_MONEY_MESSAGE;
    public static String SUCCESSFUL_BUY_MESSAGE;
    
    public Settings(MarbeEffectsPlugin plugin){
    	this.plugin = plugin;
    }
	@Override
	public void initialize() {
    	this.plugin.saveDefaultConfig();
        GUI_NAME = this.plugin.getConfig().getString("gui-name");
        NO_MONEY_MESSAGE = this.plugin.getConfig().getString("no-money-message");
        SUCCESSFUL_BUY_MESSAGE = this.plugin.getConfig().getString("successful-buy-message");
    }
}
