package com.example.premiereleague.common.repo.MainRepository

import com.example.core.model.MatchesResponse
import com.example.premiereleague.common.model.team_info.TeamInformationResponse

interface IMain {
    suspend fun getMatchesDetails() :MatchesResponse
    suspend fun getTeamInfo(teamId:Int):TeamInformationResponse
}