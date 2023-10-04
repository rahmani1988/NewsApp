package com.reza.core.data.di

import com.reza.core.data.dataSource.local.DefaultLocalUserDataSource
import com.reza.core.data.dataSource.local.LocalUserDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class ActivityRetainedModule {

    @Binds
    abstract fun bindLocalDataSource(
        defaultLocalUserDataSource: DefaultLocalUserDataSource
    ) : LocalUserDataSource

}