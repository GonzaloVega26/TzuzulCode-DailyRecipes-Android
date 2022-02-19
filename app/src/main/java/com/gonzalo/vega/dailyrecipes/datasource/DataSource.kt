package com.gonzalo.vega.dailyrecipes.datasource

import com.gonzalo.vega.dailyrecipes.model.DifficultyEnum
import com.gonzalo.vega.dailyrecipes.R
import com.gonzalo.vega.dailyrecipes.model.Food


class DataSource {



    companion object{
        fun generatesFoods(): ArrayList<Food> {
            val spaghettiBologna = Food(
                0,
                "Spaghetti Bologna",
                "Description",
                arrayOf("Pasta", "Italian"),
                DifficultyEnum.MEDIUM,
                Food.randomLikes(),
                R.drawable.anyconv_com__spaghetti_bologna
            )
            val spaghettiPesto = Food(
                1,
                "Spaghetti Bologna",
                "Description",
                arrayOf("Pasta", "Italian"),
                DifficultyEnum.MEDIUM,
                Food.randomLikes(),
                R.drawable.anyconv_com__spaghetti_pesto
            )
            val hamburguer = Food(
                2,
                "Hamburguer",
                "Description",
                arrayOf("FastFood"),
                DifficultyEnum.EASY,
                Food.randomLikes(),
                R.drawable.anyconv_com__hamburguer
            )
            val pizza = Food(
                3,
                "Pizza",
                "Description",
                arrayOf("FastFood", "Italian"),
                DifficultyEnum.MEDIUM,
                Food.randomLikes(),
                R.drawable.anyconv_com__pizza
            )

            val bennedictEggs = Food(
                4,
                "Bennedict Eggs",
                "Description",
                arrayOf("Breakfast", "Fancy"),
                DifficultyEnum.HARD,
                Food.randomLikes(),
                R.drawable.anyconv_com__bennedict_eggs
            )
            val applePie = Food(
                5,
                "Apple Pie",
                "Description",
                arrayOf("Dessert", "Sweet", "Fruty"),
                DifficultyEnum.EASY,
                Food.randomLikes(),
                R.drawable.anyconv_com__apple_pie
            )
            val barbecue =  Food(
                6,
                "Barbecue",
                "Description",
                arrayOf("Meat", "Smoke"),
                DifficultyEnum.HARD,
                Food.randomLikes(),
                R.drawable.anyconv_com__barbecue
            )
            val frenchToast = Food(
                7,
                "Bennedict Eggs",
                "Description",
                arrayOf("Breakfast", "Fancy"),
                DifficultyEnum.EASY,
                Food.randomLikes(),
                R.drawable.anyconv_com__french_toast
            )
            val paella = Food(
                8,
                "Bennedict Eggs",
                "Description",
                arrayOf("Spanish", "SeaFood"),
                DifficultyEnum.MEDIUM,
                Food.randomLikes(),
                R.drawable.anyconv_com__paella
            )
            val chocolateSouffle = Food(
                9,
                "Souffle au Chocolate",
                "Description",
                arrayOf("Dessert", "French"),
                DifficultyEnum.PRO,
                Food.randomLikes(),
                R.drawable.anyconv_com__chocolate_souffle
            )
            val foodsArray = arrayListOf(
                spaghettiBologna, spaghettiPesto, hamburguer, pizza,
                chocolateSouffle, bennedictEggs, applePie, barbecue, frenchToast, paella
            )
            val likesComparator = Comparator { food1: Food, food2: Food -> food2.likes - food1.likes }
            foodsArray.sortWith(likesComparator)



            return foodsArray
        }
        val listOfFoods = generatesFoods()

    }

}