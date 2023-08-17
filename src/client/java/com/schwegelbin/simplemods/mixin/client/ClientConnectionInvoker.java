package com.schwegelbin.simplemods.mixin.client;

import net.minecraft.network.ClientConnection;
import net.minecraft.network.PacketCallbacks;
import net.minecraft.network.packet.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ClientConnection.class)
public interface ClientConnectionInvoker {
    @Invoker("sendImmediately")
    public void sendIm(Packet<?> packet, PacketCallbacks callbacks);
}
