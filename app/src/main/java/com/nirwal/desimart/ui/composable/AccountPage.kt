package com.nirwal.desimart.ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun AccountPagePreview(){
    AccountPage()
}


@Composable
fun AccountPage() {
//    Box(modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center){
//        Text(text = "Account Page")
//    }
    Box (modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        contentAlignment = Alignment.BottomCenter
    ){
        Column() {
            Text(text = "Hi this i Akshay")
            Button(onClick = { /*TODO*/ }) {
                Text(text = "click me")
            }
        }

    }
}