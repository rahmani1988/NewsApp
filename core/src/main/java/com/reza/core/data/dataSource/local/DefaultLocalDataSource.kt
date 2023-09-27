package com.reza.core.data.dataSource.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.reza.core.model.Constants
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

private object PreferencesKeys {
    val ONBOARDING_HAS_VISITED = booleanPreferencesKey("onboarding_has_visited")
}

class DefaultLocalDataSource @Inject constructor(private val dataStore: DataStore<Preferences>) :
    LocalUserDataSource {
    override fun hasOnboardingVisited(): Flow<Boolean> {

    }

    override suspend fun onboardingVisited() {
        dataStore.edit { preference ->
            preference[Constants.PreferencesKeys.ONBOARDING_HAS_VISITED] = true
        }
    }

}