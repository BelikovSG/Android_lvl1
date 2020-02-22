package com.example.helloapplication.base

import kotlin.random.Random

enum class Ammo(
    val damage : Int,
    val critChance : Int,
    val critRate : Int
) {

    LARGE(100, 10, 2),
    MEDIUM(50, 20, 3),
    SMALL(20, 30, 5);

    fun calcDamage() : Int {
        return if (Random.nextInt(100) <= critChance) damage * critRate
        else damage
    }
}