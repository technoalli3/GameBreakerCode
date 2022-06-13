package com.alli.gamebreaker.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.SugarCaneBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(SugarCaneBlock.class)
public class SugarCaneMixin {
    /**
     * @author TechnoAlli3
     * @reason chaos
     */
    @Overwrite
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return true;
    }
}
