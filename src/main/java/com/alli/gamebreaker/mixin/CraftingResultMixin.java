package com.alli.gamebreaker.mixin;

import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.CraftingResultSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CraftingResultSlot.class)
public class CraftingResultMixin {
	@Inject(method="canInsert", at=@At("TAIL"), cancellable = true)
	private void changePermissions(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(true);
	}
}
