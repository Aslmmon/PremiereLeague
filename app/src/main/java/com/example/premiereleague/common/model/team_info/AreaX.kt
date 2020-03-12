package com.example.premiereleague.common.model.team_info


import com.google.gson.annotations.SerializedName

data class AreaX(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)