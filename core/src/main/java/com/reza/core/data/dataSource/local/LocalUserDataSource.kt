package com.reza.core.data.dataSource.local

import kotlinx.coroutines.flow.Flow

interface LocalUserDataSource {
    fun shouldShowOnboarding(): Flow<Boolean>

    suspend fun onboardingVisited()
}