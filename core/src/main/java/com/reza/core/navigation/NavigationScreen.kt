package com.reza.core.navigation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.reza.core.R


const val ROUTE_DASHBOARD = "dashboard"
const val BASE_ROUTE_AUTH = "auth"

sealed class Screen(
    val route: String,
    @StringRes val title: Int = R.string.title,
    val navIcon: (@Composable () -> Unit) = {
        Icon(
            Icons.Filled.Home, contentDescription = "home"
        )
    },
    val objectName: String = "",
    val objectPath: String = ""
) {
    object Start : Screen(route = "start")

    /**
     * Auth module
     */
    object Auth : Screen(route = "auth")

    /**
     * Dashboard module
     */
    object Dashboard : Screen(route = "dashboard")
    object DashboardFlowAB: Screen(route = "dashboard/flowAB")

    object DashboardScreenA: Screen(route = "dashboard/ScreenA")
    object DashboardScreenB: Screen(route = "dashboard/ScreenB")

    object HeadlineDetails : Screen(route = "headlineDetailsScreen", objectName = "headlineID", objectPath = "/{headlineID}")

    // NavigationDrawer
    // TODO: must add navigation drawer here

    // BottomNavigation
    object HomeBottomNavigation :
        Screen(
            route = "home_bottom_navigation_screen",
            title = R.string.home_bottom_navigation,
            navIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_home),
                    contentDescription = "Home",
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .offset(x = 10.dp)
                )
            }
        )

    object SavedBottomNavigation :
        Screen(
            route = "saved_bottom_navigation_screen",
            title = R.string.saved_bottom_navigation,
            navIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_saved),
                    contentDescription = "Home",
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .offset(x = 10.dp)
                )
            }
        )
}