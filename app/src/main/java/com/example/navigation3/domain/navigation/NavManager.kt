package com.example.navigation3.domain.navigation

import kotlinx.coroutines.flow.SharedFlow

interface NavManager {
    val navEvents: SharedFlow<NavEvents>

    suspend fun navigateTo(
        destination: NavDestination,
        clearBackStack: Boolean = false
    )

    suspend fun navigateBack()

    suspend fun navigateBackTo(
        destination: NavDestination,
        inclusive: Boolean = false
    )

    suspend fun navigateAndClearStack(destination: NavDestination)

    suspend fun showBottomSheet(destination: NavDestination)

    suspend fun dismissBottomSheet()
}