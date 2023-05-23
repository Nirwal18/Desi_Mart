package com.nirwal.desimart.ui.composable.shop

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
fun RefundScreenPreview() {
    RefundScreen()
}

@Composable
fun RefundScreen() {
    LazyColumn{
        repeat(10){
            item {
                RefundItem(
                    modifier = Modifier.fillMaxWidth().clickable {  },
                    imageUrl = "https://5.imimg.com/data5/BG/ZA/OV/SELLER-22139392/250-gm-tata-tea-500x500.jpg",
                    statusText = "Pending",
                    refundDate = "20 May, 2023",
                    refundAmount = "102.00"
                )
            }
        }
    }
}

@Composable
fun RefundItem(modifier: Modifier = Modifier, imageUrl:String, statusText:String, refundDate:String, refundAmount:String) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        AsyncImage(
            modifier = Modifier.size(80.dp),
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .memoryCachePolicy(
                    CachePolicy.ENABLED)
                .build(),
            contentDescription = null
        )
        Column {
            Text(text = statusText)
            Text(text = refundDate)
            Text(text = refundAmount)
        }
    }
}
