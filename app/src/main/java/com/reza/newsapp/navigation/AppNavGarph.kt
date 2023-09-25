package com.reza.newsapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.reza.auth.navigation.authFeature
import com.reza.auth.navigation.navigateToHome
import com.reza.dashboard.navigation.homeFeature
import com.reza.dashboard.navigation.navigateToRouteAB
import com.reza.dashboard.navigation.onNavigateNextWithArgument
import com.reza.onboarding.navigation.onboardingFeature

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // to register onboarding module
        onboardingFeature(
            modifier = modifier,
            navigateToAuth = navController::navigateTo
        )

        // to register auth module
        authFeature(
            modifier = modifier,
            navigateToHome = navController::navigateToHome
        )

        // to register home module
        homeFeature(
            modifier = modifier,
            navigateToRouteAB = navController::navigateToRouteAB,
            onNavigateNextWithArgument = {
                navController.onNavigateNextWithArgument(it)
            }
        )
    }
}