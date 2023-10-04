package com.reza.core.data.dataSource.local

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DefaultLocalUserDataSourceTest {

    private val testContext: Context =
        InstrumentationRegistry.getInstrumentation().targetContext

    private val testCoroutineDispatcher: TestCoroutineDispatcher =
        TestCoroutineDispatcher()
}