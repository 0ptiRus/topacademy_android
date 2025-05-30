package com.example.topacademy_android.di

import com.example.topacademy_android.calculator.data.repository.CalculatorRepositoryImpl
import com.example.topacademy_android.calculator.domain.repository.CalculatorRepository
import com.example.topacademy_android.calculator.domain.usecase.CalculateExpressionUseCase
import com.example.topacademy_android.calculator.presentation.viewmodel.CalculatorViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val calculatorModule = module {
    factory<CalculatorRepository> { CalculatorRepositoryImpl() }
    factory { CalculateExpressionUseCase(get()) }
    viewModel { CalculatorViewModel(get()) }
}