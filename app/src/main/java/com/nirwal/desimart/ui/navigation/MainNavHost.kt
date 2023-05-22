package com.nirwal.desimart.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nirwal.desimart.ui.composable.*
import com.nirwal.desimart.ui.composable.shop.CategoryScreen
import com.nirwal.desimart.ui.screen.AnimatedSplashScreen



@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = MyNavGraph.SplashScreen.route) {
        composable(route = MyNavGraph.SplashScreen.route) {
            AnimatedSplashScreen(navigationController = navController)
        }
        composable(route = MyNavGraph.OnBoardingScreen.route) {
            OnBoardingPage(navController)
        }
        composable(route = MyNavGraph.MainScreen.route) {
            MainScreen(navController)
        }

        composable(route = "category") {
            CategoryScreen()
        }
        composable(route = "best_seller") {
            BestSellerPage()
        }

    }
}