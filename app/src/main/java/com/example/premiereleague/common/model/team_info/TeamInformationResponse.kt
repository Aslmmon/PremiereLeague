package com.example.premiereleague.common.model.team_info


import com.google.gson.annotations.SerializedName

data class TeamInformationResponse(
    @SerializedName("activeCompetitions")
    val activeCompetitions: List<ActiveCompetition>,
    @SerializedName("address")
    val address: String,
    @SerializedName("area")
    val area: AreaX,
    @SerializedName("clubColors")
    val clubColors: String,
    @SerializedName("crestUrl")
    val crestUrl: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("founded")
    val founded: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lastUpdated")
    val lastUpdated: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("shortName")
    val shortName: String,
    @SerializedName("squad")
    val squad: List<Squad>,
    @SerializedName("tla")
    val tla: String,
    @SerializedName("venue")
    val venue: String,
    @SerializedName("website")
    val website: String
)