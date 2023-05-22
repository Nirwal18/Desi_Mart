package com.nirwal.desimart

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.rememberNavController
import com.nirwal.desimart.ui.composable.MainScreen
import com.nirwal.desimart.ui.theme.DesiMartTheme
import kotlinx.coroutines.delay
import org.junit.Rule
import org.junit.Test


class MyComposeTest {

  //  val composeTestRule = createComposeRule()
        // an activity
    @get:Rule
    val composeTestRule =  createAndroidComposeRule<MainActivity>()
    @Test
    fun myTest() {
        // Start the app
//        composeTestRule.setContent {
//            DesiMartTheme {
//                MainScreen(rememberNavController())
//            }
//        }


        composeTestRule.onNodeWithText("Continue").performClick()

        composeTestRule.onNodeWithText("Welcome").assertIsDisplayed()
    }


    @Test
    fun homePageTest(){

    }

    @Test
    fun profileClickTest(){

    }

    @Test
    fun isOnLoginScreenTest(){

    }

    @Test
    fun isOnOtpScreenTest(){

    }

    @Test
    fun isOnCategoryScreenTest(){

    }
}
