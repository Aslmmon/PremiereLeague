package com.example.core.data_source

import androidx.lifecycle.MutableLiveData
import com.example.core.database.MatchDetail

interface FavouriteFixtureDataSource {

    fun getAllFavouriteMatches(_MatchesFavourited: MutableLiveData<List<MatchDetail>>)
}