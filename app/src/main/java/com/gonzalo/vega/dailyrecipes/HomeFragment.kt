package com.gonzalo.vega.dailyrecipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.gonzalo.vega.dailyrecipes.adapters.FoodAdapter

import com.gonzalo.vega.dailyrecipes.datasource.DataSource

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val context = container!!.context
        val root = inflater.inflate(R.layout.fragment_home, container, false)


        val listOfFoods = DataSource.listOfFoods
        val listView = root.findViewById<ListView>(R.id.list_view)
        val adapter = FoodAdapter(context, listOfFoods)

        listView.adapter = adapter

        return root
    }


}
