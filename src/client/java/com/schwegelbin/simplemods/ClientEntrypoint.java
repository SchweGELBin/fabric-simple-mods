package com.schwegelbin.simplemods;

import com.schwegelbin.simplemods.tools.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

// Entrypoint / Default Class for Client sided mods
public class ClientEntrypoint implements ClientModInitializer {
    // Minecraft client
    public static final MinecraftClient mc = MinecraftClient.getInstance();

    @Override
    public void onInitializeClient() {
        Keybinds.registerKeybinds();  // Register keybinds
        // Run every tick
        ClientTickEvents.END_CLIENT_TICK.register(Keybinds::checkKeybinds);
        ClientTickEvents.START_CLIENT_TICK.register(Fly::tick);
    }
}