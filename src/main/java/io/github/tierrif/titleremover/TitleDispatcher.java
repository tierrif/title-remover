package io.github.tierrif.titleremover;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class TitleDispatcher {
    private Text nextSubTitle;

    public void onSubTitle(Text subTitle) {
        this.nextSubTitle = subTitle;
    }

    public void onTitle(Text title) {
        var chat = MinecraftClient.getInstance().inGameHud.getChatHud();
        chat.addMessage(title);
        if (nextSubTitle != null) chat.addMessage(nextSubTitle);
        nextSubTitle = null;
    }
}
