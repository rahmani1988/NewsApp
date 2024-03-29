package com.reza.core.data.dataSource.local

import kotlinx.coroutines.flow.Flow

interface LocalUserDataSource {
    fun isOnboardingVisited(): Flow<Boolean>

    suspend fun visitOnboarding()
}