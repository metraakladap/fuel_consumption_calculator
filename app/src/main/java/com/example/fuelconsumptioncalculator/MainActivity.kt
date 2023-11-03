@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.fuelconsumptioncalculator

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    var distanceValue by remember { mutableStateOf("") }
    var averageFuelConsumptionValue by remember { mutableStateOf("") }
    var priceValue by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }




    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize(),

        ) {
        distanceValue = CalculatorInputItem("Distance")
        averageFuelConsumptionValue = CalculatorInputItem("Average Fuel Consumption")
        priceValue = CalculatorInputItem("Price")
        CalculatorOutputItem("Result", result)

        result = try {
            val distance = distanceValue.toDouble()
            val averageFuelConsumption = averageFuelConsumptionValue.toDouble()
            val price = priceValue.toDouble()
            (distance / 100 * averageFuelConsumption * price).toString()

        } catch (e: Exception) {
            "Please enter all values"
        }

    }

}


@Composable
fun CalculatorInputItem(label: String): String {
    var value by remember { mutableStateOf("") }

    OutlinedTextField(
        value = value,
        onValueChange = { newValue ->
            value = newValue
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
    return value
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

@Preview(showBackground = true)
@Composable
fun CalculatorInputItemPreview() {
    FuelConsumptionCalculatorTheme {
        CalculatorInputItem("Price")
    }
}