package com.alli.gamebreaker.mixin;

import net.minecraft.client.render.model.json.Transformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

import static com.alli.gamebreaker.GameBreakerMain.CONFIG;

@Mixin(Transformation.class)
public class TransformMixin {
	private final Random rand = new Random();

	@Mutable @Shadow @Final public Vec3f rotation;

	@Inject(method="apply", at=@At(value = "INVOKE_ASSIGN", target="Lnet/minecraft/util/math/Vec3f;getX()F", ordinal = 2))
	private void ChangeScale(boolean leftHanded, MatrixStack matrices, CallbackInfo ci) {
		if(CONFIG.scaleModels) {
			matrices.scale(5, 5, 5);
		}
		if(CONFIG.rotateModels) {
			this.rotation = new Vec3f(rand.nextFloat(8) + 45, rand.nextFloat(8) + 45, rand.nextFloat(8) + 45);
		}
		if(CONFIG.randomScale) {
			matrices.scale(rand.nextFloat(7), rand.nextFloat(7), rand.nextFloat(7));
		}
	}
}
