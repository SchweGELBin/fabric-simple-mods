package com.schwegelbin.simplemods.tools;

import com.schwegelbin.simplemods.ClientEntrypoint;
import com.schwegelbin.simplemods.mixin.client.ClientConnectionInvoker;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.listener.ServerPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.util.math.Vec3d;

public class PacketHelper {

    // Send Position Immediately (Without any notice in game)
    public static void sendPosition(Vec3d pos){
        MinecraftClient client = ClientEntrypoint.mc;
        assert client.player != null;
        ClientConnectionInvoker conn = (ClientConnectionInvoker)client.player.networkHandler.getConnection();
        pos = PacketHelper.fixCoords(pos);
        Packet<ServerPlayPacketListener> packet = new PlayerMoveC2SPacket.PositionAndOnGround(pos.getX(), pos.getY(), pos.getZ(), false);
        conn.sendPIm(packet, null);
    }

    // Round Coordinates
    public static Vec3d fixCoords(Vec3d pos){
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getY();

        x = roundCoordinate(x);
        y = roundCoordinate(y);
        z = roundCoordinate(z);

        return new Vec3d(x, y, z);
    }

    // Utility for fixCoords
    public static double roundCoordinate(double n) {
        n = Math.round(n * 100) / 100d;
        return Math.nextAfter(n, n + Math.signum(n));
    }
}
