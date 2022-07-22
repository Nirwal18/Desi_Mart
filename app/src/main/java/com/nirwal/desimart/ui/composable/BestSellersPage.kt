package com.nirwal.desimart.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nirwal.desimart.R

@Preview(showBackground = true)
@Composable
fun BestSellerPagePreview() {
    BestSellerPage()
}

@Composable
fun BestSellerPage() {
    Column {


        MyTopAppBar(title = "Best Seller")
        LazyColumn() {
            item {
                ProductItemView()
            }
            item {
                ProductItemView()
            }
            item {
                ProductItemView()
            }
            item {
                ProductItemView()
            }
            item {
                ProductItemView()
            }
            item {
                ProductItemView()
            }
        }
    }
}

@Composable
fun ProductItemView() {
    Row(modifier= Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
       Image(modifier= Modifier
           .width(100.dp)
           .height(100.dp)
           .border(
               width = 1.dp,
               color = Color.LightGray,
               shape = RoundedCornerShape(3.dp)
           ),
           painter = painterResource(id = R.drawable.item_apple),
           contentDescription = null
       )


        Column(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)
                .weight(1f)
        ) {
            Text(text = "Apple",
                style=MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold
            )
            Text(text = "per KG")
            Text(
                text = "₹197",
                fontWeight = FontWeight.Bold
            )
        }
        if("a"=="b"){
            Button(onClick = {}) {
                Text(text="Add +")
            }
        }else{
            AddRemoveItemBtnGrp(modifier = Modifier.weight(1f))
        }

    }
    Spacer(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .height(1.dp)
            .background(color = Color.LightGray)
    )
}


