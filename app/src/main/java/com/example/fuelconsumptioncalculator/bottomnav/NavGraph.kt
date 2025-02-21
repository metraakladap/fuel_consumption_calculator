package com.example.fuelconsumptioncalculator.bottomnav

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.fuelconsumptioncalculator.MainViewModel
import androidx.navigation.NavGraphBuilder
import com.example.fuelconsumptioncalculator.screens.HomeScreen
import com.example.fuelconsumptioncalculator.screens.SavedScreen
import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection
import androidx.compose.animation.core.tween
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavGraph(
    navController: NavHostController
) {
    AnimatedNavHost(navController, startDestination = BottomBarScreen.Home.route) {
        animatedComposable(BottomBarScreen.Home.route, enterFromRight = true)
        animatedComposable(BottomBarScreen.Saved.route, enterFromRight = false)
    }


}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.animatedComposable(route: String, enterFromRight: Boolean) {
    composable(
        route,
        enterTransition = {
            slideIntoContainer(
                if (enterFromRight) SlideDirection.Right else SlideDirection.Left,
                animationSpec = tween(500)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                if (enterFromRight) SlideDirection.Left else SlideDirection.Right,
                animationSpec = tween(500)
            )
        }
    ) {
        when (route) {
            BottomBarScreen.Home.route -> {
                val viewmodel = MainViewModel()
                HomeScreen(viewmodel)
            }
            BottomBarScreen.Saved.route -> SavedScreen()
        }
    }
}
