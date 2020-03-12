package com.example.core.model

import com.example.premiereleague.common.model.team_info.TeamInformationResponse

data class MatchesResponse(
    val competition: Competition,
    val count: Int,
    val filters: Filters,
    val matches: List<Matche>,
    var newDate: String,
    var newTime: String
)