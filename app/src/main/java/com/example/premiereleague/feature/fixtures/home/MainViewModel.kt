package com.example.premiereleague.feature.fixtures.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.model.MatchesResponse
import com.example.premiereleague.common.repo.MainRepository.IMain
import kotlinx.coroutines.launch

class MainViewModel(var mainRepo: IMain) : ViewModel() {


    /**
     * MainFix.ViewModel having refrence to Repo ..
     */
    var _MatchesDetails = MutableLiveData<MatchesResponse>()
    var MatchDetail: LiveData<MatchesResponse> = _MatchesDetails

    fun getMatchDetails() {
        viewModelScope.launch {
            try {
                _MatchesDetails.postValue(mainRepo.getMatchesDetails())
            } catch (e: Throwable) {
                Log.i(javaClass.simpleName, e.message)
            }
        }
    }



}