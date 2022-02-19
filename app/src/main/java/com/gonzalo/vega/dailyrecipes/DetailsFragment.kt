package com.gonzalo.vega.dailyrecipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.gonzalo.vega.dailyrecipes.datasource.DataSource

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_details, container, false)
        val bundle = DetailsFragmentArgs.fromBundle(requireArguments())
        val listOfFood = DataSource.generatesFoods()
        listOfFood.first{it.id == bundle.foodId}

        val food = listOfFood.first{it.id == bundle.foodId}

        rootView.findViewById<TextView>(R.id.food_name_card).text = food.name + " " + food.likes.toString()
        rootView.findViewById<ImageView>(R.id.food_image_card).setImageResource(food.image)

        return  rootView
    }


}