package com.reza.auth.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.reza.core.navigation.Feature
import com.reza.core.navigation.Screen

interface AuthFeature : Feature {
    fun authRoute(): String
}

class DefaultAuthFeature : AuthFeature {

    private val baseRoute = Screen.Auth.route

    override fun authRoute(): String {
        return baseRoute
    }

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(baseRoute) {
            //AuthScreen(modifier = modifier, navController = navController)
        }
    }

}