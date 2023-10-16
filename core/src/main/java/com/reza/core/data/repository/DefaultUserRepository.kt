package com.reza.core.data.repository

import com.reza.core.data.dataSource.local.LocalUserDataSource
import com.reza.core.data.dataSource.remote.RemoteUserDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultUserRepository @Inject constructor(
    private val localUserDataSource: LocalUserDataSource,
    private val remoteUserDataSource: RemoteUserDataSource
) : UserRepository {
    override fun isOnboardingVisited(): Flow<Boolean> {
        return localUserDataSource.isOnboardingVisited()
    }

    override suspend fun visitOnboarding() {
        localUserDataSource.visitOnboarding()
    }
}