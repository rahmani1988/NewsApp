package com.reza.onboarding.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.reza.core.model.Constants
import com.reza.onboarding.ui.OnboardingScreen

fun NavController.navigateToAuth() {
    navigate(Constants.Routes.AUTH.route) {
        popBackStack()
    }
}

fun NavGraphBuilder.onboardingFeature(
    modifier: Modifier,
    navigateToAuth: () -> Unit
) {
    composable(Constants.Routes.ON_BOARDING.route) {
        OnboardingScreen(
            modifier = modifier,
            onNavigationToAuth = navigateToAuth
        )
    }
}