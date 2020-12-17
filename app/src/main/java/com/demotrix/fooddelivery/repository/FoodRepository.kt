package com.demotrix.fooddelivery.repository

import com.demotrix.fooddelivery.payload.Food
import io.reactivex.Single

interface FoodRepository {
    fun getAllFood(): Single<List<Food>>
    fun addToCart(indexOf: Int): Single<Food>
}