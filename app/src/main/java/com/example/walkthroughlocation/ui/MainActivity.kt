package com.example.walkthroughlocation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.walkthroughlocation.ui.screens.LocationScreen
import com.example.walkthroughlocation.ui.theme.WalkthroughLocationTheme
import com.example.walkthroughlocation.viewmodel.LocationViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val locationViewModel = LocationViewModel(this)
        enableEdgeToEdge()
        setContent {
            WalkthroughLocationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LocationScreen(

                        modifier = Modifier.padding(innerPadding),
                        viewModel = locationViewModel
                    )
                }
            }
        }
    }
}

