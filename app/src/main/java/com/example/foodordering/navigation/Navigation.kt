package com.example.foodordering.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.foodordering.fooddetailscreen.FoodDetailScreen
import com.example.foodordering.foodlistscreen.FoodListScreen


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = MainScreens.FoodListScreen.name){
        composable(MainScreens.FoodListScreen.name){
            FoodListScreen(navController = navController)
        }
        composable(MainScreens.FoodDetailScreen.name +"/{food}",
            arguments = listOf(navArgument("food"){
            type = NavType.StringType
        })){ backStackEntry ->
            FoodDetailScreen(navController = navController,
                backStackEntry.arguments?.getString("food").toString())
        }
    }

}