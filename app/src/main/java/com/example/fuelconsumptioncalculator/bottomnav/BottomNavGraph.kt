package com.example.fuelconsumptioncalculator.bottomnav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

import com.example.fuelconsumptioncalculator.screens.HomeScreen
import com.example.fuelconsumptioncalculator.screens.SavedScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(navController, startDestination = BottomBarScreen.Home.route) {
        composable(BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(BottomBarScreen.Saved.route) {
            SavedScreen()
        }
    }


}

