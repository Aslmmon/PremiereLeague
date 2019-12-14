package com.example.premiereleague.feature.fixtures.main_fixtures

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.model.Matche
import com.example.core.model.MatchesResponse
import com.example.core.repository.MainFixtureRepository
import com.example.premiereleague.common.Utils

class MainFixturesViewModel(var mainFixtureRepository: MainFixtureRepository) : ViewModel() {


    /**
     * MainFix.ViewModel having refrence to Repo ..
     */
    var _MatchesDetails = MutableLiveData<MatchesResponse>()
    var MatchDetail: LiveData<MatchesResponse> = _MatchesDetails

    fun getMatchDetails(){
        mainFixtureRepository.getMatchesDetails(_MatchesDetails)
    }

    fun saveToDatabase(match: Matche) {
        mainFixtureRepository.saveMatchDetails(match)
    }


}