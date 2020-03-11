package com.example.core.model

data class MatchesResponse(
    val competition: Competition,
    val count: Int,
    val filters: Filters,
    val matches: List<Matche>,
    var newDate:String,
    var newTime:String
)