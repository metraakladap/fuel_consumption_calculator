package com.example.fuelconsumptioncalculator

data class HomeScreenState(
    val distance: Double = 0.0,
    val averageFuelConsumption: Double = 0.0,
    val price: Double = 0.0,
    val numberOfPeople: Double = 0.0,
    val result: String = ""
)