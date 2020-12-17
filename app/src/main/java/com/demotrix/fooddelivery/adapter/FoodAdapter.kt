package com.demotrix.fooddelivery.adapter

import android.animation.Animator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.demotrix.fooddelivery.R
import com.demotrix.fooddelivery.databinding.FoodItemsViewBinding
import com.demotrix.fooddelivery.payload.Food
import com.demotrix.fooddelivery.utils.doCheckout

typealias onClickAddToCart = (food: Food) -> Unit

class FoodAdapter(
    private val _foods: MutableList<Food> = arrayListOf(),
    private val onClickAddToCart: onClickAddToCart
) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        return inflater.inflate(R.layout.food_items_view, parent, false).run {
            FoodViewHolder(this)
        }
    }

    fun updateDataSet(foods: List<Food>) {
        _foods.clear()
        _foods.addAll(foods)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = _foods.size

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food: Food = _foods[position]
        with(holder.binding) {
            txtTitle.text = food.name
            imgFood.setImageResource(food.featureUrl)
            txtShortDesc.text = food.shortDescription
            txtDesc.text = food.description
            with(btnPrice) {
                setOnClickListener {
                    doCheckout {
                        onClickAddToCart.invoke(food)
                    }
                }
            }
        }
    }

    inner class FoodViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val binding: FoodItemsViewBinding = FoodItemsViewBinding.bind(view)
    }

}