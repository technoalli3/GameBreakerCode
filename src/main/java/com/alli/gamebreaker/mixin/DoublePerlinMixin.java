package com.alli.gamebreaker.mixin;

import com.alli.gamebreaker.GameBreakerMain;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(DoublePerlinNoiseSampler.class)
public class DoublePerlinMixin {
    private static final Random rand = new Random();

    @Inject(method="createAmplitude", at=@At("TAIL"), cancellable = true)
    private static void changeAmplitude(int octaves, CallbackInfoReturnable<Double> cir) {
        cir.setReturnValue(Math.sin(octaves));
    }

    @Inject(method="sample", at=@At("TAIL"), cancellable = true)
    private void changeSample(double x, double y, double z, CallbackInfoReturnable<Double> cir) {



        /*
        double sinX = Math.sin(Math.sqrt(Math.abs(z*x)));
        double sinY = Math.sin(Math.sqrt(Math.abs(x*y)));
        double sinZ = Math.sin(Math.sqrt(Math.abs(z*y)));
        cir.setReturnValue(Math.cos(sinX + sinY + sinZ));
        */

        /**fave so far **/

        double sinX = Math.sin(Math.sqrt(Math.abs(x)));
        double sinY = Math.sin(Math.sqrt(Math.abs(y)));
        double sinZ = Math.sin(Math.sqrt(Math.abs(z)));
        cir.setReturnValue(Math.cos(sinX + sinY + sinZ));


        /*
        double sinX = Math.sin(Math.pow(x,2));
        double sinY = Math.sin(Math.pow(y,2));
        double sinZ = Math.sin(Math.pow(z,2));
        cir.setReturnValue(Math.cos(sinX + sinY + sinZ));
        */



        /*
        double sinX = Math.sin(Math.sqrt(x));
        double sinY = Math.sin(Math.sqrt(y));
        double sinZ = Math.sin(Math.sqrt(z));
        cir.setReturnValue(Math.cos(sinX + sinY + sinZ));
        */

        //alternative cos(x+y+z);
    }
}
