package com.example.androiddevchallenge.ui

import androidx.annotation.DrawableRes

data class Cat(
    val id :Int,
    @DrawableRes val image: Int,
    val name: String,
    val description: String
)
