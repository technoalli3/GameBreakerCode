package com.alli.gamebreaker.mixin;

import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.alli.gamebreaker.GameBreakerMain.CONFIG;

@Mixin(LivingEntity.class)
public abstract class RotateClockwiseMixin {

    @Inject(method="tick", at=@At("TAIL"))
    private void RotateEntity(CallbackInfo ci) {
        if(CONFIG.rotateClockwise) {
            float yaw = ((LivingEntity) (Object) this).getYaw();
            yaw += 2;
            ((LivingEntity) (Object) this).setYaw(yaw);
        }
    }
}
