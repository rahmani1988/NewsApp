package com.reza.newsapp.di

import com.reza.auth.navigation.AuthFeature
import com.reza.auth.navigation.DefaultAuthFeature
import com.reza.dashboard.navigation.HomeFeature
import com.reza.dashboard.navigation.DefaultHomeFeature
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FeatureModule {

    @Binds
    abstract fun bindAuthFeature(
        defaultAuthFeature: DefaultAuthFeature
    ): AuthFeature

    @Binds
    abstract fun bindDashboardFeature(
        defaultDashboardFeature: DefaultHomeFeature
    ): HomeFeature
}