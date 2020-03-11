package com.example.premiereleague.feature.fixtures.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.premiereleague.R
import com.example.premiereleague.common.Navigation
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity(R.layout.activity_splash) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalScope.launch {
            delay(3000)
            Navigation.goToMainActivity(this@SplashActivity)
        }
    }
}
