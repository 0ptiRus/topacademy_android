package com.example.topacademy_android.calculator.domain.usecase

import com.example.topacademy_android.calculator.domain.model.Result
import com.example.topacademy_android.calculator.domain.repository.CalculatorRepository

class CalculateExpressionUseCase(private val repository: CalculatorRepository)
{
    operator fun invoke(expression: String): Result<Double>
    {
        return repository.calculate(expression)
    }
}