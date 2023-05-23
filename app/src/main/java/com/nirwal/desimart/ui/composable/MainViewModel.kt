package com.nirwal.desimart.ui.composable

import androidx.lifecycle.ViewModel
import com.nirwal.desimart.MyDataStore
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel(val dataStore: MyDataStore):ViewModel() {
    val _uiState = MutableStateFlow(CartUiState())

}
data class CartUiState (val itemList: ArrayList<CartItem> = arrayListOf())
data class CartItem(
    val title: String,
    var quantity:Int,
    val imageUrl: String,
    val discountedPrice:Double
    )