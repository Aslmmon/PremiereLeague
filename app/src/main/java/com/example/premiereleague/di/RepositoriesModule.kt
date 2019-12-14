package com.example.premiereleague.di

import com.example.core.data_source.MainFixtureDataSource
import com.example.core.repository.FavouriteFixtureRepository
import com.example.core.repository.MainFixtureRepository
import com.example.premiereleague.framework.MainFixturesDataSourceImpl
import org.koin.dsl.module


val repositoryModule = module {
    factory { MainFixtureRepository(get()) }
    factory { FavouriteFixtureRepository(get()) }
}