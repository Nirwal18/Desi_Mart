package com.nirwal.desimart.ui.navigation

sealed class MyNavGraph(val title:String, val route: String){

    object SplashScreen:MyNavGraph(title = "Splash Screen", route = "splash_screen")
    object OnBoardingScreen:MyNavGraph(title = "On Boarding Screen", route = "on_boarding_screen")
    object MainScreen:MyNavGraph(title = "Main Screen", route = "main")

    object AuthNavGraph:MyNavGraph(title = "Auth Navigation Graph", route = "auth_"){
        object SignInScreen:MyNavGraph(title = "SignIn Screen", route = "${this.route}SignIn")
        object OtpVerifyScreen:MyNavGraph(title = "OTP verify Screen", route = "${this.route}OtpVerify")
        object AccountScreen:MyNavGraph(title = "Account Screen", route="${this.route}account"){
            object ManageDeliveryAddressScreen:MyNavGraph(title = "Manage delivery address", route = "${this.route}manageDelivery")
            object PanCardScreen:MyNavGraph(title = "PanCard Screen", route = "${this.route}panCard")
        }
    }

    object ShopNavGraph:MyNavGraph(title = "Shop Navigation Graph", route = "shop_"){
        object MyOrdersScreen:MyNavGraph(title = "My Orders Screen", route = "${this.route}myOrders")
        object WishListScreen:MyNavGraph(title = "WishList Screen", route = "${this.route}wishList")
        object ShoppingCartScreen:MyNavGraph(title = "ShoppingCart Screen", route = "${this.route}cart")
    }

    override fun toString(): String {
        return this.route
    }
}
