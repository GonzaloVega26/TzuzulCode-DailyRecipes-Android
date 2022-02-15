package com.gonzalo.vega.dailyrecipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val nombrecomida = root.findViewById<TextView>(R.id.nombre_comida)
        nombrecomida.text = spaghetti.name
        val imagen = root.findViewById<ImageView>(R.id.imagencita)
            imagen.setImageResource(spaghetti.image)
        return root
    }

}