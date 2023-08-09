package com.reza.auth.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.reza.auth.ui.AuthScreen
import com.reza.core.navigation.Screen
import javax.inject.Inject

class DefaultAuthFeature @Inject constructor() : AuthFeature {

    private val baseRoute = Screen.Auth.route

    override fun authRoute() = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(baseRoute) {
            AuthScreen(
                modifier = modifier,
                navController = navController
            ) {
                navController.popBackStack()
                navController.navigate(Screen.Dashboard.route)
            }
        }
    }
}