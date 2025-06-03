package no.resource.pack.warnings.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.client.Options;
import net.minecraft.server.packs.repository.PackCompatibility;

@Mixin(Options.class)
public class OptionsMixin {

	@Redirect(
		method = "updateResourcePacks",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/server/packs/repository/PackCompatibility;isCompatible()Z"
		)
	)
	private boolean onUpdateResourcePacksRedirectIsCompatible(PackCompatibility compatibility) {
		return true;
	}

	@Redirect(
		method = "loadSelectedResourcePacks",
		at = @At(
			value = "INVOKE",
			ordinal = 0,
			target = "Lnet/minecraft/server/packs/repository/PackCompatibility;isCompatible()Z"
		)
	)
	private boolean onLoadSelectedResourcePacksRedirectIsCompatible(PackCompatibility compatibility) {
		return true;
	}
}
