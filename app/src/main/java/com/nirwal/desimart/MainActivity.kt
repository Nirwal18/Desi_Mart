package com.nirwal.desimart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.nirwal.desimart.ui.composable.MainPage
import com.nirwal.desimart.ui.navigation.MainNavHost
import com.nirwal.desimart.ui.theme.DesiMartTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DesiMartTheme {
                val navController = rememberNavController()
               MainNavHost(navController = navController)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DesiMartTheme {
        MainPage(rememberNavController(), rememberNavController())
    }
}
