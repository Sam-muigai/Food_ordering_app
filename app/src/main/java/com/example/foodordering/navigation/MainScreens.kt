package com.example.foodordering.navigation



enum class MainScreens {
    FoodListScreen,
    FoodDetailScreen;
    companion object{
        fun getRoute(route: String?):MainScreens{
            return when(route?.substringBefore(delimiter = "/")){
                FoodListScreen.name -> FoodListScreen
                FoodDetailScreen.name ->FoodDetailScreen
                null ->FoodListScreen
                else -> throw IllegalArgumentException("route not found")
            }
        }
    }
}