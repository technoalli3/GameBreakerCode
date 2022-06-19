package com.alli.gamebreaker;

import draylar.omegaconfig.OmegaConfig;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

import static net.minecraft.client.gui.screen.ingame.BookScreen.BOOK_TEXTURE;

public class GameBreakerMain implements ModInitializer {
    public static final String MOD_ID = "gamebreaker";
    public static final GameBreakerConfig CONFIG = OmegaConfig.register(GameBreakerConfig.class);

    private static final Identifier FURNACE_TEXTURE = new Identifier("textures/gui/container/furnace.png");
    private static final Identifier SUN = new Identifier("textures/environment/sun.png");
    private static final Identifier CLOUDS = new Identifier("textures/environment/clouds.png");
    private static final Identifier FORCEFIELD = new Identifier("textures/misc/forcefield.png");
    private static final Identifier RAIN = new Identifier("textures/environment/rain.png");
    private static final Identifier SNOW = new Identifier("textures/environment/snow.png");
    private static final Identifier MOON_PHASES = new Identifier("textures/environment/moon_phases.png");
    private static final Identifier END_SKY = new Identifier("textures/environment/end_sky.png");

    public static final Identifier[] list = new Identifier[] {END_SKY, BOOK_TEXTURE, FURNACE_TEXTURE, SUN, CLOUDS, FORCEFIELD, RAIN, SNOW, MOON_PHASES};



    @Override
    public void onInitialize() {

    }
}
