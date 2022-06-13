package com.alli.gamebreaker.mixin;

import com.alli.gamebreaker.GameBreakerClient;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.checkerframework.checker.units.qual.A;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
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
