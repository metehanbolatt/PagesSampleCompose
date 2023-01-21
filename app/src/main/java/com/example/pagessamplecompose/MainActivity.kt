package com.example.pagessamplecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.pagessamplecompose.ui.theme.PagesSampleComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PagesSampleComposeTheme {
                val navController = rememberNavController()
                SetupNavigation(navController = navController)
            }
        }
    }
}
