package com.reza.dashboard.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    navigateToRouteAB: () -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Column {
            Text("Dashboard Screen")
            Button(onClick = navigateToRouteAB) {
                Text(text = "Navigate to RouteAB")
            }
        }
    }
}