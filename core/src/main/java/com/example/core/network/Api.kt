package com.example.core.network

import com.example.core.model.MatchesResponse
import io.reactivex.Flowable

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("/v2/competitions/2021/matches")
    fun getMatchDetails(): Flowable<MatchesResponse>
}