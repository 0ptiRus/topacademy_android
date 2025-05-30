package com.example.topacademy_android.di.presentation

import com.example.topacademy_android.calculator.presentation.viewmodel.CalculatorViewModel
import com.example.topacademy_android.weather.presentation.viewmodels.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { WeatherViewModel() }
    viewModel { CalculatorViewModel(get()) }
}