package com.example

import android.app.Application
import com.example.premiereleague.di.databaseModule
import com.example.premiereleague.di.repositoryModule
import com.example.splasho.di.dataSourceModule
import com.example.splasho.di.networkModule
import com.example.splasho.di.viewModelModule

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
class App : Application() {

    /**
     * App to Start Koin with
     */
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(listOf(repositoryModule,viewModelModule, dataSourceModule, networkModule,databaseModule))
        }
    }
}