package com.example.helloapplication.battle


sealed class BattleState {
    abstract fun printState()
    object Progress : BattleState() {
        var team1HP : Int = 0

        var team2HP : Int = 0

        override fun printState(){
            println("Team №1 health is $team1HP, teamMembers №2 health is $team2HP")
        }
    }

    object TeamOneIsWin : BattleState(){
        override fun printState() {
            println("Team one is win!")
        }

    }

    object TeamTwoIsWin : BattleState(){
        override fun printState() {
            println("Team two is win!")
        }
    }

    object Draw : BattleState(){
        override fun printState() {
            println("No one is win!")
        }
    }
}