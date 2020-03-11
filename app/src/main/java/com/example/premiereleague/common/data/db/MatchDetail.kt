package com.example.premiereleague.common.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey

@Entity(tableName = "match_table")
data class MatchDetail(@PrimaryKey(onConflict = OnConflictStrategy.REPLACE) var id: Int?,
                       @ColumnInfo(name = "home_team") var homeTeam: String?,
                       @ColumnInfo(name="home__team_result") var homeResult :String?,
                       @ColumnInfo(name="away_team_result") var awayResult:String?,
                       @ColumnInfo(name = "away_team") var awayTeam: String?) {
}