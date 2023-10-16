package com.reza.core.data.dataSource.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.reza.core.model.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DefaultLocalUserDataSource @Inject constructor(private val dataStore: DataStore<Preferences>) :
    LocalUserDataSource {
    override fun isOnboardingVisited(): Flow<Boolean> {
        return dataStore.data.map { preferences ->
            preferences[Constants.PreferencesKeys.ONBOARDING_HAS_VISITED] ?: false
        }
    }

    override suspend fun visitOnboarding() {
        dataStore.edit { preference ->
            preference[Constants.PreferencesKeys.ONBOARDING_HAS_VISITED] = true
        }
    }
}