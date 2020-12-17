package com.demotrix.fooddelivery.home

import com.airbnb.mvrx.*
import com.demotrix.fooddelivery.payload.Food
import com.demotrix.fooddelivery.repository.FoodRepository
import com.demotrix.fooddelivery.utils.delete
import com.demotrix.fooddelivery.utils.insert
import org.koin.android.ext.android.inject

data class FoodState(
    val items: Async<List<Food>> = Uninitialized,
    val cartItems: List<Food> = emptyList()
) : MvRxState

class FoodViewModel(initState: FoodState, private val repository: FoodRepository) :
    BaseMvRxViewModel<FoodState>(initState, BuildConfig.DEBUG) {

    fun addToCart(food: Food) {
        withState { state ->
            if (state.items is Success) {
                setState {
                    copy(cartItems = cartItems.insert(food))
                }
            }
        }
    }

    fun removeFromCart(food: Food) {
        withState { state ->
            if (state.items is Success) {
                setState {
                    copy(cartItems = cartItems.delete(food))
                }
            }
        }
    }

    init {
        repository.getAllFood()
            .doOnSubscribe {
                setState { copy(items = Loading()) }
            }.execute {
                copy(items = Success(it.invoke().orEmpty()))
            }
    }

    companion object : MvRxViewModelFactory<FoodViewModel, FoodState> {
        override fun create(viewModelContext: ViewModelContext, state: FoodState): FoodViewModel? {
            val repository: FoodRepository by viewModelContext.activity.inject()
            return FoodViewModel(state, repository)
        }
    }
}