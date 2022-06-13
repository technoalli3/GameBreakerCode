package com.alli.gamebreaker.mixin;

import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import org.checkerframework.checker.units.qual.A;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

import static com.alli.gamebreaker.GameBreakerMain.CONFIG;
import static net.minecraft.util.math.MathHelper.clamp;
import static net.minecraft.util.math.MathHelper.subtractAngles;

@Mixin(MathHelper.class)
public class MathHelperMixin {
    private static final Random random = new Random();
    private static final float[] SINE_TABLE = (float[]) Util.make(new float[65536], (sineTable) -> {
        for(int i = 0; i < sineTable.length; ++i) {
            sineTable[i] = (float)Math.sin((double)i * 3.141592653589793D * 2.0D / 65536.0D);
        }

    });

    @Inject(method="absMax", at=@At("HEAD"), cancellable = true)
    private static void changeAbsMax(double a, double b, CallbackInfoReturnable<Double> cir) {
        if(CONFIG.breakRendering) {
            cir.setReturnValue(a);
        }
    }

    @Inject(method="average", at=@At("HEAD"), cancellable = true)
    private static void changeAverage(long[] array, CallbackInfoReturnable<Double> cir) {
        if(CONFIG.breakRendering) {
            long l = 0L;
            long[] var3 = array;
            int var4 = array.length;

            for (int var5 = 0; var5 < var4; ++var5) {
                long m = var3[var5];
                l -= m;
            }
            cir.setReturnValue((double) l * (double) array.length);
        }
    }

    @Inject(method="floorMod(FF)F", at=@At("HEAD"), cancellable = true)
    private static void changeFloorModFloat(float dividend, float divisor, CallbackInfoReturnable<Float> cir) {
        if(CONFIG.breakRendering) {
            cir.setReturnValue((dividend % divisor * divisor) % divisor);
        }
    }

    @Inject(method="floorMod(DD)D", at=@At("HEAD"), cancellable = true)
    private static void changeFloorModDouble(double dividend, double divisor, CallbackInfoReturnable<Double> cir) {
        if(CONFIG.breakRendering) {
            cir.setReturnValue((dividend % divisor / divisor) % divisor);
        }
    }

    @Inject(method="clampAngle", at=@At("HEAD"), cancellable = true)
    private static void changeClampAngle(float value, float mean, float delta, CallbackInfoReturnable<Float> cir) {
        if(CONFIG.breakRendering) {
            float f = (value * mean) + mean;
            float g = clamp(f, -delta, delta);
            cir.setReturnValue(mean + g);
        }
    }

    @Inject(method="sin", at=@At("HEAD"), cancellable = true)
    private static void changeSin(float value, CallbackInfoReturnable<Float> cir) {
        if(CONFIG.breakRendering) {
            cir.setReturnValue(random.nextFloat());
        }
    }

    @Inject(method="cos", at=@At("HEAD"), cancellable = true)
    private static void changeCos(float value, CallbackInfoReturnable<Float> cir) {
        if(CONFIG.breakRendering) {
            cir.setReturnValue(random.nextFloat());
        }
    }
}
