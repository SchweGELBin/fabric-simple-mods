package com.schwegelbin.simplemods;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

public class Keybinds {
    // Category name in Keybind settings
    public static final String CATEGORY = "Simple Mods";

    // Keybinds
    private static final KeyBinding flyKeybind = new KeyBinding("Toggle Fly",
            GLFW.GLFW_KEY_I, CATEGORY);
    private static final KeyBinding xrayKeybind = new KeyBinding("Toggle XRay",
            GLFW.GLFW_KEY_V, CATEGORY);
    private static final KeyBinding fullbrightKeybind = new KeyBinding("Toggle FullBright",
            GLFW.GLFW_KEY_K, CATEGORY);
    private static final KeyBinding testKeybind = new KeyBinding("Test Key",
            GLFW.GLFW_KEY_APOSTROPHE, CATEGORY);

    // Set keybinds
    public static void registerKeybinds() {
        KeyBindingHelper.registerKeyBinding(flyKeybind);
        KeyBindingHelper.registerKeyBinding(xrayKeybind);
        KeyBindingHelper.registerKeyBinding(fullbrightKeybind);
        KeyBindingHelper.registerKeyBinding(testKeybind);
    }

    // Execute, when pressed
    public static void checkKeybinds(MinecraftClient client) {
        ClientPlayNetworkHandler networkHandler = client.getNetworkHandler();
        if (client.player == null || networkHandler == null) {
            return;
        }

        while (flyKeybind.wasPressed()) {
            Settings.flyEnabled = !Settings.flyEnabled;
            client.player.getAbilities().allowFlying = !client.player.getAbilities().allowFlying;
        }
        while (xrayKeybind.wasPressed()) {
            Settings.xrayEnabled = !Settings.xrayEnabled;
        }

        while (fullbrightKeybind.wasPressed()) {
            if(Settings.fullbrightEnabled) client.options.getGamma().setValue(1.0); //Maximum Brightness
            else client.options.getGamma().setValue(0.5); //Medium Brightness
            Settings.fullbrightEnabled = !Settings.fullbrightEnabled;
        }

        while (testKeybind.wasPressed()) {  // Check if keybind was pressed
            // Test Action
        }
    }
}