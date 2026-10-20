package com.enderdevelopment.gingerpvphud.client.screen;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import com.enderdevelopment.gingerpvphud.GingerPvPHUDMod;

public class GingerPvPMainMenuScreen extends Screen {
    private static final Identifier SNOW_TEXTURE = new Identifier(GingerPvPHUDMod.MOD_ID, "textures/gui/snow.png");
    private static final Identifier CANDY_TEXTURE = new Identifier(GingerPvPHUDMod.MOD_ID, "textures/gui/candy.png");

    public GingerPvPMainMenuScreen() {
        super(Text.literal("Ginger PvP HUD"));
    }

    @Override
    protected void init() {
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Play"), button -> {
            this.client.setScreen(new TitleScreen());
        }).dimensions(this.width / 2 - 100, this.height / 2 - 24, 200, 20).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // Draw snowy background
        context.drawTexture(SNOW_TEXTURE, 0, 0, 0, 0, this.width, this.height, this.width, this.height);

        // Draw candy rain
        for (int i = 0; i < 100; i++) {
            int x = (int) (Math.random() * this.width);
            int y = (int) (Math.random() * this.height);
            context.drawTexture(CANDY_TEXTURE, x, y, 0, 0, 4, 4, 4, 4);
        }

        super.render(context, mouseX, mouseY, delta);
    }
}