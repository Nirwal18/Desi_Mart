package com.nirwal.desimart.ui.composable.shop

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.nirwal.desimart.ui.composable.MyTopAppBar

@Composable
fun MyOrdersScreen(onBack:()->Unit) {
    Column {
        MyTopAppBar(title = "My orders", onBackClick = onBack)

    }
}