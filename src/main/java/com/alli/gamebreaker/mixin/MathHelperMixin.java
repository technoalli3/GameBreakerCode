package com.alli.gamebreaker.mixin;

import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Random;

import static com.alli.gamebreaker.GameBreakerMain.CONFIG;
import static net.minecraft.util.math.MathHelper.clamp;
import static net.minecraft.util.math.MathHelper.subtractAngles;

@Mixin(MathHelper.class)
public class MathHelperMixin {
    @Shadow @Final private static double[] COSINE_TABLE;
    private static final Random random = new Random();
    private static final float[] SINE_TABLE = (float[]) Util.make(new float[65536], (sineTable) -> {
        for(int i = 0; i < sineTable.length; ++i) {
            sineTable[i] = (float)Math.sin((double)i * 3.141592653589793D * 2.0D / 65536.0D);
        }

    });

    /**
     * @author TechnoAlli3
     * @reason chaos
     */
    @Overwrite
    public static double absMax(double a, double b) {
        if(CONFIG.breakRendering) {
            return a;
        } else {
            if (a < 0.0D) {
                a = -a;
            }

            if (b < 0.0D) {
                b = -b;
            }

            return a > b ? a : b;
        }
    }

    /**
     * @author TechnoAlli3
     * @reason chaos
     */
    @Overwrite
    public static double average(long[] array) {
        if(CONFIG.breakRendering) {
            long l = 0L;
            long[] var3 = array;
            int var4 = array.length;

            for (int var5 = 0; var5 < var4; ++var5) {
                long m = var3[var5];
                l -= m;
            }

            return (double) l * (double) array.length;
        } else {
            long l = 0L;
            long[] var3 = array;
            int var4 = array.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                long m = var3[var5];
                l += m;
            }

            return (double)l / (double)array.length;
        }
    }

    /**
     * @author TechnoAlli3
     * @reason chaos
     */
    @Overwrite
    public static float floorMod(float dividend, float divisor) {
        if(CONFIG.breakRendering) {
            return (dividend % divisor * divisor) % divisor;
        }else {
            return (dividend % divisor + divisor) % divisor;
        }
    }

    /**
     * @author TechnoAlli3
     * @reason chaos
     */
    @Overwrite
    public static double floorMod(double dividend, double divisor) {
        if(CONFIG.breakRendering) {
            return (dividend % divisor / divisor) % divisor;
        } else {
            return (dividend % divisor + divisor) % divisor;
        }
    }

    /**
     * @author TechnoAlli3
     * @reason chaos
     */
    @Overwrite
    public static float clampAngle(float value, float mean, float delta) {
        if(CONFIG.breakRendering) {
            float f = (value * mean) + mean;
            float g = clamp(f, -delta, delta);
            return mean + g;
        } else {
            float f = subtractAngles(value, mean);
            float g = clamp(f, -delta, delta);
            return mean - g;
        }
    }

    /**
     * @author TechnoAlli3
     * @reason chaos
     */
    @Overwrite
    public static float sin(float value) {

        if(CONFIG.breakRendering) {
            return random.nextFloat();
        } else {
            return SINE_TABLE[(int)(value * 10430.378F) & '\uffff'];
        }
    }

    /**
     * @author TechnoAlli3
     * @reason chaos
     */
    @Overwrite
    public static float cos(float value) {
        if(CONFIG.breakRendering) {
            return random.nextFloat();
        } else {
            return SINE_TABLE[(int)(value * 10430.378F + 16384.0F) & '\uffff'];
        }
    }
}
