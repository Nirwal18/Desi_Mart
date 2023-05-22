package com.nirwal.desimart.ui.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nirwal.desimart.ui.composable.auth.AccountScreen
import com.nirwal.desimart.ui.composable.auth.AccountScreenPreview
import com.nirwal.desimart.ui.composable.auth.AuthViewModel
import com.nirwal.desimart.ui.composable.auth.OtpVerifyScreen
import com.nirwal.desimart.ui.composable.auth.SignInScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun AuthNavHost() {

    val navController = rememberNavController()
    val vm:AuthViewModel = koinViewModel()
    val context = LocalContext.current

    val isSignIn = vm.isSingIn.collectAsState(initial = false).value
    val startDest =  if(isSignIn){
        MyNavGraph.AuthNavGraph.AccountScreen.route
    }else{
        MyNavGraph.AuthNavGraph.SignInScreen.route
    }

    NavHost(navController = navController, startDestination = startDest ){
        composable(MyNavGraph.AuthNavGraph.SignInScreen.route){
            SignInScreen(
                onGetOtp = {
                // call api using view model then navigate
                    vm.getOtp(it, context as Activity)
                    navController.navigate(MyNavGraph.AuthNavGraph.OtpVerifyScreen.route)
                },
                onSkip = {
                 // TODO:: implement later
                },
                showPrivacyPolicy = {},
                showTermAndCondition = {}
            )
        }
        composable(MyNavGraph.AuthNavGraph.OtpVerifyScreen.route){
            OtpVerifyScreen()
        }
        composable(MyNavGraph.AuthNavGraph.AccountScreen.route){
            AccountScreenPreview()
        }
    }
}



