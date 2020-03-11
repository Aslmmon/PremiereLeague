package com.example.splasho.di


import com.example.premiereleague.feature.fixtures.home.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get() ) }
}