package com.example.premiereleague.feature.fixtures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.premiereleague.R
import com.example.premiereleague.feature.fixtures.favourite_fixtures.FavouriteFixturesFragment
import com.example.premiereleague.feature.fixtures.main_fixtures.MainFixturesFragment
import com.pandora.bottomnavigator.BottomNavigator
import kotlinx.android.synthetic.main.activity_main.*

class
FixturesActivity : AppCompatActivity() {

    private lateinit var navigator: BottomNavigator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /**
         * Creating Bottom Navigation with Pandora Library
         * to Save Multiple Back stacks and save state of each fragment
         * on Navigating to Another ..
         *
         */


        navigator = BottomNavigator.onCreate(
            fragmentContainer = R.id.fragment_container,
            bottomNavigationView = findViewById(R.id.nav_view),
            rootFragmentsFactory = mapOf(
                R.id.navigation_main_fixtures to { MainFixturesFragment() },
                R.id.navigation_favourites to { FavouriteFixturesFragment() }
            ),
            defaultTab = R.id.navigation_main_fixtures,
            activity = this
        )
    }

    override fun onBackPressed() {
        if (!navigator.pop()) {
            super.onBackPressed()
        }
    }
}
