package dk.sebsa.updateme.fabric;

import dk.sebsa.updateme.UpdateMEClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

public class UpdateMEClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        UpdateMEClient.init();
    }
}