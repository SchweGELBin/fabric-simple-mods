package com.schwegelbin.simplemods;

import com.schwegelbin.simplemods.tools.*;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import org.lwjgl.glfw.GLFW;

public class Keybinds {
    public static final String CATEGORY = "Simple Mods";
    public static boolean flyEnabled = false;

    private static final KeyBinding flyKeybind = new KeyBinding("Toggle Fly",
            GLFW.GLFW_KEY_I, CATEGORY);  // Up arrow key

    public static void registerKeybinds() {  // Make keybinds show up in settings
        KeyBindingHelper.registerKeyBinding(flyKeybind);
    }

    public static void checkKeybinds(MinecraftClient client) {
        ClientPlayNetworkHandler networkHandler = client.getNetworkHandler();
        if (client.player == null || networkHandler == null) {
            return;
        }
        while (flyKeybind.wasPressed()) {  // Check if keybind was pressed
            flyEnabled = !flyEnabled;
            //client.player.getAbilities().allowFlying = !client.player.getAbilities().allowFlying;
        }
    }
}