package no.resource.pack.warnings.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.client.gui.screens.resourcepacks.ResourcePackSelectScreen;
import net.minecraft.server.packs.repository.PackCompatibility;

@Mixin(ResourcePackSelectScreen.class)
public class ResourcePackSelectScreenMixin {

	@Redirect(
		method = "lambda$init$1",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/server/packs/repository/PackCompatibility;isCompatible()Z"
		)
	)
	private boolean onInitRedirectIsCompatible(PackCompatibility compatibility) {
		return true;
	}
}
