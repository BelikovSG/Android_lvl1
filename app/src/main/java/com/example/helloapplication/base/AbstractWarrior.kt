package com.example.helloapplication.base

abstract class AbstractWarrior (
    val maxHP : Int,
    override val dodgeChance : Int,
    val accuracy : Int,
    val weapon : AbstractWeapon

) : Warrior {

    var isShot = false
    var curHP = maxHP
    var isReady: Boolean
        get() = !isShot && !isKilled
        set(value) {}

    override var isKilled: Boolean
        get() = curHP <= 0
        set(value) {}

    override fun attack(enemy: Warrior) {
        if (!weapon.hasAmmo){
            weapon.recharge(weapon.createAmmo())
            return
        }
        val shots = weapon.getAmmo()
        var damage = 0
        for (i in 1 .. shots){
            if (Math.random() < (accuracy/100f) * (1 - enemy.dodgeChance/100f)){
                damage += weapon.createAmmo().calcDamage()
            }
        }
        enemy.takeDamage(damage)
    }
}
