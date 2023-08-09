package com.reza.dashboard.navigation

import com.reza.core.navigation.Feature

interface DashboardFeature : Feature {

    fun dashboardRoute(): String
}