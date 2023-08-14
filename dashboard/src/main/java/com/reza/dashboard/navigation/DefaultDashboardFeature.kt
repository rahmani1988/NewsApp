package com.reza.dashboard.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.reza.core.navigation.Screen
import com.reza.dashboard.ui.DashboardScreen
import javax.inject.Inject

class DefaultDashboardFeature @Inject constructor() : DashboardFeature {

    private val baseRoute = Screen.Dashboard.route
    private val routeAB = "$baseRoute/RouteAB"
    override fun dashboardRoute() = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        /**
         * To navigate to dashboard module from other modules
         */
        navGraphBuilder.composable(baseRoute) {
            DashboardScreen(
                modifier = modifier,
                navController = navController
            )
        }

        /**
         * Nested graph for internal navigation in dashboard module
         */
        navGraphBuilder.navigation(
            route = routeAB,
            startDestination = ""
        ) {

        }

    }
}