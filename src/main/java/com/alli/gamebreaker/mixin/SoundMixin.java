package com.alli.gamebreaker.mixin;


import net.minecraft.client.sound.Sound;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.alli.gamebreaker.GameBreakerMain.CONFIG;
import static com.alli.gamebreaker.GameBreakerMain.MOD_ID;

@Mixin(Sound.class)
public class SoundMixin {
	@Inject(method="getLocation", at=@At("HEAD"), cancellable = true)
	private void changeSound(CallbackInfoReturnable<Identifier> cir) {
		if(CONFIG.overrideSounds) {
			if (CONFIG.chosenSound == 1) {
				cir.setReturnValue(new Identifier(MOD_ID, "sounds/ping.ogg"));
			} else if (CONFIG.chosenSound == 2) {
				cir.setReturnValue(new Identifier(MOD_ID, "sounds/oof.ogg"));
			} else if (CONFIG.chosenSound == 3) {
				cir.setReturnValue(new Identifier(MOD_ID, "sounds/heh.ogg"));
			}
		}
	}
}
