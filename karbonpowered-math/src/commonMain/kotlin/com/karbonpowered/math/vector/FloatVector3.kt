package com.karbonpowered.math.vector

open class FloatVector3(
    override val x: Float = 0f,
    override val y: Float = 0f,
    open val z: Float = 0f
) : FloatVector2(x, y) {
    override fun toString(): String = "($x, $y, $z)"

    override fun toArray(): FloatArray = floatArrayOf(x, y, z)
}

fun floatVector3of(x: Float = 0f, y: Float = 0f, z: Float = 0f): FloatVector3 = FloatVector3(x, y, z)