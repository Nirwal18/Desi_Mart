package com.nirwal.desimart.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nirwal.desimart.ui.composable.HomeScreen
import com.nirwal.desimart.ui.composable.shop.CategoryScreen

@Composable
fun HomeNavGraphView(
    navController:NavHostController,
    rootNavController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ){
        composable(route = BottomBarScreen.Home.route){
            HomeScreen(
                onBestSellerSectionClick = {
                    //rootNavController.navigate(BottomBarScreen..route)
                },
                onCategoryClick = {
                    rootNavController.navigate(BottomBarScreen.Category.route)
                }
            )
        }
        composable(route = BottomBarScreen.Category.route){
            CategoryScreen()
        }
        composable(route = BottomBarScreen.Account.route){
            AuthNavHost()
        }

        composable(route = BottomBarScreen.Notification.route){
            //SettingScreen(navController)
        }
        composable(route = BottomBarScreen.Order.route){
            //SettingScreen(navController)
        }
    }
}

sealed class BottomBarScreen(
    val title:String,
    val icon:ImageVector,
    val route: String,
    val badgeCount: Int
){
    object Home:BottomBarScreen(
        title = "Home",
        icon = Icons.Filled.Home,
        route = "Home",
        badgeCount = 0
    )
    object Category:BottomBarScreen(
        title = "Category",
        icon = Icons.Filled.List,
        route = "category",
        badgeCount = 8
    )
    object Account:BottomBarScreen(
        title = "Account",
        icon = Icons.Filled.Person,
        route = "account",
        badgeCount = 0
    )

    object Notification:BottomBarScreen(
        title = "Notification",
        icon = Icons.Filled.Notifications,
        route = "notification",
        badgeCount = 0
    )
    object Order:BottomBarScreen(
        title = "Orders",
        icon = Icons.Filled.ShoppingCart,
        route = "order",
        badgeCount = 0
    )
}