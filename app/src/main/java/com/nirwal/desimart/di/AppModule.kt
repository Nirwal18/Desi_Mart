package com.nirwal.desimart.di

import com.nirwal.desimart.MyDataStore
import com.nirwal.desimart.database.MyDatabase
import com.nirwal.desimart.database.ProductDao
import com.nirwal.desimart.database.getProductDao
import com.nirwal.desimart.domian.repository.AuthRepository
import com.nirwal.desimart.domian.repository.MyAuthRepository
import com.nirwal.desimart.ui.composable.MainViewModel
import com.nirwal.desimart.ui.composable.auth.AuthViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    //single<UserRepository> { UserRepositoryImpl() }
    single { MyDataStore(androidContext()) }
    single<AuthRepository> { MyAuthRepository(androidContext())}
    single { MyDatabase.getInstance(androidContext()) }
    single { getProductDao(get()) }
    viewModel { AuthViewModel(get(), get()) }
    viewModel { MainViewModel(get()) }
}
