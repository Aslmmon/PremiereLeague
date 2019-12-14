package com.example.premiereleague.framework

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.core.data_source.FavouriteFixtureDataSource
import com.example.core.database.MatchDao
import com.example.core.database.MatchDetail
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FavouriteFixtureDataSourceImpl(var matchDao: MatchDao) : FavouriteFixtureDataSource {

    /**
     * get All Matches Favourites and pass value to LiveData to be Observed ..
     */

    @SuppressLint("CheckResult")
    override fun getAllFavouriteMatches(_MatchesFavourited: MutableLiveData<List<MatchDetail>>) {
        matchDao.getAllMatchDetails().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list->
                Log.i(javaClass.simpleName,list.toString())
               _MatchesFavourited.value = list
            },{
                Log.i(javaClass.simpleName,it.message)
            })
    }
}