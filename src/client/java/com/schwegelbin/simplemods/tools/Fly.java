package com.schwegelbin.simplemods.tools;

import com.schwegelbin.simplemods.Keybinds;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class Fly {

    public static boolean forceAntiFly = false;
    public static double oldY = 0;
    public static int floatingTickCount = 0;

    public static void tick(MinecraftClient client) {
        if(!Keybinds.flyEnabled || client.player == null) return;

        if (client.player.getPos().getY() >= oldY - 0.0433D) {
            floatingTickCount += 1;
        }

        oldY = client.player.getPos().getY();

        Vec3d posBelow = client.player.getPos().subtract(0.0, 0.0433D, 0.0);
        Vec3i roundedPos = new Vec3i((int)posBelow.getX(),(int)posBelow.getY(),(int)posBelow.getZ());

        if ((floatingTickCount > 20 || forceAntiFly)
                && client.player.clientWorld.getBlockState(new BlockPos(roundedPos)).isAir()){
            PacketHelper.sendPosition(posBelow);
            PacketHelper.sendPosition(posBelow.add(0.0, 0.0433D, 0.0));

            forceAntiFly = false;
            floatingTickCount = 0;
        }
    }
}