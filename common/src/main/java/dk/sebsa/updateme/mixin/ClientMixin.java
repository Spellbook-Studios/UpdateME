package dk.sebsa.updateme.mixin;

import dk.sebsa.updateme.UpdateMEClient;
import dk.sebsa.updateme.client.UpdateMEScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.AlertScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Minecraft.class)
public class ClientMixin {
    @ModifyVariable(at = @At("HEAD"), method = "setScreen", argsOnly = true)
    private Screen showUpdateScreen(Screen variable) {
        if(!UpdateMEClient.screenShown && variable instanceof TitleScreen && UpdateMEClient.needsUpdate) {
            UpdateMEClient.screenShown = true;
            return new UpdateMEScreen(variable);
        }

        return variable;
    }
}
