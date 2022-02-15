package com.gonzalo.vega.dailyrecipes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spaghetti = Foods(
            "Spaghetti Bologna",
            "Italian spaghetti with red sauce with meatballs",
            arrayOf("Pasta", "Italian"),
            DifficultyEnum.MEDIUM,
            Foods.randomLikes(),
            R.drawable.ic_launcher_background
        )

    }
}