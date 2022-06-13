package com.alli.gamebreaker.mixin;

import net.minecraft.client.color.world.FoliageColors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(FoliageColors.class)
public class FoliageColoursMixin {
    private static final Random rand = new Random();

    @Inject(method="getBirchColor", at=@At("HEAD"), cancellable = true)
    private static void ChangeBirch(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(rand.nextInt(16777215));
    }

    @Inject(method="getSpruceColor", at=@At("HEAD"), cancellable = true)
    private static void ChangeSpruce(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(rand.nextInt(16777215));
    }

    @Inject(method="getDefaultColor", at=@At("HEAD"), cancellable = true)
    private static void ChangeDefault(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(rand.nextInt(16777215));
    }
}
