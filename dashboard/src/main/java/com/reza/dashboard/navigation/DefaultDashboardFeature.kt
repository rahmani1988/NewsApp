package com.reza.dashboard.navigation

import android.net.Uri
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.reza.core.navigation.ROUTE_DASHBOARD
import com.reza.dashboard.ui.DashboardScreen
import com.reza.dashboard.ui.ScreenA
import com.reza.dashboard.ui.ScreenB
import javax.inject.Inject

private const val SCENARIO_AB_ROUTE = "$ROUTE_DASHBOARD/scenarioAB"
private const val SCREEN_A_ROUTE = "$SCENARIO_AB_ROUTE/screenA"
private const val SCREEN_B_ROUTE = "$SCENARIO_AB_ROUTE/screenB"
private const val argumentKey = "arg"

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
            startDestination = SCREEN_A_ROUTE
        ) {
            composable(route = SCREEN_A_ROUTE) {
                ScreenA(
                    modifier = modifier,
                    onNavigateNextWithArgument = { argument ->
                        val encodedArgument = Uri.encode(argument)
                        navController.navigate(route = "$SCREEN_B_ROUTE/$encodedArgument")
                    }
                )
            }

            composable(
                route = "$SCREEN_B_ROUTE/{$argumentKey}",
                arguments = listOf(
                    navArgument(argumentKey) {
                        type = NavType.StringType
                    }
                )
            ) { backStackEntry ->
                val arguments = requireNotNull(backStackEntry.arguments)
                val argument = Uri.decode(arguments.getString(argumentKey).orEmpty())

                ScreenB(
                    modifier = modifier,
                    argument = argument.orEmpty()
                )
            }
        }
    }
}