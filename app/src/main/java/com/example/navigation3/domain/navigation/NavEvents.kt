package com.example.navigation3.domain.navigation

sealed class NavEvents {
    data class NavigateTo(
        val destination: NavDestination,
        val clearBackStack: Boolean = false,
    ) : NavEvents()

    object NavigateBack : NavEvents()

    data class NavigateBackTo(
        val destination: NavDestination,
        val inclusive: Boolean = false,
    ) : NavEvents()

    data class NavigateAndClearStack(
        val destination: NavDestination,
    ) : NavEvents()

    data class ShowBottomSheet(
        val destination: NavDestination,
    ) : NavEvents()

    object DismissBottomSheet : NavEvents()
}