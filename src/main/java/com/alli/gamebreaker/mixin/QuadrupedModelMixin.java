package com.alli.gamebreaker.mixin;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.AnimalModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.QuadrupedEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PigEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(QuadrupedEntityModel.class)
public class QuadrupedModelMixin {
    private final Random rand = new Random();
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

    @Shadow @Final protected ModelPart head;

    @Shadow @Final protected ModelPart leftFrontLeg;

    @Shadow @Final protected ModelPart rightFrontLeg;

    @Shadow @Final protected ModelPart leftHindLeg;

    @Shadow @Final protected ModelPart rightHindLeg;

    @Inject(method="setAngles", at=@At("TAIL"))
    private void ModifyPivots(Entity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, CallbackInfo ci) {
        if(this.counter >= 40) {
            this.val1 = rand.nextFloat(40f) - 20f;
            this.val2 = rand.nextFloat(40f) - 20f;
            this.val3 = rand.nextFloat(40f) - 20f;
            this.val4 = rand.nextFloat(40f) - 20f;
            this.val5 = rand.nextFloat(40f) - 20f;
            this.val6 = rand.nextFloat(40f) - 20f;
            this.val7 = rand.nextFloat(40f) - 20f;
            this.val8 = rand.nextFloat(40f) - 20f;
            this.val9 = rand.nextFloat(40f) - 20f;
            this.val10 = rand.nextFloat(40f) - 20f;

            this.counter = 0;
        } else {
            this.counter++;
        }

        this.head.pivotX = this.val1;
        this.head.pivotY = this.val2;
        this.leftFrontLeg.pivotX = this.val3;
        this.leftFrontLeg.pivotY = this.val4;
        this.rightFrontLeg.pivotX = this.val5;
        this.rightFrontLeg.pivotY = this.val6;
        this.leftHindLeg.pivotX = this.val7;
        this.leftHindLeg.pivotY = this.val8;
        this.rightHindLeg.pivotX = this.val9;
        this.rightHindLeg.pivotY = this.val10;
    }
}
