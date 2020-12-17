package com.demotrix.fooddelivery.utils

import com.demotrix.fooddelivery.payload.Category
import com.demotrix.fooddelivery.payload.category

val categories: List<Category> = arrayListOf(
    category {
        title = "Pizza"
        id = 1
    },
    category {
        title = "Sushi"
        id = 2
    },
    category {
        title = "Drink"
        id = 3
    }
)