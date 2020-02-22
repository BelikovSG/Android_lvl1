package com.example.helloapplication.warriors

import com.example.helloapplication.base.AbstractWarrior
import com.example.helloapplication.base.Weapons

class Sniper : AbstractWarrior(
    800,
    60,
    95,
    Weapons.sniperRifle
){

    override fun takeDamage(damage: Int) {
        curHP -= damage
        if (curHP <= 0) {
            println("Sniper was killed!")
        }
    }

    override fun toString(): String {
        return "Sniper"
    }

}