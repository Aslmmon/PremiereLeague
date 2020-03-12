package com.example.core.model

import com.example.premiereleague.common.model.team_info.TeamInformationResponse

data class Matche(
    val awayTeam: AwayTeam,
    val group: String,
    val homeTeam: HomeTeam,
    val id: Int,
    val lastUpdated: String,
    val matchday: Int,
    val referees: List<Any>,
    val score: Score,
    val season: Season,
    val stage: String,
    val status: String,
    var utcDate: String,
    var newDate:String,
    var newTime:String,
    var isFavourited:Boolean = false,
    var homeTeamInfo:TeamInformationResponse,
    var awayTeamInfo :TeamInformationResponse
)