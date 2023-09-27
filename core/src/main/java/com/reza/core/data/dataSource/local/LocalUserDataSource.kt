package com.reza.core.data.dataSource.local

import kotlinx.coroutines.flow.Flow

interface LocalUserDataSource {
    fun hasOnboardingVisited(): Flow<Boolean>

    suspend fun onboardingVisited()
}