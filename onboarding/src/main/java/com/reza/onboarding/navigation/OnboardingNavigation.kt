package com.reza.onboarding.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.reza.onboarding.ui.OnboardingScreen

private const val ROUTE_ONBOARDING = "onboarding"

fun NavController.navigateToAuth() {
    navigate(ROUTE_ONBOARDING) {
        popBackStack()
    }
}

fun NavGraphBuilder.onboardingFeature(
    modifier: Modifier,
    navigateToAuth: () -> Unit
) {
    composable(ROUTE_ONBOARDING) {
        OnboardingScreen(
            modifier = modifier,
            onNavigationToAuth = navigateToAuth
        )
    }
}