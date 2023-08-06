package com.reza.core.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

fun NavGraphBuilder.register(
    feature: Feature,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    feature.registerGraph(
        navGraphBuilder = this,
        navController = navController,
        modifier = modifier
    )
}