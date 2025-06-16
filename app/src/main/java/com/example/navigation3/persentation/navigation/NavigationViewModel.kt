package com.example.navigation3.persentation.navigation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navigation3.domain.navigation.NavManager
import com.example.navigation3.domain.navigation.NavDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NavigationViewModel @Inject constructor(
    private val navigationManager: NavManager,
) : ViewModel() {

    val navigationEvents = navigationManager.navEvents

    fun navigateToHome() {
        viewModelScope.launch {
            navigationManager.navigateTo(NavDestination.Home)
        }
    }

    fun navigateToProfile() {
        viewModelScope.launch {
            navigationManager.navigateTo(NavDestination.Profile)
        }
    }

    fun navigateToUserDetail(userId: String, userName: String = "") {
        viewModelScope.launch {
            navigationManager.navigateTo(
                NavDestination.UserDetail(userId, userName)
            )
        }
    }

    fun navigateToLogin() {
        viewModelScope.launch {
            navigationManager.navigateAndClearStack(NavDestination.Login)
        }
    }

    fun navigateToDashboard() {
        viewModelScope.launch {
            navigationManager.navigateAndClearStack(NavDestination.Dashboard)
        }
    }

    fun navigateBack() {
        viewModelScope.launch {
            navigationManager.navigateBack()
        }
    }
}


