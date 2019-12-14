package com.example.core.data_source

import androidx.lifecycle.MutableLiveData
import com.example.core.model.Matche
import com.example.core.model.MatchesResponse

interface MainFixtureDataSource {

    fun getMatchDetails(_MatchesDetails: MutableLiveData<MatchesResponse>)

    fun saveMaytchDetails(match: Matche)
}