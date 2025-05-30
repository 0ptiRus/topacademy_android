package com.example.topacademy_android.calculator.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.topacademy_android.calculator.domain.model.Result
import com.example.topacademy_android.calculator.domain.usecase.CalculateExpressionUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CalculatorViewModel(
    private val calculateUseCase: CalculateExpressionUseCase
) : ViewModel() {

    private val _result = MutableStateFlow<Result<Double>?>(null)
    val result: StateFlow<Result<Double>?> = _result

    fun calculateExpression(expression: String) {
        viewModelScope.launch {
            val res = calculateUseCase(expression)
            _result.value = res
        }
    }
}