package com.alli.gamebreaker;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.config.QuiltConfig;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class GameBreakerMain implements ModInitializer {
	public static final String MOD_ID = "gamebreaker";
	public static final GameBreakerConfig CONFIG = QuiltConfig.create(MOD_ID, "gamebreaker_config", GameBreakerConfig.class);

	@Override
	public void onInitialize(ModContainer mod) {

	}
}
