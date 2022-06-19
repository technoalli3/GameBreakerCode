package com.alli.gamebreaker.mixin;

import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

import static com.alli.gamebreaker.GameBreakerMain.CONFIG;

@Mixin(BipedEntityModel.class)
public class BipedModelMixin {
	private final Random rand = new Random();
	private float bodyRot = 0;
	private int counter = 0;
	private float val1 = 0;
	private float val2 = 0;
	private float val3 = 0;
	private float val4 = 0;
	private float val5 = 0;
	private float val6 = 0;
	private float val7 = 0;
	private float val8 = 0;
	private float val9 = 0;
	private float val10 = 0;
	private float val11 = 0;
	private float val12 = 0;


	@Inject(method="setAngles(Lnet/minecraft/entity/LivingEntity;FFFFF)V", at=@At("TAIL"))
	private void ModifyPivots(LivingEntity livingEntity, float f, float g, float h, float i, float j, CallbackInfo ci) {
		if(CONFIG.modifyPlayer) {
			bodyRot += rand.nextFloat(0.08F);
			if (counter >= 40) {
				val1 = rand.nextFloat(40f) - 20f;
				val2 = rand.nextFloat(40f) - 20f;
				val3 = rand.nextFloat(40f) - 20f;
				val4 = rand.nextFloat(40f) - 20f;
				val5 = rand.nextFloat(40f) - 20f;
				val6 = rand.nextFloat(40f) - 20f;
				val7 = rand.nextFloat(40f) - 20f;
				val8 = rand.nextFloat(40f) - 20f;
				val9 = rand.nextFloat(40f) - 20f;
				val10 = rand.nextFloat(40f) - 20f;
				val11 = rand.nextFloat(40f) - 20f;
				val12 = rand.nextFloat(40f) - 20f;

				counter = 0;
			} else {
				counter++;
			}

			((BipedEntityModel<?>) (Object) this).body.pitch = bodyRot;
			((BipedEntityModel<?>) (Object) this).leftLeg.pivotX = val1;
			((BipedEntityModel<?>) (Object) this).leftLeg.pivotY = val2;
			((BipedEntityModel<?>) (Object) this).rightLeg.pivotX = val3;
			((BipedEntityModel<?>) (Object) this).rightLeg.pivotY = val4;
			((BipedEntityModel<?>) (Object) this).leftArm.pivotX = val5;
			((BipedEntityModel<?>) (Object) this).leftArm.pivotY = val6;
			((BipedEntityModel<?>) (Object) this).rightArm.pivotX = val7;
			((BipedEntityModel<?>) (Object) this).rightArm.pivotY = val8;
			((BipedEntityModel<?>) (Object) this).head.pivotX = val9;
			((BipedEntityModel<?>) (Object) this).head.pivotY = val10;
			((BipedEntityModel<?>) (Object) this).body.pivotY = val11;
			((BipedEntityModel<?>) (Object) this).body.pivotY = val12;
		}
	}
}
