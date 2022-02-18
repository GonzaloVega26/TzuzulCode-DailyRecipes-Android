package com.gonzalo.vega.dailyrecipes.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.gonzalo.vega.dailyrecipes.R
import com.gonzalo.vega.dailyrecipes.model.Food

class FoodAdapter(
   context: Context,
    private val listOfFoods: ArrayList<Food>
) : BaseAdapter() {
    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return listOfFoods.size
    }

    override fun getItem(position: Int): Any {
        return listOfFoods[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val viewRoot = inflater.inflate(R.layout.food_item, parent, false)
        val food = getItem(position) as Food

        viewRoot.findViewById<TextView>(R.id.food_name).text = food.name
        viewRoot.findViewById<ImageView>(R.id.food_image).setImageResource(food.image)
        viewRoot.findViewById<TextView>(R.id.food_likes).text = food.likes.toString()

        return viewRoot
    }
}

