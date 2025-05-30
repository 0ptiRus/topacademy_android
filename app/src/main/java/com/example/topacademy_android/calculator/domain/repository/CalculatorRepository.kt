package com.example.topacademy_android.calculator.domain.repository

import com.example.topacademy_android.calculator.domain.model.Result

interface CalculatorRepository {
    fun calculate(expression: String): Result<Double>
}