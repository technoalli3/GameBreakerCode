package com.alli.gamebreaker.mixin;

import net.minecraft.inventory.Inventory;
import net.minecraft.screen.slot.Slot;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

import static com.alli.gamebreaker.GameBreakerMain.CONFIG;

@Mixin(Slot.class)
public class SlotMixin {
	private final Random rand = new Random();

	@Mutable @Shadow @Final public int x;

	@Mutable @Shadow @Final public int y;

	@Inject(method="<init>", at=@At("TAIL"))
	private void rearrangeSlots(Inventory inventory, int index, int x, int y, CallbackInfo ci) {
		if(CONFIG.rearrangeInventory) {
			this.x = rand.nextInt(256);
			this.y = rand.nextInt(256);
		}
	}
}
