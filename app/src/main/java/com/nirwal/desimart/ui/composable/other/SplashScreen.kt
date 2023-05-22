package com.nirwal.desimart.ui.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nirwal.desimart.MyDataStore
import com.nirwal.desimart.R
import com.nirwal.desimart.ui.navigation.MyNavGraph
import kotlinx.coroutines.delay

@Preview
@Composable
fun AnimatedSplashScreenPreview(){
    SplashScreen(1f)
}


@Composable
fun AnimatedSplashScreen(navigationController:NavHostController){
    val dataStore = MyDataStore(LocalContext.current)
    val isFirstTime = dataStore.getBoolean("is_first_time", true)
        .collectAsState(false).value


    var startAnimation by remember {
        mutableStateOf(false)
    }
    val alphaAnim = animateFloatAsState(targetValue = if (startAnimation) 1f else 0f,
    animationSpec = tween(durationMillis = 3000)
        )

    LaunchedEffect(key1 = true){
        startAnimation = true
        delay(3000)
        navigationController.popBackStack()

        //for first time navigate OnBoardingScreen
        if(isFirstTime){
            navigationController.navigate(route = MyNavGraph.OnBoardingScreen.route)
        }else{
            navigationController.navigate(route = MyNavGraph.MainScreen.route)
        }


    }
    // Remember a SystemUiController
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
    val primaryColor = MaterialTheme.colors.primary

    DisposableEffect(systemUiController, useDarkIcons) {
        // Update all of the system bar colors to be transparent, and use
        // dark icons if we're in light theme
        systemUiController.setSystemBarsColor(
            color = if (!useDarkIcons) Color.Black else primaryColor,
            darkIcons = useDarkIcons
        )

        // setStatusBarColor() and setNavigationBarColor() also exist

        onDispose {
            systemUiController.setSystemBarsColor(
                color = if (!useDarkIcons) Color.Black else Color.White,
                darkIcons = useDarkIcons
            )
        }
    }
    SplashScreen(alphaAnim.value)
}

@Composable
fun SplashScreen(alpha:Float) {
    Box (
        modifier = Modifier
            .background(if (isSystemInDarkTheme()) Color.Black else MaterialTheme.colors.primary)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Image(
            modifier= Modifier
                .size(140.dp)
                .alpha(alpha = alpha),
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null
        )
    }
}