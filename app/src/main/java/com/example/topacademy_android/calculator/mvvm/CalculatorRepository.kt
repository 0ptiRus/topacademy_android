package com.example.topacademy_android.calculator.mvvm

import net.objecthunter.exp4j.ExpressionBuilder

interface CalculatorRepository
{
    fun calculate(expression: String): Result<Double>
}