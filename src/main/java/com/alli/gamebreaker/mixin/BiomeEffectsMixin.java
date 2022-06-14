package com.alli.gamebreaker.mixin;

import net.minecraft.world.biome.BiomeEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;
import java.util.Random;

@Mixin(BiomeEffects.class)
public class BiomeEffectsMixin {
	private final Random rand = new Random();

	@Inject(method="getWaterColor", at=@At("HEAD"), cancellable = true)
	private void ChangeWater(CallbackInfoReturnable<Integer> cir) {
		cir.setReturnValue(rand.nextInt(16777215));
	}

	@Inject(method="getFoliageColor", at=@At("HEAD"), cancellable = true)
	private void ChangeFoliage(CallbackInfoReturnable<Optional<Integer>> cir) {
		Optional<Integer> integer = Optional.of(rand.nextInt(16777215));
		cir.setReturnValue(integer);
	}

	@Inject(method="getGrassColor", at=@At("HEAD"), cancellable = true)
	private void ChangeGrass(CallbackInfoReturnable<Optional<Integer>> cir) {
		Optional<Integer> integer = Optional.of(rand.nextInt(16777215));
		cir.setReturnValue(integer);
	}
}
