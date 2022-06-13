package com.alli.gamebreaker.mixin;

import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(NoiseChunkGenerator.class)
public class ChunkNoiseMixin {
    private final Random rand = new Random();

    @Inject(method = "getHeight", at = @At("TAIL"), cancellable = true)
    private void changeHeight(int x, int z, Heightmap.Type heightmap, HeightLimitView world, CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(rand.nextInt());
    }


}
