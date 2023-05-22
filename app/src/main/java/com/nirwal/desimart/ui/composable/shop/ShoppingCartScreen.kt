package com.nirwal.desimart.ui.composable.shop

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.nirwal.desimart.ui.composable.MyTopAppBar

@Composable
fun ShoppingCartScreen(onBack:()->Unit) {
    Column {
        MyTopAppBar(title = "ShoppingCart", onBackClick = onBack)

    }
}