package com.reza.newsapp.di

import com.reza.auth.navigation.AuthFeature
import com.reza.auth.navigation.DefaultAuthFeature
import com.reza.dashboard.navigation.DashboardFeature
import com.reza.dashboard.navigation.DefaultDashboardFeature
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class FeatureModule {

    @Binds
    abstract fun bindAuthFeature(
        defaultAuthFeature: DefaultAuthFeature
    ): AuthFeature

    @Binds
    abstract fun bindDashboardFeature(
        defaultDashboardFeature: DefaultDashboardFeature
    ): DashboardFeature
}