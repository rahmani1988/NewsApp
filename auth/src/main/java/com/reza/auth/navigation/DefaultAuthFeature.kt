package com.reza.auth.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.reza.auth.ui.AuthScreen
import com.reza.core.navigation.BASE_ROUTE_AUTH
import com.reza.core.navigation.ROUTE_DASHBOARD
import javax.inject.Inject

class DefaultAuthFeature @Inject constructor() : AuthFeature {

    private val baseRoute = BASE_ROUTE_AUTH

    override fun authRoute() = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(baseRoute) {
            AuthScreen(
                modifier = modifier
            ) {
                // navigate to dashboard
                navController.popBackStack()
                navController.navigate(ROUTE_DASHBOARD)
            }
        }
    }
}