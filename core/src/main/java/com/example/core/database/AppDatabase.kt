package com.example.core.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MatchDetail::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun matchDao() : MatchDao
}