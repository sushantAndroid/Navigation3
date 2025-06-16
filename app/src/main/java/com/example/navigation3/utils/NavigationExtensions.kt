package com.example.navigation3.utils

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavOptionsBuilder
import com.example.navigation3.domain.navigation.NavDestination

fun NavController.navigateToDestination(
    destination: NavDestination,
    builder: NavOptionsBuilder.() -> Unit = {}
) {
    navigate(destination, builder)
}

fun NavController.navigateAndClearStack(destination: NavDestination) {
    navigate(destination) {
        popUpTo(graph.findStartDestination().id) {
            inclusive = true
        }
        launchSingleTop = true
    }
}

fun NavController.navigateSingleTop(destination: NavDestination) {
    navigate(destination) {
        launchSingleTop = true
        restoreState = true
    }
}

fun NavController.navigateBackTo(
    destination: NavDestination,
    inclusive: Boolean = false
) {
    popBackStack(destination, inclusive)
}


