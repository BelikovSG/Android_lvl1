package com.example.helloapplication.warriors

import com.example.helloapplication.base.AbstractWarrior

class Team {
    val teamMembers = mutableListOf<AbstractWarrior>()

    fun createTeam(quantity : Int){
        for (i in 1 .. quantity){
            teamMembers.add(createWarrior())
        }
    }

    private fun createWarrior(): AbstractWarrior {
        val d = Math.random()
        return when{
            d < 0.35 -> Infantryman()
            d < 0.45 -> MachineGunner()
            d < 0.65 -> Scout()
            d < 0.75 -> Sniper()
            d < 0.95 -> StormTrooper()
            else -> Officer()
        }
    }
}

fun List<AbstractWarrior>.preparation(){
    forEach{
        it.isShot = false
    }

}