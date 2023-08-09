package com.reza.dashboard.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.reza.core.navigation.Screen
import com.reza.dashboard.ui.DashboardScreen
import javax.inject.Inject

class DefaultDashboardFeature @Inject constructor() : DashboardFeature {

    private val baseRoute = Screen.Dashboard.route

    override fun dashboardRoute() = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(baseRoute) {
            DashboardScreen(
                modifier = modifier,
                navController = navController
            )
        }
    }
}