package com.nirwal.desimart.ui.composable.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.nirwal.desimart.ui.composable.MyTopAppBar

@Composable
fun PanCardScreen(onBack:()->Unit) {
    Column {
        MyTopAppBar(title = "PAN card information", onBackClick = onBack)

    }
}