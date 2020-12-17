package com.demotrix.fooddelivery

import androidx.multidex.MultiDexApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class FoodDeliveryApp : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@FoodDeliveryApp)
            when (BuildConfig.FLAVOR) {
                DEMO -> {
                    modules(mockModule)
                }
                else -> {
                    modules(appModule)
                }
            }
        }
    }

    companion object {
        const val DEMO = "demo"
    }
}