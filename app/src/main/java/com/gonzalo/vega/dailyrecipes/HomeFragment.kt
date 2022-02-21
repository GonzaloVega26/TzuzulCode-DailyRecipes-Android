package com.gonzalo.vega.dailyrecipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.gonzalo.vega.dailyrecipes.adapters.FoodAdapter

import com.gonzalo.vega.dailyrecipes.datasource.DataSource
import com.gonzalo.vega.dailyrecipes.model.Food

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val context = container!!.context
        val root = inflater.inflate(R.layout.fragment_home, container, false)


        val listOfFoods = DataSource.listOfFoods
        val listView = root.findViewById<ListView>(R.id.list_view)
        val adapter = FoodAdapter(context, orderFoodList(listOfFoods))

        listView.adapter = adapter

        val refreshButton = root.findViewById<Button>(R.id.refresh_button)
        refreshButton.setOnClickListener{
            adapter.notifyDataSetChanged()
            adapter.notifyDataSetInvalidated()
        }

        return root
    }

    fun orderFoodList(foodsArray:ArrayList<Food>):ArrayList<Food>{
        val likesComparator = Comparator { food1: Food, food2: Food -> food2.likes - food1.likes }
        foodsArray.sortWith(likesComparator)

        return foodsArray
    }


}
