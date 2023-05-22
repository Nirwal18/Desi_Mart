package com.nirwal.desimart.ui.composable.auth

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nirwal.desimart.MyDataStore
import com.nirwal.desimart.domian.repository.AuthRepository
import kotlinx.coroutines.flow.onSubscription
import kotlinx.coroutines.launch

class AuthViewModel(
    private val dataStore:MyDataStore,
    private val authRepository: AuthRepository) :ViewModel()
{

    val isSingIn = dataStore.getBoolean("is_SignIn", false)


   init {
       viewModelScope.launch {
           authRepository.loginFlow.collect{
               dataStore.saveBoolean("is_SignIn", it)
           }

       }

       viewModelScope.launch {
           authRepository.isCodeSentFlow.collect{
               println("code Sent $it")
           }
       }
   }

    fun getOtp(phone:String, activity:Activity){
        authRepository.getOtp(phone, activity = activity)
    }

    fun verifyOtpAndSignIn(otp:String){
        authRepository.verifyOtpAndSignIn(otp = otp)
    }

}