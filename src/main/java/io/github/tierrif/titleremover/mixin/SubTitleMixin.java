package io.github.tierrif.titleremover.mixin;

import io.github.tierrif.titleremover.TitleRemoverMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class SubTitleMixin {
    @Inject(at = @At("HEAD"), method = "setSubtitle", cancellable = true)
    public void push(Text subTitle, CallbackInfo info) {
        TitleRemoverMod.getInstance().getTitleDispatcher().onSubTitle(subTitle);
        info.cancel();
    }
}
