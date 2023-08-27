package com.reza.newsapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.reza.auth.navigation.AuthFeature
import com.reza.core.navigation.register
import com.reza.dashboard.navigation.HomeFeature

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String,
    authFeature: AuthFeature,
    dashboardFeature: HomeFeature
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // to register auth module
        register(
            feature = authFeature,
            navController = navController,
            modifier = modifier
        )

        // to register dashboard module
        register(
            feature = dashboardFeature,
            navController = navController,
            modifier = modifier
        )
    }
}