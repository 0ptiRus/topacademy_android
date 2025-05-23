package com.example.topacademy_android.network.data

data class WeatherResponse(
    val product: String,
    val init: String,
    val dataseries: List<DataSeries>
)

data class DataSeries(
    val date: String,
    val weather: String,
    val temp2m: Temp2m,
    val wind10m_max: Int,
)
{
    override fun toString(): String {
        return "Date: " + date + "\nWeather: " + weather + "\nMax temp: " + temp2m.max + "\nMin " +
                "temp: " +  temp2m.min + "\nMax wind: " + wind10m_max + "\n\n"
    }
}

data class Temp2m(
    val max: Int,
    val min : Int,
)