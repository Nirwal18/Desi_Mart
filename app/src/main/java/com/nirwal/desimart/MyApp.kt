package com.nirwal.desimart

import android.app.Application
import com.nirwal.desimart.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp:Application() {
    override fun onCreate() {
        super.onCreate()

        // koin di engine start
        startKoin{
            androidLogger()
            androidContext(this@MyApp)
            modules(appModule)
        }
    }
}