package com.example.premiereleague.common

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.example.premiereleague.feature.fixtures.home.HomeActivity

object Navigation {

    fun goToMainActivity(ctx: Context) {
        ctx.startActivity(Intent(ctx, HomeActivity::class.java))
        (ctx as Activity).finish()
    }
}