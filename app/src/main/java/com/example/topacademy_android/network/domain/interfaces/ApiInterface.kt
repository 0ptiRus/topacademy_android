package com.example.topacademy_android.network.domain.interfaces

import com.example.topacademy_android.weather.data.remote.dto.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("bin/api.pl")
    suspend fun getWeatherForecast(
        @Query("lon") longitude: Double,
        @Query("lat") latitude: Double,
        @Query("product") product: String = "civillight",
        @Query("output") output: String = "json"
    ): WeatherResponse
}