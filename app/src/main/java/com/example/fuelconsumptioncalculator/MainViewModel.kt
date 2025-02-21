package com.example.fuelconsumptioncalculator

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel: ViewModel() {

    private val _state = MutableStateFlow(HomeScreenState())
    val state = _state.asStateFlow()

    fun updateDistance(value: Double) {
        _state.update { it.copy(distance = value) }
        calculate()
    }

    fun updateAverageFuelConsumption(value: Double) {
        _state.update { it.copy(averageFuelConsumption = value) }
        calculate()
    }

    fun updatePrice(value: Double) {
        _state.update { it.copy(price = value) }
        calculate()
    }

    fun updateNumberOfPeople(value: Double) {
        _state.update { it.copy(numberOfPeople = value) }
        calculate()
    }

    private fun calculate() {
        val state = _state.value
        val result = if (state.numberOfPeople > 0 && state.distance > 0 && state.averageFuelConsumption > 0 && state.price > 0) {
            val temp = (state.distance / 100 * state.averageFuelConsumption * state.price) / state.numberOfPeople
            temp.toString()
        } else {
            "Please enter valid values"
        }
        _state.update { it.copy(result = result) }
    }
}