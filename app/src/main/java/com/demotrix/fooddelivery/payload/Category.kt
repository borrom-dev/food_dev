package com.demotrix.fooddelivery.payload

class Category(var title: String = "", var id: Int = 0)

fun category(block: Category.() -> Unit): Category = Category().apply(block)