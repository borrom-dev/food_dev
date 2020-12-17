package com.demotrix.fooddelivery.payload

data class Food(
    var name: String = "",
    var description: String = "",
    var shortDescription: String = "",
    var featureUrl: Int = 0,
    var categoryId: Int = 0,
    var inCartCount: Int = 0,
    var price: Double = 200.0
)

fun food(block: Food.() -> Unit): Food = Food().apply(block)
