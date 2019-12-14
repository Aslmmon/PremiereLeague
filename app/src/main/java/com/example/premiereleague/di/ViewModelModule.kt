package com.example.splasho.di


import com.example.premiereleague.feature.fixtures.favourite_fixtures.FavouriteFixtureViewModel
import com.example.premiereleague.feature.fixtures.main_fixtures.MainFixturesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainFixturesViewModel(get()) }
    viewModel { FavouriteFixtureViewModel(get() ) }
}