package io.github.tierrif.titleremover.mixin;

import io.github.tierrif.titleremover.TitleRemoverMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.network.packet.s2c.play.TitleFadeS2CPacket;
import net.minecraft.text.Text;
import net.minecraft.util.profiler.DummyProfiler;
import net.minecraft.util.profiler.ProfilerSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class TitleMixin {
    @Inject(at = @At("HEAD"), method = "setTitle", cancellable = true)
    public void push(Text title, CallbackInfo info) {
        TitleRemoverMod.getInstance().getTitleDispatcher().onTitle(title);
        info.cancel();
    }
}
