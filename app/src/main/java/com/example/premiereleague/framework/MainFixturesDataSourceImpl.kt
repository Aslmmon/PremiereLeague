package com.example.premiereleague.framework

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.core.data_source.MainFixtureDataSource
import com.example.core.database.MatchDao
import com.example.core.database.MatchDetail
import com.example.core.model.Matche
import com.example.core.model.MatchesResponse
import com.example.core.network.Api
import com.example.premiereleague.common.Utils
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainFixturesDataSourceImpl(var api: Api, var matchDao: MatchDao) : MainFixtureDataSource {
    @SuppressLint("CheckResult")
    override fun getMatchDetails(_MatchesDetails: MutableLiveData<MatchesResponse>) {
        api.getMatchDetails().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { listOfMatches->
                listOfMatches.matches.forEach {match ->
                    val dateCharacter = match.utcDate.indexOf("T")
                    var time = match.utcDate.substring(dateCharacter + 1, match.utcDate.length - 4)
                    var date = match.utcDate.substring(0, dateCharacter)
                    match.newTime = time
                    match.newDate = date
                }
                return@map listOfMatches

            }
            .subscribe({
                Log.i(this.javaClass.simpleName, it.toString())
                _MatchesDetails.value = it
            }, { throwwable ->
                Log.i(this.javaClass.simpleName, throwwable.toString())

            })
    }

    @SuppressLint("CheckResult")
    override fun saveMaytchDetails(match: Matche) {
        matchDao.insert(
            MatchDetail(
                match.id, match.homeTeam.name, match.score.fullTime.homeTeam, match.score.fullTime.awayTeam,
                match.awayTeam.name
            )
        )
            .subscribeOn(Schedulers.io())
            .subscribe({
                Log.i(this.javaClass.simpleName, "saved")
            }, {
                Log.i(this.javaClass.simpleName, it.toString())
            })
    }
}