package com.alli.gamebreaker.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Matrix4f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.client.gui.screen.ingame.BookScreen.BOOK_TEXTURE;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin {
	@Shadow @Final private static Identifier END_SKY;

	@Inject(method= "renderSky(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/util/math/Matrix4f;FLnet/minecraft/client/render/Camera;ZLjava/lang/Runnable;)V", at=@At(value="INVOKE", target="Lcom/mojang/blaze3d/vertex/BufferBuilder;begin(Lcom/mojang/blaze3d/vertex/VertexFormat$DrawMode;Lcom/mojang/blaze3d/vertex/VertexFormat;)V", ordinal = 1))
	private void ChangeShader(MatrixStack matrices, Matrix4f projectionMatrix, float tickDelta, Camera camera, boolean bl, Runnable runnable, CallbackInfo ci) {
		RenderSystem.setShaderTexture(0, BOOK_TEXTURE);
	}

	@Inject(method="renderClouds(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/util/math/Matrix4f;FDDD)V", at=@At(value="INVOKE", target="Lnet/minecraft/client/render/BackgroundRenderer;setShaderFogColor()V"))
	private void ChangeClouds(MatrixStack matrices, Matrix4f projectionMatrix, float tickDelta, double d, double e, double f, CallbackInfo ci) {
		RenderSystem.setShaderTexture(0, END_SKY);
	}

}
