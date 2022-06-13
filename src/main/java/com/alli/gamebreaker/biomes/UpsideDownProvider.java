package com.alli.gamebreaker.biomes;

import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.source.SeedMixer;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.random.ChunkRandom;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class UpsideDownProvider extends Region {
    public UpsideDownProvider(Identifier name, RegionType type, int weight) {
        super(name, type, weight);
    }

    public static long seed = 340925099;


    //public static SurfaceBuilder surfaceBuilder = new SurfaceBuilder(NoiseParametersKeys.PATCH, Blocks.OBSIDIAN.getDefaultState(), 3, seed, ChunkRandom.RandomProvider.LEGACY);

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
        super.addBiomes(registry, mapper);
        this.addBiome(mapper,
                ParameterUtils.Temperature.NEUTRAL,
                ParameterUtils.Humidity.NEUTRAL,
                ParameterUtils.Continentalness.FAR_INLAND,
                ParameterUtils.Erosion.EROSION_0,
                ParameterUtils.Weirdness.FULL_RANGE,
                ParameterUtils.Depth.FULL_RANGE,
                3f,
                null);
    }
}
