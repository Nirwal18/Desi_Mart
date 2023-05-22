package com.nirwal.desimart.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.nirwal.desimart.R

@Preview(showBackground = true)
@Composable
fun CartPagePreview(){
    CartPage()
}
@Composable
fun CartPage(){

    Column {
        MyTopAppBar(title = "Cart",{})
        CartItems()

    }
}





@Composable
fun ItemCountBox(){
    Row(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween
    ){
       Text(text = "1 Items",
       style = MaterialTheme.typography.subtitle2)
        Text(text = "Total: ₹100",
        style = MaterialTheme.typography.subtitle1)
    }
}

@Composable
fun CartItems(){
    LazyColumn(contentPadding = PaddingValues(0.dp),
            verticalArrangement =  Arrangement.spacedBy(8.dp)
    ) {

        item {
            ItemCountBox()
        }
        item {
            CartItem()
        }

        item {
            CartItem()
        }


        item {
            CartItem()
        }

        item {
            CartItem()
        }
        item {
            CartItem()
        }

        item {
            CartItem()
        }


    }
}

@Composable
fun CartItem(){
   Card(modifier = Modifier
       .fillMaxWidth()
       .background(Color.White),
       elevation = 4.dp

   ) {
       Column{

           Row(
               Modifier
                   .padding(16.dp)
                   .height(128.dp),
               verticalAlignment = Alignment.CenterVertically) {


               Image(painter = painterResource(id = R.drawable.item_apple),
                   contentDescription = null,
                   modifier = Modifier
                       .fillMaxHeight()
                       .aspectRatio(.8f)
                       .padding(end = 16.dp)
                       .border(
                           width = 1.dp,
                           color = Color.LightGray,
                           shape = RoundedCornerShape(4.dp)
                       )
               )
               Column ( modifier = Modifier.weight(1f),){
                   Text(text = "Apple",
                       style = MaterialTheme.typography.subtitle1
                   )
                   Text(text = "Price: 50/kg")
               }

               Column(Modifier.weight(1f) ) {

                   Text(text = "qty:10", modifier = Modifier.fillMaxWidth(),textAlign = TextAlign.Center)
                   Spacer(modifier = Modifier.height(25.dp))
                   AddRemoveItemBtnGrp(modifier = Modifier.fillMaxWidth())
               }

           }

           Spacer(modifier = Modifier.width(1.dp))
            RemoveButton(text = "Remove", onClick ={} )

       }
   }
}

@Composable
fun RemoveButton(text: String, onClick:()-> Unit) {

    OutlinedButton( modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors( backgroundColor = Color.Transparent),
        onClick = onClick
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
//            .background(
//                brush = Brush.horizontalGradient(
//                    colors = listOf(
//                        Color.LightGray,
//                        Color.White,
//                        Color.LightGray
//                    )
//                )
//            )
            .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center){

            Text(text = text)
        }
    }
}

