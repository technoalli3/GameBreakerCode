package com.alli.gamebreaker.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.alli.gamebreaker.GameBreakerMain.MOD_ID;

public class ModBlocks {
    public static final Block PIG_BLOCK = new Block(FabricBlockSettings.of(Material.GLASS).sounds(BlockSoundGroup.SLIME).nonOpaque().hardness(1.5F));

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "cave_vines_plant_glass"), PIG_BLOCK);
    }
}
