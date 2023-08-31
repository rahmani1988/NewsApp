package com.reza.auth.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.reza.auth.ui.AuthScreen
import com.reza.core.navigation.ROUTE_HOME

private const val ROUTE_AUTH = "auth"

fun NavController.navigateToHome() {
    navigate(ROUTE_HOME) {
        popBackStack()
    }
}

fun NavGraphBuilder.authFeature(
    modifier: Modifier,
    navigateToHome: () -> Unit
) {
    composable(ROUTE_AUTH) {
        AuthScreen(
            modifier = modifier,
            onNavigateToHomeClicked = navigateToHome
        )
    }
}