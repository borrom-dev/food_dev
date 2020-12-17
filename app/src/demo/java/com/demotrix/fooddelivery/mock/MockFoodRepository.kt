package com.demotrix.fooddelivery.mock

import com.demotrix.fooddelivery.payload.Food
import com.demotrix.fooddelivery.repository.FoodRepository
import com.demotrix.fooddelivery.utils.foods
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class MockFoodRepository : FoodRepository {

    override fun getAllFood(): Single<List<Food>> {
        return Single.just(foods)
            .delay(100, TimeUnit.MICROSECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun addToCart(indexOf: Int): Single<Food> {
        return Single.fromCallable {
            foods[indexOf].apply {
                inCartCount += 1
            }
        }
    }
}