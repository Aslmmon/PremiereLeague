package com.example.core.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface MatchDao {

    @Insert
    fun insert(match: MatchDetail): Completable

    @Query("SELECT * FROM match_table ")
    fun getAllMatchDetails(): Observable<List<MatchDetail>>
}