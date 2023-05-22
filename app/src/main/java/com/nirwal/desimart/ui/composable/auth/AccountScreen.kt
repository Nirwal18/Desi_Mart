package com.nirwal.desimart.ui.composable.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nirwal.desimart.ui.composable.MyTopAppBar

@Preview(showBackground = true)
@Composable
fun AccountScreenPreview() {
AccountScreen(
    "Akshay",
    "nirwal@live.com",
    "7827628242",
    myOrderClick = { /*TODO*/ },
    onNotificationClick = { /*TODO*/ },
    onWishListClick = { /*TODO*/ },
    onManageAddress = { /*TODO*/ }) {
}
}

@Composable
fun AccountScreen(
    userName:String,
    email:String,
    phone:String,
    myOrderClick:()->Unit,
    onNotificationClick:()->Unit,
    onWishListClick:()->Unit,
    onManageAddress:()->Unit,
    onPanCardClick:()->Unit
) {


    Column {
       MyTopAppBar(title = "My Account", onBackClick = {})

        Row(
            modifier = Modifier
            .padding(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        MaterialTheme.colors.primaryVariant.copy(alpha = 0.3f),
                        shape = RoundedCornerShape(100)
                    )
                    .border(1.dp, color = Color.Gray, shape = RoundedCornerShape(100)),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Person"
                )
            }
            Column( modifier = Modifier.padding(start = 24.dp)) {
                Text(
                    text = userName,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                )
                Text(text = "$email\n$phone", color = Color.DarkGray)

            }
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .padding(start = 24.dp, end = 24.dp)
            .background(Color.Gray.copy(alpha = .3f)))

        MyMenuItem(title = "My Orders", icon = Icons.Default.AccountBox){myOrderClick.invoke()}
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .padding(start = 24.dp, end = 24.dp)
            .background(Color.Gray.copy(alpha = .3f))
        )
        MyMenuItem(title = "My Notifications", icon = Icons.Default.AccountBox){onNotificationClick}
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .padding(start = 24.dp, end = 24.dp)
            .background(Color.Gray.copy(alpha = .3f))
        )
        MyMenuItem(title = "My List", icon = Icons.Default.AccountBox){}
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .padding(start = 24.dp, end = 24.dp)
            .background(Color.Gray.copy(alpha = .3f))
        )
        MyMenuItem(title = "Wishlist", icon = Icons.Default.AccountBox){onWishListClick.invoke()}
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .padding(start = 24.dp, end = 24.dp)
            .background(Color.Gray.copy(alpha = .3f))
        )
        MyMenuItem(title = "PAN Card information", icon = Icons.Default.AccountBox){onPanCardClick.invoke()}
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .padding(start = 24.dp, end = 24.dp)
            .background(Color.Gray.copy(alpha = .3f))
        )
        MyMenuItem(title = "Delivery Addresses", icon = Icons.Default.AccountBox){onManageAddress.invoke()}
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .padding(start = 24.dp, end = 24.dp)
            .background(Color.Gray.copy(alpha = .3f))
        )


    }
    
}

@Composable
fun MyMenuItem(icon:ImageVector, title: String, onClick:()->Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .clickable(enabled = true, onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.padding(start = 24.dp),
            imageVector = icon,
            contentDescription = title,
            tint = MaterialTheme.colors.primary
        )
        Text(
            modifier = Modifier.padding(start = 24.dp),
            text = title,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
    }
}

data class MenuItem(
    val name:String,
    val icon: ImageVector,
)