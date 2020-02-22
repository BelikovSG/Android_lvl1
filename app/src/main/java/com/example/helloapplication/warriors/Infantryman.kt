package com.example.helloapplication.warriors

import com.example.helloapplication.base.AbstractWarrior
import com.example.helloapplication.base.Weapons

class Infantryman : AbstractWarrior (
    200,
    30,
    60,
    Weapons.rifle
){

    override fun takeDamage(damage: Int) {
        curHP -= damage
        if (curHP <= 0) {
            println("Infantryman was killed!")
        }
    }

    override fun toString(): String {
        return "Infantryman"
    }




}