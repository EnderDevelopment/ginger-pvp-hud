package com.enderdevelopment.gingerpvphud;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GingerPvPHUDMod implements ModInitializer {
    public static final String MOD_ID = "ginger_pvp_hud";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Ginger PvP HUD");
    }
}