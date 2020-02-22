package com.example.helloapplication.battle

import com.example.helloapplication.warriors.Team
import com.example.helloapplication.warriors.preparation

class Battle(
    val team1 : Team,
    val team2 : Team
) {
    var isOver = false
    var state : BattleState = BattleState.Progress
    private var round = 1

    fun takeBattleState() : BattleState{
        var team1HP = 0
        var team2HP = 0
        team1.teamMembers.forEach { if (!it.isKilled) team1HP += it.curHP }
        team2.teamMembers.forEach { if (!it.isKilled) team2HP += it.curHP }
        return when{
        team1HP > 0 && team2HP == 0 ->  BattleState.TeamOneIsWin
        team1HP == 0 && team2HP > 0 ->  BattleState.TeamTwoIsWin
        team1HP > 0 && team2HP > 0 ->  {
            val battleState = BattleState.Progress
            battleState.team1HP = team1HP
            battleState.team2HP = team2HP
            battleState
        }
            else -> BattleState.Draw
        }
    }

    fun nextRound() : Boolean{
        team1.teamMembers.shuffle()
        team1.teamMembers.preparation()
        team2.teamMembers.shuffle()
        team2.teamMembers.preparation()
        while (firefight()){

        }

        println("Round $round is over")
        round++

        state = takeBattleState()

        return when(state){
            BattleState.Progress -> {
                (state as BattleState.Progress).printState()
                isOver = false
                true
            }
            BattleState.Draw -> {
                (state as BattleState.Draw).printState()
                isOver = true
                true
            }
            BattleState.TeamTwoIsWin -> {
                (state as BattleState.TeamTwoIsWin).printState()
                isOver = true
                false
            }
            BattleState.TeamOneIsWin ->{
                (state as BattleState.TeamOneIsWin).printState()
                isOver = true
                false
            }
        }

    }

    private fun firefight() : Boolean {

        val shotingWarrior1 = team1.teamMembers.firstOrNull { it.isReady }
        val shotingWarrior2 = team2.teamMembers.firstOrNull { it.isReady }
        val attackedWarrior1 = team1.teamMembers.firstOrNull { !it.isKilled }
        val attackedWarrior2 = team2.teamMembers.firstOrNull { !it.isKilled }

        if (attackedWarrior1 == null || attackedWarrior2 == null
            || (shotingWarrior1 == null && shotingWarrior2 == null)) return false

        shotingWarrior1?.let {
            println("Warrior $shotingWarrior1 from team №1 attacked $attackedWarrior2")
        }
        shotingWarrior1?.attack(attackedWarrior2)
        shotingWarrior1?.isShot = true
        shotingWarrior1?.isReady = false

        shotingWarrior2?.let {
            println("Warrior $shotingWarrior2 from team №2 attacked $attackedWarrior1")
        }
        shotingWarrior2?.attack(attackedWarrior1)
        shotingWarrior2?.isShot = true
        shotingWarrior2?.isReady = false
        return true

    }

}