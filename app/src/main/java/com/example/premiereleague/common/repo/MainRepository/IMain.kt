package com.example.premiereleague.common.repo.MainRepository

import com.example.core.model.MatchesResponse

interface IMain {
    suspend fun getMatchesDetails() :MatchesResponse
}