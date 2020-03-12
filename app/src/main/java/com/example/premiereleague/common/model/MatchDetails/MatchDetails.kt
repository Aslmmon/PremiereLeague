package com.example.premiereleague.common.model.MatchDetails

import com.example.core.model.AwayTeam

data class MatchDetails(
    var homeTeamName: String?=null,
    var awayTeamName: String,
    var imageHomeTeam: String?=null,
    var imageAwayTeam:String?=null
)