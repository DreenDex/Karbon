package com.karbonpowered.server

import com.karbonpowered.server.event.SessionEvent
import com.karbonpowered.server.event.SessionListener
import com.karbonpowered.server.packet.Packet
import com.karbonpowered.server.packet.PacketProtocol
import kotlinx.coroutines.CoroutineScope

interface Session : CoroutineScope {
    val isConnected: Boolean
    val packetProtocol: PacketProtocol
    val listeners: Collection<SessionListener>

    fun addListener(listener: SessionListener)
    fun removeListener(listener: SessionListener)
    fun send(packet: Packet)
    fun disconnect(reason: String? = null, cause: Throwable? = null)
    fun callEvent(event: SessionEvent)
    fun exceptionCaught(cause: Throwable)
}