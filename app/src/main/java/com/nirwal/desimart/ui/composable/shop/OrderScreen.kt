package com.nirwal.desimart.composable.shop

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest

@Preview(showBackground = true)
@Composable
fun OrderScreenPreview() {
    OrderScreen()
}

@Composable
fun OrderScreen() {
    LazyColumn() {
        repeat(10){
            item {
                OrderItem(
                    modifier = Modifier.fillMaxWidth()
                        .padding(4.dp)
                        .clickable {  },
                    imageUrl = "https://insert-koin.io/img/koin_new_logo.png",
                    statusText = "Deliver",
                    orderDate = "10-05-2023",
                    cartItemCount = "Groceries(2 items)"
                )
            }
        }
    }
}

@Composable
fun OrderItem(modifier: Modifier =Modifier, imageUrl:String,statusText:String,orderDate:String,cartItemCount:String) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        val request = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .memoryCachePolicy(
                CachePolicy.ENABLED)
            .build()
      AsyncImage(
          modifier = Modifier.size(80.dp),
          model = request,
          contentDescription = null
      )
        Column {
            Text(text = statusText)
            Text(text = orderDate)
            Text(text = cartItemCount)
        }
    }
}
