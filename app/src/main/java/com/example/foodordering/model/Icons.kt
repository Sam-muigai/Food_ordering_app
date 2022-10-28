package com.example.foodordering.model

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import com.example.foodordering.R

data class FoodIcons(val icon:Int)

val icons: List<FoodIcons> = listOf(
    FoodIcons(R.drawable.img_1),
    FoodIcons(R.drawable.img_2),
    FoodIcons(R.drawable.img_3)
)