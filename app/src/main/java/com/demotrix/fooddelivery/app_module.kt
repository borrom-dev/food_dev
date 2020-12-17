package com.demotrix.fooddelivery

import com.demotrix.fooddelivery.home.FoodRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module = module {
    single {
        FoodRepositoryImpl()
    }
}
