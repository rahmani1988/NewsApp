package com.reza.core.model

import androidx.datastore.preferences.core.booleanPreferencesKey

object Constants {

    /**
     * Routes
     */
    enum class Routes(val route: String) {
        ON_BOARDING("onboarding"),
        HOME("home"),
        AUTH("auth")
    }

    /**
     * Preferences keys
     */
    object PreferencesKeys {
        val ONBOARDING_HAS_VISITED = booleanPreferencesKey("onboarding_has_visited")
    }
}