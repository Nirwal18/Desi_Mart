package com.nirwal.desimart.ui.composable.shop

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.nirwal.desimart.ui.composable.MyTopAppBar

@Composable
fun WishListScreen(onBack:()->Unit) {
    Column {
        MyTopAppBar(title = "WishList", onBackClick = onBack)

    }
}