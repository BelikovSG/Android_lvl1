package com.example.helloapplication

import com.example.helloapplication.battle.Battle
import com.example.helloapplication.warriors.Team


fun main(){
    val battle : Battle
    val team1 = Team()
    val team2 = Team()
        println("Введите количество участников команд:")

        val members = readLine()?.toIntOrNull()
        println("Начало битвы!")
        members?.let {
            team1.createTeam (members)
            team1.teamMembers.forEach{it.weapon.recharge(it.weapon.createAmmo())}
            team2.createTeam(members)
            team2.teamMembers.forEach{it.weapon.recharge(it.weapon.createAmmo())}
            battle = Battle(team1, team2)
            battle.takeBattleState().printState()
            while (!battle.isOver){
                battle.nextRound()
            }

        }

    }
