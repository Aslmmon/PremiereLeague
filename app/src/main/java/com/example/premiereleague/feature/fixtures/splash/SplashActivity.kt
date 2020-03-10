package com.example.premiereleague.feature.fixtures.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.premiereleague.R
import com.example.premiereleague.feature.fixtures.FixturesActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity(R.layout.activity_splash) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalScope.launch {
            delay(3000)
            startActivity(Intent(this@SplashActivity,FixturesActivity::class.java))
        }
    }
}
