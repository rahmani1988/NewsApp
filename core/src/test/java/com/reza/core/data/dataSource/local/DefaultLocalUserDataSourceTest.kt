package com.reza.core.data.dataSource.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder

@OptIn(ExperimentalCoroutinesApi::class)
class DefaultLocalUserDataSourceTest {

    @get:Rule
    val tmpFolder: TemporaryFolder = TemporaryFolder
        .builder()
        .assureDeletion()
        .build()

    private val testDispatcher = UnconfinedTestDispatcher()
    private val testScope = TestScope(testDispatcher + Job())

    private val testDataStore: DataStore<Preferences> = PreferenceDataStoreFactory.create(
        scope = testScope,
        produceFile = { tmpFolder.newFile("user.preferences_pb") }
    )
    private val defaultLocalUserDataSource = DefaultLocalUserDataSource(dataStore = testDataStore)

    @Test
    fun whenCallingShouldShowOnboardingForTheFirstTime_thenReturnDefaultValue() =
        testScope.runTest {
            // Given

            // When
            val isOnboardingVisited = defaultLocalUserDataSource.isOnboardingVisited().first()

            // Then
            Truth.assertThat(isOnboardingVisited).isFalse()
        }

    @Test
    fun whenSetVisitOnboarding_thenUpdateTheValueToTrue() = testScope.runTest {
        // Given

        // When
        defaultLocalUserDataSource.visitOnboarding()

        // Then
        Truth.assertThat(defaultLocalUserDataSource.isOnboardingVisited().first()).isTrue()
    }
}