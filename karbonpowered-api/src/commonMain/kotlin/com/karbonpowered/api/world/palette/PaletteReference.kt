package com.karbonpowered.api.world.palette

import com.karbonpowered.api.registry.RegistryHolder
import com.karbonpowered.api.registry.RegistryType
import com.karbonpowered.api.registry.factory

interface PaletteReference<T, R> {
    val registry: RegistryType<R>

    val value: String

    fun resolve(holder: RegistryHolder, type: PaletteType<T, R>): T? =
            type.resolver(value, holder.registry(registry))

    companion object {
        operator fun <T, R> get(registryType: RegistryType<R>, value: String): PaletteReference<T, R> {
            require(value.isNotEmpty())
            return factory<Factory>().create(registryType, value)
        }
    }

    interface Factory {
        fun <T, R> create(type: RegistryType<R>, value: String): PaletteReference<T, R>
    }
}