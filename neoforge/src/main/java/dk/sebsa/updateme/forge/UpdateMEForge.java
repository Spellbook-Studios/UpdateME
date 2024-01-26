package dk.sebsa.updateme.forge;

import dev.architectury.platform.forge.EventBuses;
import dk.sebsa.updateme.UpdateME;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(UpdateME_.MOD_ID)
public class UpdateMEForge {
    public UpdateME_Forge() {
		// Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(UpdateME_.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        UpdateME_.init();
    }
}