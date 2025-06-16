package com.example.navigation3.domain.navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class NavManagerImpl @Inject constructor() : NavManager {

    private val _navEvents = MutableSharedFlow<NavEvents>()
    override val navEvents: SharedFlow<NavEvents> = _navEvents.asSharedFlow()

    override suspend fun navigateTo(
        destination: NavDestination,
        clearBackStack: Boolean,
    ) {
        _navEvents.emit(
            NavEvents.NavigateTo(destination, clearBackStack)
        )
    }

    override suspend fun navigateBack() {
        _navEvents.emit(NavEvents.NavigateBack)
    }

    override suspend fun navigateBackTo(
        destination: NavDestination,
        inclusive: Boolean,
    ) {
        _navEvents.emit(
            NavEvents.NavigateBackTo(destination, inclusive)
        )
    }

    override suspend fun navigateAndClearStack(destination: NavDestination) {
        _navEvents.emit(
            NavEvents.NavigateAndClearStack(destination)
        )
    }

    override suspend fun showBottomSheet(destination: NavDestination) {
        _navEvents.emit(
            NavEvents.ShowBottomSheet(destination)
        )
    }

    override suspend fun dismissBottomSheet() {
        _navEvents.emit(NavEvents.DismissBottomSheet)
    }
}