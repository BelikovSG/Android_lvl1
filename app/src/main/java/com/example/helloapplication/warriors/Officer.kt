package com.example.helloapplication.warriors

import com.example.helloapplication.base.AbstractWarrior
import com.example.helloapplication.base.Weapons

class Officer : AbstractWarrior(
    1000,
    60,
    60,
    Weapons.pistol
){
    override fun takeDamage(damage: Int) {
        curHP -= damage
        if (curHP <= 0) {
            println("Officer was killed!")
        }
    }

    override fun toString(): String {
        return "Officer"
    }

}