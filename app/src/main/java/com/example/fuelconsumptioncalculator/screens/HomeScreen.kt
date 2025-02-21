@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.fuelconsumptioncalculator.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.fuelconsumptioncalculator.MainViewModel

@Composable
fun HomeScreen(viewModel: MainViewModel) {
    CalculatorScreen(viewModel)
}

@Composable
fun CalculatorScreen(viewModel: MainViewModel) {
    val state by viewModel.state.collectAsState()

    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Fuel Cost Calculator",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            CalculatorInputItem("Distance (km)") { viewModel.updateDistance(it) }
            CalculatorInputItem("Average Fuel Consumption (L/100km)") { viewModel.updateAverageFuelConsumption(it) }
            CalculatorInputItem("Fuel Price (per L)") { viewModel.updatePrice(it) }
            CalculatorInputItem("Number of People") { viewModel.updateNumberOfPeople(it) }

            Divider(modifier = Modifier.padding(vertical = 8.dp))

            CalculatorOutputItem("Total Cost", state.result)
        }
    }
}


@Composable
fun CalculatorInputItem(label: String, onValueChange: (Double) -> Unit) {
    var temp by remember { mutableStateOf("") }

    OutlinedTextField(
        value = temp,
        onValueChange = {
            temp = it
            onValueChange(it.toDoubleOrNull() ?: 0.0)
        },
        label = { Text(label) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ),
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),

    )
}

@Composable
fun CalculatorOutputItem(label: String, result: String) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = label, style = MaterialTheme.typography.labelMedium, color = Color.Gray)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = result, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
        }
    }
}