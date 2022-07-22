package com.nirwal.desimart.ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nirwal.desimart.model.BottomNavItem

@Composable
fun MainPage() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
        MyBottomNavigationBar(
            items = listOf(
                BottomNavItem(
                    name =  "Home",
                    route = "home",
                    icon = Icons.Default.Home
                ),
                BottomNavItem(
                    name =  "Cart",
                    route = "cart",
                    icon = Icons.Default.ShoppingCart,
                    badgeCount = 90
                ),
                BottomNavItem(
                    name =  "Account",
                    route = "account",
                    icon = Icons.Default.AccountBox
                ),

            ),
            navController = navController,
            onItemClick = {
                navController.navigate(it.route)
            }
        )
    }) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 58.dp)) {
            MyNavigation(navController = navController)
        }

    }
    
}

@Composable
fun MyBottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem)-> Unit
) {

    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.White,
        elevation = 5.dp
    ) {
        items.forEach{ item->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = Color.Gray,
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if(item.badgeCount > 0){
                            BadgedBox(badge ={
                                Badge{
                                    Text(text = item.badgeCount.toString())
                                }
                            }){
                                Icon(imageVector = item.icon,
                                    contentDescription = item.name
                                )
                            }
                        } else{
                            Icon(imageVector = item.icon,
                                contentDescription = item.name
                            )
                        }
                        if(selected){
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        }
                    }
                }
            )
        }
    }

}

@Composable
fun MyNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home" ){
        composable(route = "home"){
            HomeScreen(navController)
        }
        composable(route ="cart"){
            CartPage()
        }
        composable(route ="account"){
            AccountPage()
        }
        composable(route ="category"){
            CategoryPage()
        }
        composable(route ="best_seller"){
            BestSellerPage()
        }
    }
}