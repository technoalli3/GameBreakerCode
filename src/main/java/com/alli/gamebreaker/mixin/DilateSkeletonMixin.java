package com.alli.gamebreaker.mixin;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.SkeletonEntityModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(SkeletonEntityModel.class)
public class DilateSkeletonMixin {
	/**
	 * @author TechnoAlli3
	 * @reason chaos
	 */
	@Overwrite
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = BipedEntityModel.getModelData(Dilation.NONE, 0.0F);
		ModelPartData modelPartData = modelData.getRoot();
		modelPartData.addChild("head", ModelPartBuilder.create().uv(0,0).cuboid(-16.0F, -32.0F, -16.0F, 32.0F, 32.0F, 32.0F), ModelTransform.pivot(0.0F,-70.0F,0.0F));
		modelPartData.addChild("headwear", ModelPartBuilder.create().uv(128,0).cuboid(-16.0F, -32.0F, -16.0F, 32.0F, 32.0F, 32.0F, new Dilation(0.5F)), ModelTransform.pivot(0.0F,-70.0F,0.0F));
		modelPartData.addChild("body", ModelPartBuilder.create().uv(64,64).cuboid(-16.0F, -23.0F, -8.0F, 32.0F, 48.0F, 16.0F), ModelTransform.pivot(0.0F,-48.0F,0.0F));
		modelPartData.addChild("left_arm", ModelPartBuilder.create().uv(160,64).cuboid(-31.0F /* 31 */, 1.0F, -4.0F, 8.0F, 48.0F, 8.0F, true), ModelTransform.pivot(15.0F,-72.0F,0.0F));
		modelPartData.addChild("right_arm", ModelPartBuilder.create().uv(160,64).cuboid(31.0F /* -39 */, 1.0F, -4.0F, 8.0F, 48.0F, 8.0F), ModelTransform.pivot(-15.0F,-72.0F,0.0F));
		modelPartData.addChild("left_leg", ModelPartBuilder.create().uv(0,64).cuboid(3.0F, 0.0F, -4.1F, 8.0F, 48.0F, 8.0F, true), ModelTransform.pivot(1.0F,-24.0F,0.1F));
		modelPartData.addChild("right_leg", ModelPartBuilder.create().uv(0,64).cuboid(-11.0F, 0.0F, -4.1F, 8.0F, 48.0F, 8.0F), ModelTransform.pivot(-1.0F,-24.0F,0.1F));

		return TexturedModelData.of(modelData, 256, 128);
	}
}
