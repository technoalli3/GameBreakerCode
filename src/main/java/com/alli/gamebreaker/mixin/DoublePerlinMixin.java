package com.alli.gamebreaker.mixin;

import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

import static com.alli.gamebreaker.GameBreakerMain.CONFIG;

@Mixin(DoublePerlinNoiseSampler.class)
public class DoublePerlinMixin {
    private static final Random rand = new Random();

    @Inject(method="createAmplitude", at=@At("TAIL"), cancellable = true)
    private static void changeAmplitude(int octaves, CallbackInfoReturnable<Double> cir) {
        if(CONFIG.altWorldGen) {
            cir.setReturnValue(Math.sin(octaves));
        }
    }

    @Inject(method="sample", at=@At("TAIL"), cancellable = true)
    private void changeSample(double x, double y, double z, CallbackInfoReturnable<Double> cir) {

        if(CONFIG.altWorldGen) {
            double sinX = Math.sin(Math.sqrt(Math.abs(x)));
            double sinY = Math.sin(Math.sqrt(Math.abs(y)));
            double sinZ = Math.sin(Math.sqrt(Math.abs(z)));
            cir.setReturnValue(Math.cos(sinX + sinY + sinZ));
        }
        
    }
}
