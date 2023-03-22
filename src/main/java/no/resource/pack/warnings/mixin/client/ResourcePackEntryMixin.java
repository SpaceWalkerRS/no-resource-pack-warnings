package no.resource.pack.warnings.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.client.gui.screens.resourcepacks.lists.ResourcePackList.ResourcePackEntry;
import net.minecraft.server.packs.repository.PackCompatibility;

@Mixin(ResourcePackEntry.class)
public class ResourcePackEntryMixin {

	@Redirect(
		method = "render",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/server/packs/repository/PackCompatibility;isCompatible()Z"
		)
	)
	private boolean onRenderRedirectIsCompatible(PackCompatibility compatibility) {
		return true;
	}

	@Redirect(
		method = "mouseClicked",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/server/packs/repository/PackCompatibility;isCompatible()Z"
		)
	)
	private boolean onMouseClickedRedirectIsCompatible(PackCompatibility compatibility) {
		return true;
	}
}
