package com.example.foodordering.fooddetailscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.ImagePainter.State.Empty.painter
import coil.compose.rememberImagePainter
import com.example.foodordering.R
import com.example.foodordering.model.Foods
import com.example.foodordering.model.getFoods

@Composable
fun FoodDetailScreen(navController: NavController,id:String) {

    val foods = getFoods().filter { food ->
        food.id == id
    }
    val selectedFood = foods[0]
   Scaffold (topBar = {
       TopBar(){
           navController.popBackStack()
       }
   }){
       MainContent(selectedFood)
   }

}


@Composable
fun MainContent(food:Foods) {
    Column(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top) {
        Image(modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)
            .clip(shape = RoundedCornerShape(corner = CornerSize(9.dp))),
            contentScale = ContentScale.Crop,
            painter = rememberImagePainter(data = food.image, builder = {
                crossfade(true)
            }),
            contentDescription = "selected Food")
        Spacer(modifier = Modifier.height(12.dp))
        Column (modifier = Modifier.padding(horizontal = 10.dp)){
            Row {
                Text(
                    text = food.title,
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier.align(alignment = CenterVertically),
                    text = food.min,
                    style = MaterialTheme.typography.caption
                )
            }
            Text(
                text = "Details",
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = food.details,
                style = MaterialTheme.typography.body1
            )
            Row {
                Text(
                    text = food.amount,
                    modifier = Modifier
                        .weight(1f)
                        .align(alignment = CenterVertically),
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.Bold
                )
                Button(modifier = Modifier.padding(),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                    onClick = {}) {
                    Row(
                        modifier = Modifier.padding(top = 7.dp, bottom = 7.dp, start = 4.dp)
                    ) {
                        Text("Add to Cart", color = Color.White)
                        Icon(
                            modifier = Modifier,
                            painter = painterResource(id = R.drawable.ic_add),
                            contentDescription = "Add to Cart"
                        )
                    }
                }
            }
        }

    }

}


@Composable
private fun TopBar(onClick:() ->Unit) {
    TopAppBar(elevation = 0.dp, backgroundColor = Color.Transparent) {
        Row(modifier = Modifier.padding(horizontal = 20.dp)) {
            Row(modifier = Modifier.weight(1f)) {
                Icon(
                    modifier = Modifier
                        .size(35.dp)
                        .clickable { onClick() },
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "back"
                )
            }
            Icon(
                modifier = Modifier.size(35.dp),
                painter = painterResource(id = R.drawable.ic_more),
                contentDescription = "more"
            )
        }
    }
}

