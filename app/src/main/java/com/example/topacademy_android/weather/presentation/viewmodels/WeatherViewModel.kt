package com.example.topacademy_android.weather.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.topacademy_android.network.data.impl.ApiClient
import com.example.topacademy_android.weather.data.remote.dto.DataSeries
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val _forecast = MutableLiveData<List<DataSeries>>()
    val forecast: LiveData<List<DataSeries>> get() = _forecast


    fun loadWeather(latitude: Double, longitude: Double) {
        viewModelScope.launch {
            val result = ApiClient.fetchWeather(latitude, longitude)
            _forecast.value = result.dataseries
        }
    }
}