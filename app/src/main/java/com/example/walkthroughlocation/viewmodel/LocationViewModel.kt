package com.example.walkthroughlocation.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.walkthroughlocation.model.LocationLiveData

class LocationViewModel (context: Context) : ViewModel() {
    private val locationLiveData = LocationLiveData(context)
    fun getLocationLiveData() = locationLiveData
}