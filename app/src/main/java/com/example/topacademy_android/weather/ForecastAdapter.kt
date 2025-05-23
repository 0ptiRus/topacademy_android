package com.example.topacademy_android.weather

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.topacademy_android.databinding.WeatherItemBinding
import com.example.topacademy_android.network.data.DataSeries

class ForecastAdapter(private var forecastList: List<DataSeries>)
    :
    RecyclerView.Adapter<ForecastViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val binding = WeatherItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ForecastViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
       holder.bind(forecastList[position])
    }

    override fun getItemCount() = forecastList.size


    fun updateList(newList: List<DataSeries>) {
        forecastList = newList
        notifyDataSetChanged()
    }
}