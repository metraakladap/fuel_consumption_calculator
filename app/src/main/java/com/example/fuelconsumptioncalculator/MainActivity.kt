@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.fuelconsumptioncalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.fuelconsumptioncalculator.ui.theme.FuelConsumptionCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FuelConsumptionCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculatorScreen()
                }
            }
        }
    }
}

@Composable
fun CalculatorScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CalculatorInputItem("Distance")
        CalculatorInputItem("Fuel")
        CalculatorInputItem("Price")
        CalculatorOutputItem("Result")
    }

}

@Composable
fun CalculatorInputItem(label: String) {
    TextField(
        value = "",
        onValueChange = {},
        label = { Text(label) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
    )
}

@Composable
fun CalculatorOutputItem(label: String) {
    TextField(
        value = "",
        onValueChange = {},
        label = { Text(label) },
        readOnly = true
    )
}

@Preview(showBackground = true)
@Composable
fun CalculatorInputItemPreview() {
    FuelConsumptionCalculatorTheme {
        CalculatorInputItem("")
    }
}