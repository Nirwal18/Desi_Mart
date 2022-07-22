package com.nirwal.desimart.model

import androidx.compose.ui.graphics.Color
import com.nirwal.desimart.R
import com.nirwal.desimart.ui.theme.ColorGreen
import com.nirwal.desimart.ui.theme.ColorYellow
import com.nirwal.desimart.ui.theme.orangish

data class OnBoardingData(
    val image: Int,
    val title: String,
    val desc: String,
    val backgroundColor:Color,
    val mainColor: Color = orangish
)

fun onBoardingDataItems() :ArrayList<OnBoardingData>{
    val items = ArrayList<OnBoardingData>()
    items.add(
        OnBoardingData(
            R.drawable.fruit,
            "Hmmm, Healthy Food",
            "A variety of healthy foods made by the best chefs. Ingredients are easy to find. all delicious flavors can only be found at cookbunda",
            backgroundColor = Color(0xFF0189C5),
            mainColor = Color(0xFF00B5EA)
        )
    )

    items.add(
        OnBoardingData(
            R.drawable.food,
            "Fresh Drinks, Stay Fresh",
            "Not only food. we provide clear healthy drink options for you. Fresh taste always accompanies you",
            backgroundColor = Color(0xFFE4AF19),
            mainColor = ColorYellow
        )
    )

    items.add(
        OnBoardingData(
            R.drawable.cooking,
            "Let’s Cooking",
            "Are you ready to make a dish for your friends or family? create an account and cook",
            backgroundColor = Color(0xFF96E172),
            mainColor = ColorGreen
        )
    )

    return items
}
