package com.alli.gamebreaker.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.alli.gamebreaker.GameBreakerMain.CONFIG;

@Mixin(PlantBlock.class)
public class PlantBlockMixin {

    @Inject(method="canPlantOnTop", at=@At("HEAD"), cancellable = true)
    private void changePlantCheck(BlockState floor, BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if(CONFIG.plantAnywhere) {
            cir.setReturnValue(true);
        }
    }
}
