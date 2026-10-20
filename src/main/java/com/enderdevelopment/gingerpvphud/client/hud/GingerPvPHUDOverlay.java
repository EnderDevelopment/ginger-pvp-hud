package com.enderdevelopment.gingerpvphud.client.hud;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import com.enderdevelopment.gingerpvphud.GingerPvPHUDMod;

public class GingerPvPHUDOverlay implements HudRenderCallback {
    private static final Identifier HUD_TEXTURE = new Identifier(GingerPvPHUDMod.MOD_ID, "textures/gui/hud.png");

    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        PlayerEntity player = client.player;

        if (player != null) {
            int width = client.getWindow().getScaledWidth();
            int height = client.getWindow().getScaledHeight();

            // Draw HUD background
            drawContext.drawTexture(HUD_TEXTURE, width / 2 - 100, height - 50, 0, 0, 200, 50, 200, 50);

            // Draw health
            int health = (int) player.getHealth();
            drawContext.drawText(client.textRenderer, Text.literal("Health: " + health), width / 2 - 90, height - 40, 0xFFFFFF, true);

            // Draw armor
            int armor = player.getArmor();
            drawContext.drawText(client.textRenderer, Text.literal("Armor: " + armor), width / 2 - 90, height - 30, 0xFFFFFF, true);

            // Draw coordinates
            int x = (int) player.getX();
            int y = (int) player.getY();
            int z = (int) player.getZ();
            drawContext.drawText(client.textRenderer, Text.literal("X: " + x + " Y: " + y + " Z: " + z), width / 2 - 90, height - 20, 0xFFFFFF, true);
        }
    }
}