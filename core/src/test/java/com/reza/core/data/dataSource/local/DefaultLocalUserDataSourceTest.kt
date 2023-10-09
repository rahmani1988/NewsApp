package com.reza.core.data.dataSource.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Assert.*
import org.junit.Test

class DefaultLocalUserDataSourceTest {
    // TODO should study this: https://blog.amalhanaja.dev/unit-testing-jetpack-datastore

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = UnconfinedTestDispatcher()
    private val testScope = TestScope(testDispatcher + Job())
    private val testDataStore: DataStore<Preferences> = PreferenceDataStoreFactory.create(
        scope = testScope,
        produceFile = { TODO() }
    )

    @Test
    fun whenCallingShouldShowOnboarding_thenReturnDefaultValue() {

    }

    @Test
    fun whenSetOnboarding_thenUpdateTheValue() {

    }
}