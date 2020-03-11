package com.example.core.model

data class Score(
    val duration: String,
    val extraTime: ExtraTime,
    val fullTime: FullTime,
    val halfTime: HalfTime,
    val penalties: Penalties,
    val winner: Any
)