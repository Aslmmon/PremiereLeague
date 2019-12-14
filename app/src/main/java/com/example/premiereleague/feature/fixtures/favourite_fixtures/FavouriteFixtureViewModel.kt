package com.example.premiereleague.feature.fixtures.favourite_fixtures

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.database.MatchDetail
import com.example.core.repository.FavouriteFixtureRepository

class FavouriteFixtureViewModel(val favouriteFixtureRepository: FavouriteFixtureRepository) :ViewModel(){

    var _MatchesFavourited = MutableLiveData<List<MatchDetail>>()
    var MatchesFavourited : LiveData<List<MatchDetail>> = _MatchesFavourited

    fun getMatchesFavourited(){
        favouriteFixtureRepository.getAllFavouritesMatches(_MatchesFavourited)
    }


}