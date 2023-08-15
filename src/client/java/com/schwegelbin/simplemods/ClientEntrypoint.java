package com.schwegelbin.simplemods;

import com.schwegelbin.simplemods.tools.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class ClientEntrypoint implements ClientModInitializer {
    public static final MinecraftClient mc = MinecraftClient.getInstance();

    @Override
    public void onInitializeClient() {
        Keybinds.registerKeybinds();  // Register keybinds
        ClientTickEvents.END_CLIENT_TICK.register(Keybinds::checkKeybinds);  // Register a function to be called every tick
        ClientTickEvents.START_CLIENT_TICK.register(Fly::tick);
    }
}