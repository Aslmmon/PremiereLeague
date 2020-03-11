package com.example.premiereleague.common.data.network

import com.example.core.model.MatchesResponse
import io.reactivex.Flowable

import retrofit2.Call
import retrofit2.http.GET

interface homeApi {
    @GET("/v2/competitions/2021/matches")
    fun getMatchDetails(): MatchesResponse
}