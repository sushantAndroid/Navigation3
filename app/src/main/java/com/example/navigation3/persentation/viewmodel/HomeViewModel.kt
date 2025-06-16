package com.example.navigation3.persentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navigation3.domain.navigation.NavDestination
import com.example.navigation3.domain.navigation.NavManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject // Changed from jakarta.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val navigationManager: NavManager,
    private val userRepository: UserRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        refresh()
    }

    fun navigateToProfile() {
        viewModelScope.launch {
            navigationManager.navigateTo(NavDestination.Profile)
        }
    }

    fun navigateToUserDetail(userId: String, userName: String) {
        viewModelScope.launch {
            navigationManager.navigateTo(
                NavDestination.UserDetail(userId, userName)
            )
        }
    }

    fun navigateToSettings() {
        viewModelScope.launch {
            navigationManager.navigateTo(NavDestination.Settings)
        }
    }

    fun navigateToDashboard() {
        viewModelScope.launch {
            navigationManager.navigateAndClearStack(NavDestination.Dashboard)
        }
    }

    fun navigateToRegister() {
        viewModelScope.launch {
            navigationManager.navigateTo(NavDestination.Register)
        }
    }

    fun navigateBack() {
        viewModelScope.launch {
            navigationManager.navigateBack()
        }
    }

    fun refresh() {
        loadUsers()
    }

    private fun loadUsers() {
        viewModelScope.launch {
            _uiState.value = HomeUiState.Loading
            try {
                val users = userRepository.getUsers()
                _uiState.value = HomeUiState.Success(users)
            } catch (e: Exception) {
                _uiState.value = HomeUiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}

sealed class HomeUiState {
    object Loading : HomeUiState()
    data class Success(val users: List<User>) : HomeUiState()
    data class Error(val message: String) : HomeUiState()
}

interface UserRepository {
    suspend fun getUsers(): List<User>
    suspend fun getUserById(id: String): User?
}

// Add the missing UserRepository implementation
@Singleton
class UserRepositoryImpl @Inject constructor() : UserRepository {

    override suspend fun getUsers(): List<User> {
        // Replace this with your actual data source (API, database, etc.)
        // This is just mock data for demonstration
        return listOf(
            User("1", "John Doe", "john@example.com", "https://example.com/avatar1.jpg"),
            User("2", "Jane Smith", "jane@example.com", "https://example.com/avatar2.jpg"),
            User("3", "Bob Johnson", "bob@example.com", "https://example.com/avatar3.jpg")
        )
    }

    override suspend fun getUserById(id: String): User? {
        return getUsers().find { it.id == id }
    }
}

data class User(
    val id: String,
    val name: String,
    val email: String,
    val avatarUrl: String? = null
)

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl // Fixed: bind to the implementation class
    ): UserRepository
}

