package com.example.helloapplication.warriors

import com.example.helloapplication.base.AbstractWarrior
import com.example.helloapplication.base.Weapons

class Scout : AbstractWarrior(
    300,
    40,
    40,
    Weapons.tommyGun
){
    override fun takeDamage(damage: Int) {
        curHP -= damage
        if (curHP <= 0) {
            println("Scout was killed!")
        }
    }

    override fun toString(): String {
        return "Scout"
    }

}