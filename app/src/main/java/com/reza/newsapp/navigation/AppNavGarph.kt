package com.reza.newsapp.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.reza.auth.navigation.AuthFeature
import com.reza.core.navigation.register

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ""
    ) {

        //register(feature = AuthFeature, )

        // onboarding
        composable("onboarding") {
            Box(modifier = modifier) {
                Text("onboarding")
            }
        }

        // splash
        composable("splash") {
            Box(modifier = modifier) {
                Text("splash")
            }
        }

        // auth
        composable("auth") {
            Box(modifier = modifier) {
                Text("auth")
            }
        }

        // home
        composable("dashboard") {
            Box(modifier = modifier) {
                Text("dashboard")
            }
        }

    }
}