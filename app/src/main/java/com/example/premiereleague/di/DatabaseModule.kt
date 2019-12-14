package com.example.premiereleague.di

import androidx.room.Room
import com.example.core.database.AppDatabase
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "match_database")
            .fallbackToDestructiveMigration().build()
    }
    single { get<AppDatabase>().matchDao() }

}