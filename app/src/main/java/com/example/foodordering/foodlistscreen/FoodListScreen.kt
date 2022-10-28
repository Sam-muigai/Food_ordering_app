package com.example.foodordering.foodlistscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.foodordering.R
import com.example.foodordering.model.FoodIcons
import com.example.foodordering.model.Foods
import com.example.foodordering.model.getFoods
import com.example.foodordering.model.icons
import com.example.foodordering.navigation.MainScreens
import com.example.foodordering.widgets.FoodCard
import com.example.foodordering.widgets.HorizontalFoodCard
import com.example.foodordering.widgets.IconButton


@Composable
fun FoodListScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBarListScreen()
        }
    ) {
        MainContent(navController)
    }
}


@Composable
fun MainContent(navController: NavController) {
    Column(modifier = Modifier.padding(vertical = 20.dp)) {
     FoodIcons(foods = icons)
        RecommendedFood(navController)
        Spacer(modifier = Modifier.height(22.dp))
        HorizontalFoodCard(dummyData){
            navController.navigate(MainScreens.FoodDetailScreen.name + "/${dummyData.id}")
        }
    }
}

val dummyData = getFoods()[(getFoods().size)-1]

@Composable
fun FoodIcons(foods : List<FoodIcons>) {
    Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(horizontal = 20.dp)) {
        Text(text = "Hi, Satya",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold)
        Text(modifier = Modifier.padding(bottom = 8.dp),text = "Want to order delicious food?",
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Light)
        LazyRow (horizontalArrangement = Arrangement.SpaceEvenly){
            items(foods) {
                IconButton(icon = it)
            }
        }
    }
}




@Composable
fun RecommendedFood(navController: NavController) {
    Text(modifier = Modifier.padding(20.dp),
        text = "Recommended",
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.h5)
    FoodList(foods = getFoods().subList(0, (getFoods().size) - 1),
        navController = navController)
}


@Composable
fun FoodList(foods: List<Foods>,navController: NavController) {
    Row {
        LazyRow {
            items(foods) { food ->
                FoodCard(food = food) {
                    navController.navigate(MainScreens.FoodDetailScreen.name + "/${food.id}")
                }
            }
        }
    }
}

@Composable
private fun TopAppBarListScreen() {
    TopAppBar(
        modifier = Modifier,
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    ) {

        Row(Modifier.padding(start = 20.dp, end = 12.dp)) {
            Row(modifier = Modifier.weight(1f)) {
                Icon(
                    modifier = Modifier.size(35.dp),
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription = "menu"
                )
            }
            Icon(modifier = Modifier.size(35.dp),
                painter = painterResource(id = R.drawable.cart),
                contentDescription = "menu"
            )

        }
    }
}







