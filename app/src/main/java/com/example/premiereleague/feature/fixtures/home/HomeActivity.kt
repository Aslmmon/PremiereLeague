package com.example.premiereleague.feature.fixtures.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.premiereleague.R
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity(R.layout.activity_main) {
    private val mainViewModel: MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel.getMatchDetails()
        mainViewModel.MatchDetail.observe(this, Observer {
            Log.i(javaClass.simpleName, it.matches.toString())
        })

    }

}
