package com.example.walkthroughlocation.ui.screens

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import com.example.walkthroughlocation.viewmodel.LocationViewModel


@Composable
fun LocationScreen(modifier:Modifier, viewModel: LocationViewModel) {
    // var location by remember { mutableStateOf("No location")}
    val location by viewModel.getLocationLiveData().observeAsState()
    if (location !== null) {
        // do something
    }
    val requestPermissionLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission(),
            onResult = {
                isGranted: Boolean ->
                if (isGranted){
                    viewModel.getLocationLiveData().getLocationData()
                }
            }
        )
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text = "Latitude: " + location?.latitude.toString(),
            modifier = Modifier.padding(top = 24.dp)
        )
        Text(
            text = "Longitude: " + location?.longitude.toString(),
            modifier = Modifier.padding(top = 8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                requestPermissionLauncher.launch(android
                    .Manifest.permission.ACCESS_FINE_LOCATION)
            }
        ) {
            Text("Get location")
        }
    }
}