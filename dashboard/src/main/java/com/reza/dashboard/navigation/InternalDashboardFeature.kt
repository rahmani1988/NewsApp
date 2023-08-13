package com.reza.dashboard.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.reza.core.navigation.Feature

class InternalDashboardFeature : Feature {

    private val scenarioABRoute = "home/scenarioABRoute"
    private val parameterKey = "parameterKey"

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {

    }
}