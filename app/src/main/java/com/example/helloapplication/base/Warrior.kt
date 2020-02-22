package com.example.helloapplication.base

interface Warrior {
    var isKilled : Boolean
    val dodgeChance : Int
    fun attack(enemy : Warrior)
    fun takeDamage(damage : Int)
}