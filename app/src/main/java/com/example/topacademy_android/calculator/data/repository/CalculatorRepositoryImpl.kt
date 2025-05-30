package com.example.topacademy_android.calculator.data.repository

import com.example.topacademy_android.calculator.domain.model.Result
import com.example.topacademy_android.calculator.domain.repository.CalculatorRepository
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