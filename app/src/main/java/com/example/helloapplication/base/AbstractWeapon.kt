package com.example.helloapplication.base

abstract class AbstractWeapon (
    val maxAmmo : Int,
    val fireType : FireType
){

    var curAmmo = mutableListOf<Ammo>()
    var hasAmmo : Boolean = true

    abstract fun createAmmo() : Ammo

    fun recharge(ammo: Ammo){
        for (i in 1 .. maxAmmo){
            curAmmo.add(i-1, Ammo.valueOf(ammo.name))
            hasAmmo = true
        }
    }

    fun getAmmo() : Int {
        for (i in 1 .. fireType.shotQuantity){
            curAmmo.removeAt(curAmmo.size-1)
            if (curAmmo.isEmpty()) hasAmmo = false
        }
        return fireType.shotQuantity
    }
}