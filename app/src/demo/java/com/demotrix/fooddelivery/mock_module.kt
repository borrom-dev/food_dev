package com.demotrix.fooddelivery

import com.demotrix.fooddelivery.mock.MockFoodRepository
import com.demotrix.fooddelivery.repository.FoodRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val mockModule: Module = module {
    single<FoodRepository> {
        MockFoodRepository()
    }
}