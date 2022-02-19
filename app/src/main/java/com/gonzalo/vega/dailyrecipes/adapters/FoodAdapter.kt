package com.gonzalo.vega.dailyrecipes.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.*
import android.widget.*
import androidx.navigation.findNavController
import com.gonzalo.vega.dailyrecipes.HomeFragment
import com.gonzalo.vega.dailyrecipes.HomeFragmentDirections
import com.gonzalo.vega.dailyrecipes.R
import com.gonzalo.vega.dailyrecipes.model.Food

class FoodAdapter(
   private val context: Context,
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
        val likes = viewRoot.findViewById<TextView>(R.id.food_likes)

        likes.text = food.likes.toString()

        val likeButton = viewRoot.findViewById<Button>(R.id.test_button)
        likeButton.setOnLongClickListener{
            giveLike(food,likes)
        }

        likeButton.setOnClickListener{
            val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(food.id)
            viewRoot.findNavController().navigate(action)

        }


        return viewRoot
    }

    private fun giveLike(food: Food, textView : TextView): Boolean {
        if(food.isLiked){
            food.likes--
            food.isLiked = false
            Toast.makeText(context,"FOOD DISLIKED",Toast.LENGTH_LONG).show()
        }else{
            food.likes++
            food.isLiked = true
        Toast.makeText(context,"FOOD LIKED",Toast.LENGTH_LONG).show()
        }

        textView.text = food.likes.toString()
        return true
    }
}


