package com.gonzalo.vega.dailyrecipes.model

import kotlin.math.roundToInt

data class Food(
    val name: String,
    val description: String,
    val category: Array<String>,
    val difficulty:Enum<DifficultyEnum>,
    val likes:Int,
    val image: Int
    ) {
    companion object{
        fun randomLikes() : Int = (Math.random() * 100).roundToInt()
    }


}
