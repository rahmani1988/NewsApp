package com.reza.dashboard.navigation

import android.net.Uri
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.reza.core.navigation.ROUTE_HOME
import com.reza.dashboard.ui.HomeScreen
import com.reza.dashboard.ui.ScreenA
import com.reza.dashboard.ui.ScreenB

private const val SCENARIO_AB_ROUTE = "$ROUTE_HOME/scenarioAB"
private const val SCREEN_A_ROUTE = "$SCENARIO_AB_ROUTE/screenA"
private const val SCREEN_B_ROUTE = "$SCENARIO_AB_ROUTE/screenB"
private const val argumentKey = "arg"

fun NavController.navigateToRouteAB() {
    navigate(SCENARIO_AB_ROUTE)
}

fun NavController.onNavigateNextWithArgument(route: String) {
    navigate(route = route)
}

fun NavGraphBuilder.homeFeature(
    modifier: Modifier,
    navigateToRouteAB: () -> Unit,
    onNavigateNextWithArgument: (String) -> Unit
) {
    composable(ROUTE_HOME) {
        HomeScreen(
            modifier = modifier,
            navigateToRouteAB = navigateToRouteAB
        )
    }

    // nested graph
    navigation(
        route = SCENARIO_AB_ROUTE,
        startDestination = SCREEN_A_ROUTE
    ) {
        composable(route = SCREEN_A_ROUTE) {
            ScreenA(
                modifier = modifier,
                onNavigateNextWithArgument = { argument ->
                    val encodedArgument = Uri.encode(argument)
                    onNavigateNextWithArgument("$SCREEN_B_ROUTE/$encodedArgument")
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

