package com.demotrix.fooddelivery.utils

fun <T> List<T>.insert(value: T): MutableList<T> = toMutableList().apply {
    add(value)
}

fun <T> List<T>.delete(value: T): MutableList<T> = toMutableList().apply {
    remove(value)
}