package com.alli.gamebreaker.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.alli.gamebreaker.GameBreakerMain.CONFIG;

@Mixin(Entity.class)
public abstract class FloatingItemMixin {

    @Inject(method="tick", at=@At("TAIL"))
    private void FloatItem(CallbackInfo ci) {
        if(CONFIG.floatingItems) {
            if (((Entity) (Object) this) instanceof ItemEntity item) {
                item.setNoGravity(true);
                item.setGlowing(true);
            }
        }
    }
}
