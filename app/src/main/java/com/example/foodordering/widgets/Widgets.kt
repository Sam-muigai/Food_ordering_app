package com.example.foodordering.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.foodordering.R
import com.example.foodordering.model.FoodIcons
import com.example.foodordering.model.Foods


@Composable
fun IconButton(icon:FoodIcons) {

    Row {
        Surface(
            modifier = Modifier
                .padding(horizontal = 0.dp)
                .height(60.dp)
                .width(60.dp),
            color = Color.LightGray,
            elevation = 5.dp,
            shape = RoundedCornerShape(corner = CornerSize(9.dp))
        ) {
            Image(
                painter = painterResource(id = icon.icon),
                contentDescription = "icon"
            )

        }
        Spacer(modifier = Modifier.width(10.dp))
    }
}


//@Preview(showBackground = true)
@Composable
fun FoodCard(modifier: Modifier = Modifier,food:Foods,onClick:() ->Unit = {} ){
    Surface(modifier = modifier
        .padding(start = 20.dp)
        .height(230.dp)
        .clickable { onClick() }
        .width(155.dp),
        shape = RoundedCornerShape(corner = CornerSize(20.dp)),
        elevation = 5.dp,
        color = Color.LightGray) {
        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(text = food.title,
                modifier = Modifier.padding(top = 13.dp),
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold)
            Text(text = food.ingredient,
                style = MaterialTheme.typography.caption)
            Text(text = food.amount,
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold)
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                Image(
                    painter = rememberImagePainter(
                        data = food.image),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 8.dp, bottom = 4.dp)
                        .size(115.dp)
                        .clip(shape = CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun HorizontalFoodCard(food: Foods,onClick: () -> Unit) {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(140.dp)
        .clickable { onClick() }
        .padding(horizontal = 20.dp),
        color = LightGray,
        shape = RoundedCornerShape(corner = CornerSize(20.dp)),
        elevation = 5.dp) {
        Row(){
            Column(modifier = Modifier.fillMaxHeight()
                .weight(1f)
                .padding(
                    start = 25.dp,
                    bottom = 19.dp
                ), verticalArrangement = Arrangement.Center) {
                Text(text = food.title,
                    modifier = Modifier.padding(top = 13.dp),
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold)
                Text(text = food.ingredient,
                    style = MaterialTheme.typography.caption)
                Text(text = food.amount,
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold)
            }
            Column (modifier = Modifier
                .fillMaxHeight()
                .padding(end = 6.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally){
                Image(
                    modifier = Modifier
                        .size(120.dp)
                        .padding(end = 2.dp)
                        .clip(shape = CircleShape),
                    painter = rememberImagePainter(data = food.image),
                    contentScale = ContentScale.Crop,
                    contentDescription = "food"
                )
            }
        }
    }
}







