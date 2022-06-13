package com.alli.gamebreaker;

import draylar.omegaconfig.api.Comment;
import draylar.omegaconfig.api.Config;
import org.jetbrains.annotations.Nullable;

import static com.alli.gamebreaker.GameBreakerMain.MOD_ID;

public class GameBreakerConfig implements Config {
    @Override
    public String getName() {
        return "config";
    }

    @Override
    public @Nullable String getModid() {
        return MOD_ID;
    }

    @Override
    public String getExtension() {
        return "json5";
    }

    @Override
    public String getDirectory() {
        return "gamebreaker";
    }

    @Comment("Break rendering?")
    public boolean breakRendering = false;

    @Comment("Enable alternate world generation?")
    public boolean altWorldGen = true;

    @Comment("Plants can be placed anywhere?")
    public boolean plantAnywhere = true;

    @Comment("Add gibberish to tooltips?")
    public boolean addGibberish = true;

    @Comment("Rotating clockwise?")
    public boolean rotateClockwise = false;

    @Comment("Override subtitles?")
    public boolean overrideSubtitles = true;

    @Comment("Override sounds?")
    public boolean overrideSounds = true;

    @Comment("""
            If the above is true, set the variable below according to the listed chart:
            
            1: Discord Ping
            2: OG player hurt sound
            3: Heh
            
            """)
    public int chosenSound = 1;

    @Comment("Shuffle inventory?")
    public boolean shuffleInventory = true;

    @Comment("Extra-destructive creepers?")
    public boolean extraDestruction = true;

    @Comment("Modify player model?")
    public boolean modifyPlayer = true;

    @Comment("Scale models?")
    public boolean scaleModels = true;

    @Comment("Rotate models?")
    public boolean rotateModels = false;

    @Comment("Randomly scale models?")
    public boolean randomScale = false;

    @Comment("Items float?")
    public boolean floatingItems = true;

    @Comment("Rearrange inventory slots?")
    public boolean rearrangeInventory = false;

    @Comment("If the above is true, changing this number\nwill change the delay IN TICKS between shuffles")
    public int shuffleDelay = 3600;
}
