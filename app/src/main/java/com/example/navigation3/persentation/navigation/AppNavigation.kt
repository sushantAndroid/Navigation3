package com.example.navigation3.persentation.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.navigation3.domain.navigation.NavDestination
import com.example.navigation3.domain.navigation.NavEvents
import com.example.navigation3.persentation.view.DashboardScreen
import com.example.navigation3.persentation.view.HomeScreen
import com.example.navigation3.persentation.view.LoginScreen
import com.example.navigation3.persentation.view.ProductDetailScreen
import com.example.navigation3.persentation.view.ProfileScreen
import com.example.navigation3.persentation.view.RegisterScreen
import com.example.navigation3.persentation.view.SettingsBottomSheetContent
import com.example.navigation3.persentation.view.SettingsScreen
import com.example.navigation3.persentation.view.UserDetailScreen
import com.example.navigation3.utils.navigateAndClearStack
import com.example.navigation3.utils.navigateBackTo
import com.example.navigation3.utils.navigateToDestination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    navigationViewModel: NavigationViewModel
) {
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    var showBottomSheet by remember { mutableStateOf(false) }
    var bottomSheetDestination by remember { mutableStateOf<NavDestination?>(null) }

    // Handle navigation events
    LaunchedEffect(navigationViewModel) {
        navigationViewModel.navigationEvents.collect { event ->
            when (event) {
                is NavEvents.NavigateTo -> {
                    if (event.clearBackStack) {
                        navController.navigateAndClearStack(event.destination)
                    } else {
                        navController.navigateToDestination(event.destination)
                    }
                }

                is NavEvents.NavigateBack -> {
                    navController.popBackStack()
                }

                is NavEvents.NavigateBackTo -> {
                    navController.navigateBackTo(event.destination, event.inclusive)
                }

                is NavEvents.NavigateAndClearStack -> {
                    navController.navigateAndClearStack(event.destination)
                }

                is NavEvents.ShowBottomSheet -> {
                    bottomSheetDestination = event.destination
                    showBottomSheet = true
                }

                is NavEvents.DismissBottomSheet -> {
                    showBottomSheet = false
                }
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = NavDestination.Home
    ) {
        composable<NavDestination.Home> {
            HomeScreen()
        }

        composable<NavDestination.Profile> {
            ProfileScreen()
        }

        composable<NavDestination.Settings> {
            SettingsScreen()
        }

        composable<NavDestination.UserDetail> { backStackEntry ->
            val userDetail = backStackEntry.toRoute<NavDestination.UserDetail>()
            UserDetailScreen(
                userId = userDetail.userId,
                userName = userDetail.userName
            )
        }

        composable<NavDestination.ProductDetail> { backStackEntry ->
            val productDetail = backStackEntry.toRoute<NavDestination.ProductDetail>()
            ProductDetailScreen(
                productId = productDetail.productId,
                categoryId = productDetail.categoryId.toString()
            )
        }

        composable<NavDestination.Login> {
            LoginScreen()
        }

        composable<NavDestination.Register> {
            RegisterScreen()
        }

        composable<NavDestination.Dashboard> {
            DashboardScreen()
        }
    }

    // Bottom Sheet Modal
    if (showBottomSheet && bottomSheetDestination != null) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = bottomSheetState
        ) {
            when (bottomSheetDestination) {
                is NavDestination.Settings -> {
                    SettingsBottomSheetContent()
                }
                // Add other bottom sheet content
                else -> {
                    Text("Bottom sheet content")
                }
            }
        }
    }
}