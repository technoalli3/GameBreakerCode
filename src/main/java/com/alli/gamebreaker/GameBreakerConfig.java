package com.alli.gamebreaker;

import org.quiltmc.config.api.WrappedConfig;
import org.quiltmc.config.api.annotations.Comment;

public class GameBreakerConfig extends WrappedConfig {

	@Comment("Break rendering?")
	public final boolean breakRendering = false;

	@Comment("Enable alternate world generation?")
	public final boolean altWorldGen = true;

	@Comment("Plants can be placed anywhere?")
	public final boolean plantAnywhere = true;

	@Comment("Add gibberish to tooltips?")
	public final boolean addGibberish = true;

	@Comment("Rotating clockwise?")
	public final boolean rotateClockwise = false;

	@Comment("Override subtitles?")
	public final boolean overrideSubtitles = true;

	@Comment("Override sounds?")
	public final boolean overrideSounds = true;

	@Comment("""
            If the above is true, set the variable below according to the listed chart:

            1: Discord Ping
            2: OG player hurt sound
            3: Heh

            """)
	public final int chosenSound = 1;

	@Comment("Shuffle inventory?")
	public final boolean shuffleInventory = true;

	@Comment("If the above is true, changing this number\nwill change the delay IN TICKS between shuffles")
	public final int shuffleDelay = 3600;

	@Comment("Extra-destructive creepers?")
	public final boolean extraDestruction = true;

	@Comment("Modify player model?")
	public final boolean modifyPlayer = true;

	@Comment("Scale models?")
	public final boolean scaleModels = true;

	@Comment("Rotate models?")
	public final boolean rotateModels = false;

	@Comment("Randomly scale models?")
	public final boolean randomScale = false;

	@Comment("Items float?")
	public final boolean floatingItems = true;

	@Comment("Rearrange inventory slots?")
	public final boolean rearrangeInventory = false;

}
