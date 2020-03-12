package com.example.premiereleague.common.data.network

import com.example.core.model.MatchesResponse
import com.example.premiereleague.common.model.team_info.TeamInformationResponse
import io.reactivex.Flowable

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface homeApi {
    @GET("/v2/competitions/2021/matches")
    suspend fun getMatchDetails(): MatchesResponse

    @GET("/v2/teams/{id}")
    suspend fun getTeamInformation(@Path("id") id: Int):TeamInformationResponse
}