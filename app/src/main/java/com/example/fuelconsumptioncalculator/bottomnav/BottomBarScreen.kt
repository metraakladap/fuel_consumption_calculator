package com.example.fuelconsumptioncalculator.bottomnav

import com.example.fuelconsumptioncalculator.R

sealed class BottomBarScreen(
    val route: String,
    val icon: Int,
    val title: String,
    val icon_focused: Int
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.ic_bottom_home,
        icon_focused = R.drawable.ic_bottom_home_focused
    )

    object Saved : BottomBarScreen(
        route = "saved",
        title = "Saved",
        icon = R.drawable.ic_bottom_saved,
        icon_focused = R.drawable.ic_bottom_saved
    )
}

