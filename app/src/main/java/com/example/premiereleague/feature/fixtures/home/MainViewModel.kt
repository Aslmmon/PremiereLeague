package com.example.premiereleague.feature.fixtures.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.model.MatchesResponse
import com.example.premiereleague.common.model.MatchDetails.MatchDetails
import com.example.premiereleague.common.model.team_info.TeamInformationResponse
import com.example.premiereleague.common.repo.MainRepository.IMain
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel(var mainRepo: IMain) : ViewModel() {

    var _teamInformation = MutableLiveData<TeamInformationResponse>()
    var TeamInfo: LiveData<TeamInformationResponse> = _teamInformation

    var _MatchesDetails = MutableLiveData<MatchesResponse>()
    var MatchDetail: LiveData<MatchesResponse> = _MatchesDetails

    lateinit var matcheDetails: MatchDetails
    fun getMatchDetails() {
        viewModelScope.launch {
            try {
                val result = mainRepo.getMatchesDetails()
                var matchDetails = arrayListOf<MatchDetails>()
                result.matches.take(5).asFlow().map { match ->
                    match.homeTeamInfo = mainRepo.getTeamInfo(match.homeTeam.id)
                    match.awayTeamInfo = mainRepo.getTeamInfo(match.awayTeam.id)
                    //match.homeTeamInfo = result2
                }.collect()
                _MatchesDetails.postValue(result)

            } catch (e: Throwable) {
                Log.i(javaClass.simpleName, e.message)
            }
        }
    }


}