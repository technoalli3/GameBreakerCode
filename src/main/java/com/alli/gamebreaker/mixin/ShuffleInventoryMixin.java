package com.alli.gamebreaker.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

import static com.alli.gamebreaker.GameBreakerMain.CONFIG;

/**
 * @author TechnoAlli3
 */

@Mixin(PlayerEntity.class)
public abstract class ShuffleInventoryMixin {
    @Shadow public abstract PlayerInventory getInventory();

    private static int shuffleCooldown = 0;
    private final Random random = new Random();


    @Inject(method="writeCustomDataToNbt", at=@At("TAIL"))
    private void WriteData(NbtCompound nbt, CallbackInfo ci) {
        if(CONFIG.shuffleInventory) {
            nbt.putInt("shufflecooldown", shuffleCooldown);
        }
    }

    @Inject(method="readCustomDataFromNbt", at=@At("TAIL"))
    private void ReadData(NbtCompound nbt, CallbackInfo ci) {
        if(CONFIG.shuffleInventory) {
            shuffleCooldown = nbt.getInt("shufflecooldown");
        }
    }


    @Inject(method="tick", at=@At("TAIL"))
    private void ShuffleInventory(CallbackInfo ci) {
        World world = ((LivingEntity)(Object)this).getWorld();
        if(CONFIG.shuffleInventory) {
            if(!world.isClient) {
                if (shuffleCooldown >= CONFIG.shuffleDelay) {
                    shuffleCooldown = 0;
                    Inventory inventory = this.getInventory();

                    for (int i = 0; i < 30; i++) {
                        int slotA = random.nextInt(36);
                        int slotB = random.nextInt(36);

                        ItemStack stackA = inventory.getStack(slotA);
                        ItemStack stackB = inventory.getStack(slotB);

                        if (stackA != null) {
                            inventory.removeStack(slotA);
                        }
                        if (stackB != null) {
                            inventory.removeStack(slotB);
                        }

                        if (stackA != null) {
                            inventory.setStack(slotB, stackA);
                        }
                        if (stackB != null) {
                            inventory.setStack(slotA, stackB);
                        }
                    }
                } else {
                    shuffleCooldown++;
                }
            }
        }
    }
}
