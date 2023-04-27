package io.github.tierrif.titleremover;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TitleRemoverMod implements ModInitializer {
	private static TitleRemoverMod INSTANCE;
	private final Logger logger = LoggerFactory.getLogger("titleremover");
	private final TitleDispatcher titleDispatcher = new TitleDispatcher();

	@Override
	public void onInitialize() {
		logger.info("TitleRemover initialized!");
		INSTANCE = new TitleRemoverMod();
	}

	public static TitleRemoverMod getInstance() {
		return INSTANCE;
	}

	public Logger getLogger() {
		return logger;
	}

	public TitleDispatcher getTitleDispatcher() {
		return titleDispatcher;
	}
}
