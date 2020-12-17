package com.demotrix.fooddelivery.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demotrix.fooddelivery.R
import com.demotrix.fooddelivery.databinding.CartItemViewBinding
import com.demotrix.fooddelivery.payload.Food

typealias RemoveFromCart = (food: Food) -> Unit

class CheckoutAdapter(
    private var foods: MutableList<Food> = arrayListOf(),
    val removeFromCart: RemoveFromCart
) :
    RecyclerView.Adapter<CheckoutAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).run {
            inflate(R.layout.cart_item_view, parent, false)
        }
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = foods.size

    fun notifyDataSet(data: List<Food>) {
        foods.clear()
        foods.addAll(data)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food: Food = foods[position]
        holder.bind(food)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding: CartItemViewBinding = CartItemViewBinding.bind(view)

        fun bind(food: Food) {
            with(binding) {
                thumbnail.setImageResource(food.featureUrl)
                txtTitle.text = food.name
                txtPrice.text = "USD ${food.price}"
                btnRemove.setOnClickListener {
                    removeFromCart(food)
                }
            }
        }

    }
}