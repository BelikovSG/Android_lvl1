package com.example.helloapplication.warriors

import com.example.helloapplication.base.AbstractWarrior
import com.example.helloapplication.base.Weapons

class MachineGunner : AbstractWarrior(
    1000,
    10,
    30,
    Weapons.machineGun
){
    override fun takeDamage(damage: Int) {
        curHP -= damage
        if (curHP <= 0) {
            println("MachineGunner was killed!")
        }
    }

    override fun toString(): String {
        return "MachineGunner"
    }

}