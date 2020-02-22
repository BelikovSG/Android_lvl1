package com.example.helloapplication.base

object Weapons {
    val pistol = object : AbstractWeapon(8, FireType.SingleFire){
        override fun createAmmo(): Ammo {
            return Ammo.SMALL
        }
    }

    val tommyGun = object : AbstractWeapon(20, FireType.MultiFire){
        override fun createAmmo(): Ammo {
            return Ammo.SMALL
        }
    }

    val rifle = object : AbstractWeapon(10, FireType.SingleFire){
        override fun createAmmo(): Ammo {
            return Ammo.MEDIUM
        }
    }

    val automaticRifle = object : AbstractWeapon(30, FireType.MultiFire){
        override fun createAmmo(): Ammo {
            return Ammo.MEDIUM
        }
    }

    val machineGun = object : AbstractWeapon(50, FireType.MultiFire){
        override fun createAmmo(): Ammo {
            return Ammo.LARGE
        }
    }

    val sniperRifle = object : AbstractWeapon(10, FireType.SingleFire){
        override fun createAmmo(): Ammo {
            return Ammo.LARGE
        }
    }


}