package com.example.core.repository

import androidx.lifecycle.MutableLiveData
import com.example.core.data_source.MainFixtureDataSource
import com.example.core.model.Matche
import com.example.core.model.MatchesResponse

class MainFixtureRepository(val mainFixtureDataSource: MainFixtureDataSource) {
    fun getMatchesDetails(_MatchesDetails: MutableLiveData<MatchesResponse>)  = mainFixtureDataSource.getMatchDetails(_MatchesDetails)

    fun saveMatchDetails(match: Matche) =  mainFixtureDataSource.saveMaytchDetails(match)
}