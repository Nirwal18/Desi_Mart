package com.nirwal.desimart.ui.composable.shop

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.nirwal.desimart.ui.composable.MyTopAppBar

@Composable
fun ManageDeliveryAddressesScreen(onBack:()->Unit) {
    Column {
        MyTopAppBar(title = "Manage delivery addresses", onBackClick = onBack)

    }
}