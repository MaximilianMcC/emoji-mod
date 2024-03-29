package net.mtmb;

import net.fabricmc.api.ClientModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Emoji implements ClientModInitializer {

	// Logger
	private static final Logger LOGGER = LogManager.getLogger();

	@Override
	public void onInitializeClient() {

		// Say that we started
		LOGGER.info("Emoji started!");
	}

}
