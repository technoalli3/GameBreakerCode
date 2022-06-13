package com.alli.gamebreaker;

import com.alli.gamebreaker.blocks.ModBlocks;
import draylar.omegaconfig.OmegaConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.carver.Carver;
import net.minecraft.world.gen.carver.CarverConfig;
import net.minecraft.world.gen.random.RandomSeed;
import net.minecraft.world.gen.stateprovider.RandomizedIntBlockStateProvider;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import org.checkerframework.checker.units.qual.C;

import java.util.UUID;

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
        ModBlocks.registerBlocks();
    }
}
