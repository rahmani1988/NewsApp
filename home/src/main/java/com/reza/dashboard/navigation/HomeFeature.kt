package com.reza.dashboard.navigation

import com.reza.core.navigation.Feature

interface HomeFeature : Feature {

    fun dashboardRoute(): String
}