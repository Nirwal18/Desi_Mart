package com.nirwal.desimart

import com.nirwal.desimart.di.appModule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.verify.verify

class KoinDiTest: KoinTest {
    @Test
    fun checkAllModules() {
        appModule.verify()
    }
}