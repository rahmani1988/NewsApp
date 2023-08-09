package com.reza.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.reza.auth.navigation.AuthFeature
import com.reza.core.navigation.Screen
import com.reza.dashboard.navigation.DashboardFeature
import com.reza.newsapp.navigation.AppNavGraph
import com.reza.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var authFeature: AuthFeature

    @Inject
    lateinit var dashboardFeature: DashboardFeature

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {
                val navController = rememberNavController()
                Scaffold { innerPaddingModifier ->
                    AppNavGraph(
                        startDestination = Screen.Auth.route,
                        navController = navController,
                        modifier = Modifier.padding(innerPaddingModifier),
                        authFeature = authFeature,
                        dashboardFeature = dashboardFeature
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