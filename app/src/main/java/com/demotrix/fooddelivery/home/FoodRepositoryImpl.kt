package com.demotrix.fooddelivery.home

import com.demotrix.fooddelivery.payload.Food
import com.demotrix.fooddelivery.repository.FoodRepository
import io.reactivex.Single

class FoodRepositoryImpl : FoodRepository {
    override fun getAllFood(): Single<List<Food>> {
        TODO("Not yet implemented")
    }

    override fun addToCart(indexOf: Int): Single<Food> {
        TODO("Not yet implemented")
    }

}