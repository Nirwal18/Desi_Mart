package com.nirwal.desimart.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200
    //all above Orange
    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)



private val LightColorPalette2 = lightColors(
    primary = orangish,
    primaryVariant = orangish,
    secondary = orangish,


    //background = backgroundColor,
    //all above Orange
    // Other default colors to override
    //surface = Color.White,
    //onPrimary = Color.White,
    //onSecondary = Color.Black,
    //onBackground = Color.Black,
    //onSurface = Color.Black,

)


@Composable
fun DesiMartTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette2
    }

    val systemUiController:SystemUiController = rememberSystemUiController()
    systemUiController.isStatusBarVisible = false

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}



@Composable
fun GroceryAppTheme(content: @Composable() () -> Unit) {
    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}