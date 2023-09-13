package com.reza.newsapp.ui

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.rememberNavController
import com.reza.core.navigation.BASE_ROUTE_AUTH
import com.reza.newsapp.navigation.AppNavGraph
import com.reza.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Enable support for Splash Screen API for proper Android 12+ support
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                return@setKeepOnScreenCondition mainViewModel.isLoading.value
            }
        }
        setContent {
            NewsAppTheme {
                val navController = rememberNavController()
                Scaffold { innerPaddingModifier ->
                    AppNavGraph(
                        startDestination = BASE_ROUTE_AUTH,
                        navController = navController,
                        modifier = Modifier.padding(innerPaddingModifier)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsAppTheme {
        Greeting("Android")
    }
}