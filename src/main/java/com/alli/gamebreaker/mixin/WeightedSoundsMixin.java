package com.alli.gamebreaker.mixin;

import net.minecraft.client.sound.WeightedSoundSet;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.alli.gamebreaker.GameBreakerMain.CONFIG;

@Mixin(WeightedSoundSet.class)
public class WeightedSoundsMixin {
    @Inject(method="getSubtitle", at=@At("HEAD"), cancellable = true)
    private void changeSubtitle(CallbackInfoReturnable<Text> cir) {
        if(CONFIG.overrideSubtitles) {
            cir.setReturnValue(Text.of("[insert subtitle here]"));
        }
    }
}
