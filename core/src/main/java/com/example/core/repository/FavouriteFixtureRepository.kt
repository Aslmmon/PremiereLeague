package com.example.core.repository

import androidx.lifecycle.MutableLiveData
import com.example.core.data_source.FavouriteFixtureDataSource
import com.example.core.database.MatchDetail

class FavouriteFixtureRepository(val favouriteFixtureDataSource: FavouriteFixtureDataSource) {

    fun getAllFavouritesMatches(_MatchesFavourited: MutableLiveData<List<MatchDetail>>) =
        favouriteFixtureDataSource.getAllFavouriteMatches(_MatchesFavourited)
}