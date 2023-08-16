package com.reza.dashboard.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.reza.core.navigation.ROUTE_DASHBOARD
import com.reza.dashboard.ui.DashboardScreen
import javax.inject.Inject

private const val SCENARIO_AB_ROUTE = "$ROUTE_DASHBOARD/scenarioAB"
private const val A_SCREEN_ROUTE = "$SCENARIO_AB_ROUTE/aScreen"
private const val B_SCREEN_ROUTE = "$SCENARIO_AB_ROUTE/bScreen"

class DefaultDashboardFeature @Inject constructor() : DashboardFeature {
    override fun dashboardRoute() = ROUTE_DASHBOARD

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        /**
         * To navigate to dashboard module from other modules
         */
        navGraphBuilder.composable(ROUTE_DASHBOARD) {
            DashboardScreen(
                modifier = modifier
            ) {
                navController.navigate(SCENARIO_AB_ROUTE)
            }
        }

        /**
         * Nested graph for internal navigation in dashboard module
         */
        navGraphBuilder.navigation(
            route = SCENARIO_AB_ROUTE,
            startDestination = A_SCREEN_ROUTE
        ) {
            // TODO: To Add A and B composable functions and handle navigation here
        }
    }
}