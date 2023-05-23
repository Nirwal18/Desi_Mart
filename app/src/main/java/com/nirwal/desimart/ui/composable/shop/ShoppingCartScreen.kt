package com.nirwal.desimart.ui.composable.shop

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.nirwal.desimart.ui.composable.MyTopAppBar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Percent
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nirwal.desimart.R
import com.nirwal.desimart.model.CartItem
import com.nirwal.desimart.ui.component.Minus
import com.nirwal.desimart.ui.component.MyTopBar
import com.nirwal.desimart.ui.viewModel.MainViewModel

@Composable
fun ShoppingCartScreen(onBack:()->Unit) {
    Column {
        MyTopAppBar(title = "ShoppingCart", onBackClick = onBack)

    }
}




@Preview(showBackground = true)
@Composable
fun CartScreenDefaultPreview() {
CartScreen(onBackClick = {}, state = MainViewModel.CartUiState(),{ _, _-> })

}


@Composable
fun CartScreen(
    onBackClick:()->Unit,
    state: MainViewModel.CartUiState,
    cartUpdateEvent:(Int, Int)->Unit
) {


    Box(modifier = Modifier.fillMaxSize()){
        MyTopBar(title = "Cart", iconBack = Icons.Default.ArrowBack, onBackClick = onBackClick)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 72.dp)
                .align(Alignment.Center)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            Basket(cartItems = state.itemList, onCartUpdate = cartUpdateEvent)

            ApplyCoupon(onApply = {})

            PaymentDetails(
                mrp = "4456.00",
                discount = "2670.00",
                deliveryFee = "40",
                isFreeDelivery = true,
                total = "1786.00"
            )

        }
    }
}


@Composable
fun PaymentDetails(
    mrp:String, discount:String,
    deliveryFee:String, isFreeDelivery:Boolean, total:String
) {
  Column(modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp)) {

      val txtModifier = Modifier
          .padding(top = 8.dp, bottom = 8.dp)
          .fillMaxWidth()
      val greenFontBold = FontWeight.Bold
      val highLightedColor = Color(0xff00d953)

      Text(modifier = txtModifier, text = "Payment Details", fontWeight = FontWeight.ExtraBold, fontSize = 16.sp)

      Spacer(modifier = Modifier
          .fillMaxWidth()
          .background(Color.Black.copy(alpha = 0.2f))
          .height(1.dp))

      Row(modifier = txtModifier, horizontalArrangement = Arrangement.SpaceBetween) {
          Text( text = "MRP Total")
          Text(text = "₹$mrp")
      }
      Spacer(modifier = Modifier
          .fillMaxWidth()
          .background(Color.Black.copy(alpha = 0.2f))
          .height(1.dp))
      Row(modifier = txtModifier, horizontalArrangement = Arrangement.SpaceBetween) {
          Text(text = "Product Discount")
          Text(text = "- ₹$discount", color = highLightedColor, fontWeight = greenFontBold)
      }
      Spacer(modifier = Modifier
          .fillMaxWidth()
          .background(Color.Black.copy(alpha = 0.2f))
          .height(1.dp))

      Row(modifier = txtModifier, horizontalArrangement = Arrangement.SpaceBetween) {
          Text(text = "Delivery Fee")
          if (isFreeDelivery) {
              Text(text = "Free", color = highLightedColor,fontWeight = greenFontBold, textAlign = TextAlign.End)
              Text(
                  text = "₹$deliveryFee",
                  style = LocalTextStyle.current.copy(textDecoration = TextDecoration.LineThrough)
              )
          }else{
              Text(text = "₹$deliveryFee")
          }

      }

      Spacer(modifier = Modifier
          .fillMaxWidth()
          .background(Color.Black.copy(alpha = 0.2f))
          .height(1.dp))
      Row(modifier = txtModifier, horizontalArrangement = Arrangement.SpaceBetween) {
          Text(text = "Total")
          Text(text = "₹$total", fontWeight = FontWeight.ExtraBold)
      }

      Text(
          modifier = Modifier.fillMaxWidth(),
          text = "You Saved ₹$discount",
          color = highLightedColor,
          textAlign = TextAlign.End,
          fontWeight = greenFontBold
      )

  }
}

@Composable
fun ApplyCoupon(modifier: Modifier= Modifier, onApply:(String)->Unit) {
    var coupon by remember{ mutableStateOf("") }
    Column(
        modifier
            .fillMaxWidth()
            .padding(16.dp)) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text( text = "Apply Coupon", fontWeight = FontWeight.ExtraBold, fontSize = 16.sp)
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "View All")
            }
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(8.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = coupon, onValueChange = { coupon = it },
            leadingIcon = { Icon(imageVector = Icons.Default.Percent, contentDescription = null)},
            label = { Text(text = "Enter Coupon Code")},
            trailingIcon = {
                if(coupon.isNotEmpty()){
                    TextButton(onClick = { onApply.invoke(coupon)}) {
                        Text(text = "Apply")
                    }
                }
            }
        )

    }
}

@Composable
fun Basket(modifier: Modifier= Modifier, cartItems: List<CartItem>, onCartUpdate:(Int, Int)->Unit){
    val count = cartItems.size
    var total =0.0
    cartItems.forEach { total += (it.quantity * it.discountedPrice) }

//    val cartItems = listOf(
//        CartItem("1101","Tata Namak","Namak by TATA products","",1, 200.0, 29.0 ),
//        CartItem("1101","Tata Tea","Tea by TATA products","",1, 340.0, 16.0 ),
//        CartItem("1101","SurfExcel","Washing Powder","",1, 120.0, 18.0 )
//    )


    Column(
        modifier = modifier
        .padding(16.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Text( text = "Basket($count)", fontWeight = FontWeight.ExtraBold, fontSize = 16.sp)
            Text(text = "₹$total")

        }


        for(cartItem in cartItems){
            BasketItem(
                title = cartItem.title,
                itemQty = cartItem.quantity,
                cartItem.imageUrl,
                onQuantityUpdate =  { qty -> onCartUpdate(cartItems.indexOf(cartItem),qty) }
            )
        }

    }
}

@Composable
fun AddRemoveControl(count:Int, onAdd:()->Unit, onSubtract:()->Unit) {

    Row(verticalAlignment = Alignment.CenterVertically){

        OutlinedButton(
            onClick = onSubtract,
            modifier= Modifier.size(30.dp),  //avoid the oval shape
            shape = CircleShape,
            border= BorderStroke(1.dp, Color.Blue),
            contentPadding = PaddingValues(0.dp),  //avoid the little icon
            colors = ButtonDefaults.outlinedButtonColors(contentColor =  Color.Blue)
        ) {
            Icon(Icons.Default.Minus, contentDescription = "content description")
        }

        Text(modifier = Modifier.padding(16.dp), text = count.toString(), fontSize = 16.sp)

        OutlinedButton(
            onClick = onAdd,
            modifier= Modifier.size(30.dp),  //avoid the oval shape
            shape = CircleShape,
            border= BorderStroke(1.dp, Color.Blue),
            contentPadding = PaddingValues(0.dp),  //avoid the little icon
            colors = ButtonDefaults.outlinedButtonColors(contentColor =  Color.Blue)
        ) {
            Icon(Icons.Default.Add, contentDescription = "content description")
        }


    }
}

@Composable
fun BasketItem(title:String, itemQty:Int,imageUrl:String, onQuantityUpdate:(Int)->Unit){
    var qty by remember {
        mutableStateOf(itemQty)
    }

    Column {
        Row {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.baseline_image),
                fallback = painterResource(R.drawable.baseline_image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(100.dp)
            )


            Column(
                Modifier
                    .padding(start = 16.dp)
                    .weight(0.7f)) {
                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.DarkGray
                )
                Text(
                    modifier = Modifier.padding(top = 4.dp, bottom = 4.dp),
                    text ="399.00",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    modifier = Modifier
                        .background(
                            color = Color.Green.copy(alpha = 0.1f),
                            shape = RoundedCornerShape(2.dp)
                        )
                        .padding(2.dp),
                    fontWeight = FontWeight.Bold,
                    text ="You Save 200.00",
                    color = Color(0xff004c00)
                )
            }
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp), horizontalArrangement = Arrangement.SpaceBetween) {

            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Save for Later")
            }

            AddRemoveControl(
                count = qty,
                onAdd = {
                    qty++
                    onQuantityUpdate.invoke(qty+1)
                },
                onSubtract = {
                    qty--
                    onQuantityUpdate.invoke(qty-1)
                }
            )

        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black.copy(alpha = 0.2f))
            .height(1.dp))
    }
}
