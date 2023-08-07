package com.reza.newsapp.di

import com.reza.auth.navigation.AuthFeature
import com.reza.auth.navigation.DefaultAuthFeature
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class AuthFeatureModule {

    @Binds
    abstract fun bindAuthFeature(
        defaultAuthFeature: DefaultAuthFeature
    ): AuthFeature
}