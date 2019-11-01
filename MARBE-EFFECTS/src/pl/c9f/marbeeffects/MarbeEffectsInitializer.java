package pl.c9f.marbeeffects;

import java.util.Arrays;
import java.util.logging.Logger;

import pl.c9f.marbeeffects.initializer.Initializer;

public class MarbeEffectsInitializer{
	private final Logger logger;
	
	public MarbeEffectsInitializer(Logger logger) {
		this.logger = logger;
	}
	
	public void initialize(Initializer... initializers) {
		Arrays.stream(initializers).forEach(initializer -> {
			long time = System.currentTimeMillis();
			initializer.initialize();
			time = System.currentTimeMillis() - time;
			this.logger.info(String.format("%s loaded in: %d ms",
					initializer.getClass().getSimpleName(), time));
		});
	}
}
