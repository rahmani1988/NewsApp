package com.reza.core.data.repository

import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun isOnboardingVisited(): Flow<Boolean>
    suspend fun visitOnboarding()
}