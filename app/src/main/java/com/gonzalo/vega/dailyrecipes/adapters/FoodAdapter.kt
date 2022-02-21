package com.gonzalo.vega.dailyrecipes.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.*
import android.widget.*
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import com.gonzalo.vega.dailyrecipes.HomeFragmentDirections
import com.gonzalo.vega.dailyrecipes.R
import com.gonzalo.vega.dailyrecipes.model.Food

class FoodAdapter(
   private val context: Context,
    private val listOfFoods: ArrayList<Food>
) : BaseAdapter() {
    //UI elements


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
        viewRoot.findViewById<ImageView>(R.id.food_image_button).setImageResource(food.image)
        viewRoot.findViewById<TextView>(R.id.food_likes_name).text = "Published By " + context.resources.getStringArray(R.array.chefs).asList().random().toString()
        val likes = viewRoot.findViewById<TextView>(R.id.food_likes)
        val heartLike = viewRoot.findViewById<ImageView>(R.id.heart_like)
        likes.text = food.likes.toString()
        changeLikeIcon(food,heartLike)

        val likeButton = viewRoot.findViewById<ImageButton>(R.id.food_image_button)
        likeButton.setOnLongClickListener{
            giveLike(food,likes,heartLike)
        }

        likeButton.setOnClickListener{
            val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(food.id)
            viewRoot.findNavController().navigate(action)
            notifyDataSetChanged()
        }


        return viewRoot
    }

    private fun giveLike(food: Food, textView : TextView, heart:ImageView): Boolean {
        if(food.isLiked){
            notifyDataSetInvalidated()
            food.likes--
            food.isLiked = false
            heart.setImageResource(R.drawable.heart)
            Toast.makeText(context,"FOOD DISLIKED",Toast.LENGTH_SHORT).show()
        }else{
            food.likes++
            food.isLiked = true
            heart.setImageResource(R.drawable.heart_egg)

        Toast.makeText(context,"FOOD LIKED",Toast.LENGTH_SHORT).show()
        }
        //notifyDataSetChanged()
        textView.text = food.likes.toString()
        return true
    }

    private fun changeLikeIcon(food: Food, icon: ImageView){
        if(food.isLiked) icon.setImageResource(R.drawable.heart_egg)
        else icon.setImageResource(R.drawable.heart)
    }
}


