package com.example.splasho.di


import com.example.core.data_source.FavouriteFixtureDataSource
import com.example.core.data_source.MainFixtureDataSource
import com.example.premiereleague.framework.FavouriteFixtureDataSourceImpl
import com.example.premiereleague.framework.MainFixturesDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<MainFixtureDataSource> { MainFixturesDataSourceImpl(api = get(),matchDao = get()) }
    single<FavouriteFixtureDataSource> { FavouriteFixtureDataSourceImpl(matchDao = get()) }
}