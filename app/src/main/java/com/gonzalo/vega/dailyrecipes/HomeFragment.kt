package com.gonzalo.vega.dailyrecipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class HomeFragment : Fragment() {
    val spaghetti = Foods(
        "Spaghetti Bologna",
        "Italian spaghetti with red sauce with meatballs",
        arrayOf("Pasta", "Italian"),
        DifficultyEnum.MEDIUM,
        Foods.randomLikes(),
        R.drawable.ic_launcher_background
    )
    val foods = arrayOf(spaghetti,spaghetti,spaghetti,spaghetti,spaghetti,spaghetti)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val linearParent = root.findViewById<LinearLayout>(R.id.linear_parent)

        for(food in foods){
        val newNombre = TextView(context)
        val newLikes = TextView(context)
        val newImg = ImageView(context)
            newNombre.text = food.name
            newLikes.text = food.likes.toString()
            newImg.setImageResource(food.image)

            linearParent.addView(newNombre)
            linearParent.addView(newLikes)
            linearParent.addView(newImg)
        }
        return root
    }

}