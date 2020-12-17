package com.demotrix.fooddelivery.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.demotrix.fooddelivery.home.FoodFragment
import com.demotrix.fooddelivery.payload.Category

class CategoryPagerAdapter(
    private val foodCategories: List<Category>,
    activity: AppCompatActivity
) :
    FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = foodCategories.size

    override fun createFragment(position: Int): FoodFragment {
        val category: Category = foodCategories[position]
        return FoodFragment.ofCategory(category = category.id)
    }

    fun getTitle(index: Int): String = foodCategories[index].title
}