package com.example.topacademy_android.network.data.impl

import com.example.topacademy_android.weather.data.remote.dto.WeatherResponse
object ApiClient
{
    suspend fun fetchWeather(latitude: Double, longitude: Double): WeatherResponse {
        val result = RetrofitClient.weatherApi.getWeatherForecast(longitude, latitude)
        return result
    }
}