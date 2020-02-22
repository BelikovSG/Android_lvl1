package com.example.helloapplication.base

sealed class FireType(
    val shotQuantity : Int
) {
    object SingleFire : FireType(1)
    object MultiFire : FireType(5)

}