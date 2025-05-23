package com.example.topacademy_android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.topacademy_android.databinding.WeatherActivityBinding
import com.example.topacademy_android.network.ApiClient
import com.example.topacademy_android.weather.ForecastAdapter

class WeatherActivity : AppCompatActivity() {
    private lateinit var binding: WeatherActivityBinding
    private lateinit var adapter: ForecastAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = WeatherActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = "Weather"
            setDisplayHomeAsUpEnabled(true)
        }

        toolbar.setNavigationIcon(android.R.drawable.arrow_up_float)
        toolbar.navigationIcon?.setTint(ContextCompat.getColor(this, R.color.black))

        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        adapter = ForecastAdapter(emptyList())
        binding.recyclerView.adapter = adapter

        ApiClient.fetchWeather(23.09, 113.17) { forecastList ->
            forecastList?.let {
                adapter.updateList(it)
            } ?: run {

            }
        }
    }


}