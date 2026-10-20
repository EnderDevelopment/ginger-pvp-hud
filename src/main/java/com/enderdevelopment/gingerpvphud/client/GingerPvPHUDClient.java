package com.enderdevelopment.gingerpvphud.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.TitleScreen;
import com.enderdevelopment.gingerpvphud.GingerPvPHUDMod;

public class GingerPvPHUDClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        GingerPvPHUDMod.LOGGER.info("Initializing Ginger PvP HUD Client");

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null && client.currentScreen instanceof TitleScreen) {
                client.setScreen(new GingerPvPMainMenuScreen());
            }
        });
    }
}