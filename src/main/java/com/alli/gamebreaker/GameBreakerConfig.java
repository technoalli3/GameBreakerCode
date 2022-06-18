package com.alli.gamebreaker;

import org.quiltmc.config.api.Config;
import org.quiltmc.config.api.WrappedConfig;
import org.quiltmc.config.api.annotations.Comment;

public class GameBreakerConfig extends WrappedConfig {
	public GameBreakerConfig() {
		super();
	}

	@Comment("Rotate clockwise constantly?")
	public final boolean rotateClockwise = false;

	@Comment("Override sounds?")
	public final boolean overrideSounds = true;

	@Comment("""
            If the above is true, set the variable below according to the listed chart:

            1: Discord Ping
            2: OG player hurt sound
            3: Heh

            """)
	public final int chosenSound = 1;

	@Comment("Break rendering?")
	public final boolean breakRendering = false;

}
