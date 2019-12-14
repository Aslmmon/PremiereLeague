package com.example.premiereleague.common

import java.text.SimpleDateFormat
import java.util.*

class Utils {
    companion object {
        fun getCurrentDate(): String {
            val date: String = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
            return date
        }


    }


}