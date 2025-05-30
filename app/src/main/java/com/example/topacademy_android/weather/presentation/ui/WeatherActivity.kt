package com.example.topacademy_android.weather.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.topacademy_android.R
import com.example.topacademy_android.databinding.WeatherActivityBinding
import com.example.topacademy_android.weather.presentation.adapters.ForecastAdapter
import com.example.topacademy_android.weather.presentation.viewmodels.WeatherViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherActivity : AppCompatActivity() {
    private lateinit var binding: WeatherActivityBinding
    private lateinit var adapter: ForecastAdapter
    private val viewModel: WeatherViewModel by viewModel()

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

        adapter = ForecastAdapter(emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        binding.recyclerView.adapter = adapter
        viewModel.loadWeather(23.09, 113.17)

        viewModel.forecast.observe(this) { forecast ->
            forecast?.let {
                adapter.updateList(it)
            }
        }
    }


}