package com.example.topacademy_android.weather.presentation.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.topacademy_android.R
import com.example.topacademy_android.databinding.WeatherItemBinding
import com.example.topacademy_android.weather.data.remote.dto.DataSeries
import java.text.SimpleDateFormat
import java.util.Locale

class ForecastViewHolder(private val binding: WeatherItemBinding) : RecyclerView.ViewHolder(binding.root)
{
    fun bind(dataSeries: DataSeries)
    {
        val context = binding.root.context

        binding.textViewDate.text = formatDate(dataSeries.date)
        binding.textViewWeather.text = dataSeries.weather
        binding.textViewMaxTemp.text = context.getString(R.string.tempTemplate, dataSeries.temp2m.max)
        binding.textViewMinTemp.text = context.getString(R.string.tempTemplate, dataSeries.temp2m.min)
        binding.textViewWindSpeed.text =
            context.getString(R.string.windTemplate, dataSeries.wind10m_max)

        val iconResId = when (dataSeries.weather) {
            "clear" -> R.drawable.clear
            "cloudy", "pcloudy", "mcloudy" -> R.drawable.cloudy
            "lightrain", "rain" -> R.drawable.rain
            "oshower", "ishower" -> R.drawable.shower
            "lightsnow", "snow" -> R.drawable.snow
            "humid" -> R.drawable.humid
            "rainsnow" -> R.drawable.rainsnow
            else -> R.drawable.clear
        }
        binding.textViewWeather.setCompoundDrawablesRelativeWithIntrinsicBounds(
            iconResId, 0, 0, 0)
    }

    private fun formatDate(date: String): String {
        val sdf = SimpleDateFormat("yyyyMMdd", Locale.US)
        val formattedDate = sdf.parse(date)
        return SimpleDateFormat("EEE, MMM d", Locale.US).format(formattedDate!!)
    }

}
