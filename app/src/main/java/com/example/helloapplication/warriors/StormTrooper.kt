package com.example.helloapplication.warriors

import com.example.helloapplication.base.AbstractWarrior
import com.example.helloapplication.base.Weapons

class StormTrooper : AbstractWarrior(
    800,
    20,
    30,
    Weapons.automaticRifle
){
    override fun takeDamage(damage: Int) {
        curHP -= damage
        if (curHP <= 0) {
            println("StormTrooper was killed!")
        }
    }

    override fun toString(): String {
        return "StormTrooper"
    }

}