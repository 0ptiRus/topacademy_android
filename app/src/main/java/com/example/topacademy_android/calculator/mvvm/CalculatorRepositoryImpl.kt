package com.example.topacademy_android.calculator.mvvm

import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorRepositoryImpl : CalculatorRepository
{
    override fun calculate(expression: String): Result<Double>
    {
        return try {
            val exp = ExpressionBuilder(expression).build()
            val result = exp.evaluate()
            Result.Success(result)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}