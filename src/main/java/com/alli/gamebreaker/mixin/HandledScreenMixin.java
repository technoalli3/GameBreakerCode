package com.alli.gamebreaker.mixin;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.screen.ScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import static com.alli.gamebreaker.GameBreakerMain.CONFIG;

@Mixin(HandledScreen.class)
public abstract class HandledScreenMixin {
	@Shadow
	protected abstract boolean isClickOutsideBounds(double mouseX, double mouseY, int left, int top, int button);

	@Redirect(method="mouseClicked", at = @At(value="INVOKE", target="Lnet/minecraft/client/gui/screen/ingame/HandledScreen;isClickOutsideBounds(DDIII)Z"))
	private boolean setBoolFalse(HandledScreen<ScreenHandler> instance, double mouseX, double mouseY, int left, int top, int button) {
		if(CONFIG.rearrangeInventory) {
			return false;
		} else {
			return this.isClickOutsideBounds(mouseX, mouseY, left, top, button);
		}
	}
}
