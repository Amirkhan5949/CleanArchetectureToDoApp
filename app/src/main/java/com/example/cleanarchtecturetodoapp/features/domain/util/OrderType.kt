package com.example.cleanarchtecturetodoapp.features.domain.util

sealed class OrderType{
    object Ascending : OrderType()
    object Decending : OrderType()
}
