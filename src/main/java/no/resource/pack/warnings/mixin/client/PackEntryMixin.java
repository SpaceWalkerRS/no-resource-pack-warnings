package no.resource.pack.warnings.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.client.gui.screens.packs.TransferableSelectionList.PackEntry;
import net.minecraft.server.packs.repository.PackCompatibility;

@Mixin(PackEntry.class)
public class PackEntryMixin {

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
