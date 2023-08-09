package com.reza.auth.navigation

import com.reza.core.navigation.Feature

interface AuthFeature : Feature {
    fun authRoute(): String
}