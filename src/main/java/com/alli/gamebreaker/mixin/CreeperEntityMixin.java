package com.alli.gamebreaker.mixin;

import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.GameRules;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.alli.gamebreaker.GameBreakerMain.CONFIG;

@Mixin(CreeperEntity.class)
public abstract class CreeperEntityMixin {
	private static int deathCooldown = 0;
	private static float explosionPower = 3;

	@Inject(method="explode", at=@At("HEAD"), cancellable = true)
	private void modifyExplosion(CallbackInfo ci) {
		if(CONFIG.extraDestruction) {
			if (!((CreeperEntity) (Object) this).world.isClient) {
				Explosion.DestructionType destructionType = ((CreeperEntity) (Object) this).world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING) ? Explosion.DestructionType.DESTROY : Explosion.DestructionType.NONE;
				float f = ((CreeperEntity) (Object) this).isOverlayConditionMet() ? 2.0F : 1.0F;
				((CreeperEntity) (Object) this).world.createExplosion(((CreeperEntity) (Object) this), ((CreeperEntity) (Object) this).getX(), ((CreeperEntity) (Object) this).getY(), ((CreeperEntity) (Object) this).getZ(), explosionPower * f, destructionType);
				if (deathCooldown >= 100) {
					((CreeperEntity) (Object) this).discard();
					deathCooldown = 0;
					ci.cancel();
				} else {
					if (deathCooldown % 10 == 0) {
						explosionPower += 1;
					}
					deathCooldown++;
				}
			}
		}
	}

	@Inject(method="writeCustomDataToNbt", at=@At("TAIL"))
	private void SetCooldown(NbtCompound nbt, CallbackInfo ci) {
		if(CONFIG.extraDestruction) {
			nbt.putInt("deathCooldown", deathCooldown);
			nbt.putFloat("explosionPower", explosionPower);
		}
	}

	@Inject(method="readCustomDataFromNbt", at=@At("TAIL"))
	private void GetCooldown(NbtCompound nbt, CallbackInfo ci) {
		if(CONFIG.extraDestruction) {
			deathCooldown = nbt.getInt("deathCooldown");
			explosionPower = nbt.getFloat("explosionPower");
		}
	}
}
