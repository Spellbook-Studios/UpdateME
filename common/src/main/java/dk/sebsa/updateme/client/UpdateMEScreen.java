package dk.sebsa.updateme.client;

import dk.sebsa.updateme.UpdateMEClient;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

@Environment(EnvType.CLIENT)
public class UpdateMEScreen extends Screen {
    private final Screen parent;

    public UpdateMEScreen(Screen parent) {
        super(Component.literal("Update ME! screen"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        Button buttonIgnore = this.addRenderableWidget(Button.builder(Component.literal("To the main menu"), (button) -> {
            assert this.minecraft != null;
            this.minecraft.setScreen(this.parent);
        }).width(128).build());
        buttonIgnore.setPosition(this.width / 2 - 64, this.height - 60);

        Button buttonQuit = this.addRenderableWidget(Button.builder(Component.translatable("menu.quit"), (button) -> {
            assert this.minecraft != null;
            this.minecraft.stop();
        }).width(128).build());
        buttonQuit.setPosition(this.width / 2 - 64, this.height - 30);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTick);
        guiGraphics.drawCenteredString(this.font, Component.translatable("updateme.screen.title"), width / 2, 20, 0xff0000);
        guiGraphics.drawCenteredString(this.font, Component.translatable("updateme.screen.description"), width / 2, 20+10, 0xffffff);
        guiGraphics.drawCenteredString(this.font, Component.translatable("updateme.screen.version_notice", UpdateMEClient.currVer, UpdateMEClient.newVer), width / 2, 20+20, 0xffffff);

        super.render(guiGraphics, mouseX, mouseY, partialTick);
    }
}
