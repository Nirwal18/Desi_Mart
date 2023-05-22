package com.nirwal.desimart.domian.repository

import android.app.Activity
import kotlinx.coroutines.flow.MutableStateFlow

interface AuthRepository {
    fun singOut()
    fun getOtp(phone: String, activity: Activity)
    fun verifyOtpAndSignIn(otp:String)
    val loginFlow:MutableStateFlow<Boolean>
    val isCodeSentFlow:MutableStateFlow<Boolean>
}