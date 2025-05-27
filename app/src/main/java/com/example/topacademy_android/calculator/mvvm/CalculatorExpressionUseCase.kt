package com.example.topacademy_android.calculator.mvvm

class CalculateExpressionUseCase(private val repository: CalculatorRepository)
{
    suspend operator fun invoke(expression: String): Result<Double>
    {
        return repository.calculate(expression)
    }
}