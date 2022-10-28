package com.example.foodordering.model

import com.example.foodordering.R

data class Foods(
    val id:String,
    val title:String,
    val ingredient:String,
    val amount:String,
    val min:String,
    val image:String,
    val details:String
)

fun getFoods():List<Foods>{
    return listOf(
        Foods(
            id = "1",
            title = "Nicoise Salad",
            ingredient = "Green Bin,Egg,Tofu",
            amount = "$25.00",
            image = "https://www.thespruceeats.com/thmb/kxNbxMNKb47mkJY8GvwqgotnrJs=/2048x1366/filters:fill(auto,1)/nicoise-salad-recipe-996051-01-9643cd9247d845d387dd86e1a3ee73b0.jpg",
            details = "Salade niçoise, salada nissarda in the Niçard dialect " +
                    "of the Occitan language, insalata nizzarda in Italian," +
                    " is a salad that originated in the French city of Nice.",
            min = "30 Min"
        ),
        Foods(
            id = "2",
            title = "Green \nSalad",
            ingredient = "Tofu,Cheese,Garlic",
            amount = "$12.00",
            image = "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/chopped-green-salad-with-herby-chilli-dressing-0bc8e57.jpg",
            details = "A green salad, or green leaf salad, " +
                    "another name for garden salad, is most often composed of leafy vegetables such as lettuce varieties, " +
                    "spinach, or rocket (arugula)." +
                    " If non-greens make up a large portion of the salad it may instead be called a vegetable salad.",
            min = "25 Min"
        ),
        Foods(
            id = "3",
            title = "Cobb Salad",
            ingredient = "Green Bin,Sweet Potato,Cheese",
            amount = "$16.00",
            image = "https://healthyrecipesblogs.com/wp-content/uploads/2020/08/cobb-salad-featured-2022.jpg",
            details = "Cobb Salad is full mill salad with best ingrident for you health,crispy bacon," +
                    " hard-boiled eggs, chicken breast, and creamy avocado. " +
                    "For the chicken, you can poach it, grill it, bake it, or cook it in an Instant Pot." +
                    " Or you can replace it with grilled steak or sautéed shrimp. ",
            min = "15 Min"
        ),
        Foods(
            id = "4",
            title = "Caesar Salad",
            ingredient = "Cheese,eggs,Mayonnaise",
            amount = "$17.00",
            image = "https://www.thespruceeats.com/thmb/zfbHjmj7LF-s7tu1V070qG2O-os=/2667x2000/smart/filters:no_upscale()/caesar-salad-recipe-256363-3e0462e398f44032bb7b93abc1ea8b31.jpg",
            details = "A Caesar salad is a green salad of romaine lettuce and croutons dressed with lemon juice, " +
                    "olive oil, egg, Worcestershire sauce, anchovies, garlic, Dijon mustard, Parmesan cheese, and black pepper. " +
                    "In its original form, this salad was prepared and served tableside.",
            min = "15 Min"
        ),
    )
}