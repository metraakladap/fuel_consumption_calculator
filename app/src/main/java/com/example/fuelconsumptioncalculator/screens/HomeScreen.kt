@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.fuelconsumptioncalculator.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    CalculatorScreen()
}

@Composable
fun CalculatorScreen() {
    var distanceValue by remember { mutableStateOf(0.0) }
    var averageFuelConsumptionValue by remember { mutableStateOf(0.0) }
    var priceValue by remember { mutableStateOf(0.0) }
    var result by remember { mutableStateOf("") }
    var numberOfPeopleValue by remember { mutableStateOf(0.0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize(),
    ) {
        distanceValue = CalculatorInputItem("Distance")
        averageFuelConsumptionValue = CalculatorInputItem("Average Fuel Consumption")
        priceValue = CalculatorInputItem("Price")
        numberOfPeopleValue = CalculatorInputItem("Number of People")
        CalculatorOutputItem("Result", result)

        try {
            val distance = distanceValue
            val averageFuelConsumption = averageFuelConsumptionValue
            val price = priceValue
            val numberOfPeople = numberOfPeopleValue
            var temp = (distance / 100 * averageFuelConsumption * price)
            result = if (numberOfPeople > 0 && distance > 0 && averageFuelConsumption > 0 && price > 0) {
                temp /= numberOfPeople
                "$temp"
            } else {
                "Please enter a valid values"
            }


        } catch (e: Exception) {
            result = "Please enter all values"
        }
    }
}

@Composable
fun CalculatorInputItem(label: String): Double {
    var temp by remember { mutableStateOf("") }

    OutlinedTextField(
        value = temp,
        onValueChange = { newValue ->
            temp = newValue
        },
        label = { Text(label) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ),
        shape = RoundedCornerShape(50.dp),
        modifier = Modifier
            .padding(8.dp)
    )

    return temp.toDoubleOrNull() ?: 0.0
}

@Composable
fun CalculatorOutputItem(label: String, result: String) {
    TextField(
        value = result,
        onValueChange = {},
        label = { Text(label) },
        readOnly = true,
        modifier = Modifier
            .padding(8.dp)
    )
}