package com.example.splasho.di

import com.example.premiereleague.common.data.network.createNetworkClient
import com.example.premiereleague.common.data.network.homeApi
import org.koin.dsl.module
import retrofit2.Retrofit

private val retrofit: Retrofit = createNetworkClient()


private val LEAGUES_API: homeApi= retrofit.create(homeApi::class.java)

val networkModule = module {
    single { LEAGUES_API }
}