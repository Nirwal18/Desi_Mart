package com.nirwal.desimart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.nirwal.desimart.ui.composable.*
import com.nirwal.desimart.ui.theme.DesiMartTheme

class MainActivity : ComponentActivity() {

    //val isFirstTime :Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DesiMartTheme {
                val isFirstTime = remember{mutableStateOf(true)}

                if(isFirstTime.value){
                    OnBoardingPage(onFinish = {
                        isFirstTime.value=false
                    })
                }else{
                    MainPage()
                }
            }
        }
    }


    override fun onBackPressed() {
        super.onBackPressed()

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DesiMartTheme {
        MainPage()
    }
}
