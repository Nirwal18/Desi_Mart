package com.nirwal.desimart.ui.composable

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nirwal.desimart.ui.navigation.BottomBarScreen
import com.nirwal.desimart.ui.navigation.HomeNavGraphView

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(rootNavController = rememberNavController())
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(rootNavController: NavHostController) {

    MainPage(
        navController = rememberNavController(),
        rootNavController = rootNavController
    )


}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainPage(
    navController: NavHostController,
    rootNavController: NavHostController
) {
    Scaffold(
        bottomBar = {
            MyBottomNavigationBar(
                items = listOf(
                    BottomBarScreen.Home,
                    BottomBarScreen.Category,
                    BottomBarScreen.Account,
                    BottomBarScreen.Notification,
                    BottomBarScreen.Order
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
            HomeNavGraphView(
                navController = navController,
                rootNavController = rootNavController
            )
        }

    }
}


@Composable
fun MyBottomNavigationBar(
    items: List<BottomBarScreen>,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomBarScreen)-> Unit
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
                                    contentDescription = item.title
                                )
                            }
                        } else{
                            Icon(imageVector = item.icon,
                                contentDescription = item.title
                            )
                        }
                        if(selected){
                            Text(
                                text = item.title,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        }
                    }
                }//Icons
            )
        }
    }

}

