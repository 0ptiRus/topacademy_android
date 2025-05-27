package com.example.topacademy_android.calculator.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CalculatorViewModel() : ViewModel()
{
    private val _result = MutableStateFlow<Result<Double>?>(null)
    val result: StateFlow<Result<Double>?> = _result

    private val calculateUseCase = CalculateExpressionUseCase(CalculatorRepositoryImpl())

    fun calculateExpression(expression: String)
    {
        viewModelScope.launch {
            val res = calculateUseCase(expression)
            _result.value = res
        }
    }
}