package dk.sebsa.updateme.forge;

import dk.sebsa.updateme.UpdateMEClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import static dk.sebsa.updateme.forge.UpdateMEForge.MOD_ID;

@Mod(MOD_ID)
public class UpdateMEForge {
    public static final String MOD_ID = "updateme";

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)  {
            UpdateMEClient.init();
        }
    }
}