package com.example.fuelconsumptioncalculator.bottomnav

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.fuelconsumptioncalculator.ui.theme.Purple40

@Composable
fun BottomNav() {
    val navController = rememberNavController()


}


@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Saved
    )

    val navStackBackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navStackBackEntry?.destination

    Row(
        modifier = Modifier
            .padding(8.dp)
            .background(color = Color.White)
            .fillMaxWidth()
    )
    {
        screens.forEach { screen ->
        }
    }

}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentRoute: NavDestination?,
    navController: NavHostController
){
    val selected = currentRoute?.hierarchy?.any { it.route == screen.route } == true

    val contentColor =
        if (selected) Color.White else Color.Black

    val backgroundColor =
        if (selected) Purple40.copy(alpha = 0.8f) else Color.Transparent
    Box(
      modifier = Modifier
          .height(40.dp)
          .clip(CircleShape)
          .background(color = backgroundColor)
          .clickable(onClick = {
              navController.navigate(screen.route) {
                  popUpTo(navController.graph.findStartDestination().id)
                  launchSingleTop = true
              }
          })
    ) {
        Row(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 8.dp),
        ) {

        }
    }
}
