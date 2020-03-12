package com.example.premiereleague.common.repo.MainRepository

import com.example.core.model.MatchesResponse
import com.example.premiereleague.common.data.network.homeApi
import com.example.premiereleague.common.model.team_info.TeamInformationResponse

class MainRepo(var api: homeApi) : IMain {
    override suspend fun getMatchesDetails(): MatchesResponse  = api.getMatchDetails()
    override suspend fun getTeamInfo(teamId: Int)  = api.getTeamInformation(teamId)

}