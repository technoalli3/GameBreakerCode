package com.alli.gamebreaker.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(PlantBlock.class)
public class PlantBlockMixin {
    /**
     * @author TechnoAlli3
     * @reason chaos
     */
    @Overwrite
    public boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return true;
    }
}
