package com.example.splasho.di

import com.example.core.network.Api
import com.example.core.network.createNetworkClient
import org.koin.dsl.module
import retrofit2.Retrofit

private val retrofit: Retrofit = createNetworkClient()


private val LEAGUES_API: Api= retrofit.create(Api::class.java)

val networkModule = module {
    single { LEAGUES_API }
}