package com.example.topacademy_android.network

import com.example.topacademy_android.network.data.DataSeries
import com.example.topacademy_android.network.data.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ApiClient
{
    fun fetchWeather(latitude: Double, longitude: Double, callback: (List<DataSeries>?) -> Unit) {
        val call = RetrofitClient.weatherApi.getWeatherForecast(longitude, latitude)

        call.enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                if (response.isSuccessful) {
                    val weatherData = response.body()
                    callback(weatherData?.dataseries)
                } else {
                    println("Ошибка: ${response.code()}")
                    callback(null)
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                println("Ошибка сети: ${t.message}")
                callback(null)
            }
        })
    }


}