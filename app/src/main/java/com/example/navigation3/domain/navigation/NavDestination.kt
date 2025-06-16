package com.example.navigation3.domain.navigation

import kotlinx.serialization.Serializable


@Serializable
sealed class NavDestination {
    @Serializable
    data object Home : NavDestination()

    @Serializable
    data object Profile : NavDestination()

    @Serializable
    data object Settings : NavDestination()

    @Serializable
    data class UserDetail(
        val userId: String,
        val userName: String = "",
    ) : NavDestination()

    @Serializable
    data class ProductDetail(
        val productId: String,
        val categoryId: String? = null,
    ) : NavDestination()

    @Serializable
    data object Login : NavDestination()

    @Serializable
    data object Register : NavDestination()

    @Serializable
    data object Dashboard : NavDestination()
}
