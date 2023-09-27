package com.reza.auth.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.reza.auth.ui.AuthScreen
import com.reza.core.model.Constants

fun NavController.navigateToHome() {
    navigate(Constants.Routes.HOME.route) {
        popBackStack()
    }
}

fun NavGraphBuilder.authFeature(
    modifier: Modifier,
    navigateToHome: () -> Unit
) {
    composable(Constants.Routes.AUTH.route) {
        AuthScreen(
            modifier = modifier,
            onNavigateToHomeClicked = navigateToHome
        )
    }
}