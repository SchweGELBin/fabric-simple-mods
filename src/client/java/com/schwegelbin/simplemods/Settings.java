package com.schwegelbin.simplemods;

import net.minecraft.client.MinecraftClient;

public class Settings {
    public static MinecraftClient client = ClientEntrypoint.mc;
    // Variables
    public static boolean flyEnabled = false;
    public static boolean xrayEnabled = false;
    public static boolean fullbrightEnabled = false; // Maximum for 1.19+ is 1.0

    public static void registerSettings(){
        // Register Settings
    }
}