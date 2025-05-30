package com.example.topacademy_android.calculator.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.topacademy_android.R
import com.example.topacademy_android.calculator.domain.model.Result
import com.example.topacademy_android.calculator.presentation.viewmodel.CalculatorViewModel
import com.example.topacademy_android.databinding.CalculatorActivityBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CalculatorActivity : AppCompatActivity() {
    private lateinit var binding: CalculatorActivityBinding
    private val viewModel: CalculatorViewModel by viewModel()
    private var isExpressionCalculated : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CalculatorActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = "Calculator"
            setDisplayHomeAsUpEnabled(true)
        }

        toolbar.setNavigationIcon(android.R.drawable.arrow_up_float)
        toolbar.navigationIcon?.setTint(ContextCompat.getColor(this, R.color.black))

        val expressionEditText = binding.resultDisplay

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.result.collect { result ->
                    when (result) {
                        is Result.Success -> {
                            expressionEditText.text = result.data.toString()
                            isExpressionCalculated = true
                        }
                        is Result.Error -> {
                            Log.d("Expression error", expressionEditText.text.toString())
                            Toast.makeText(this@CalculatorActivity, "Ошибка", Toast.LENGTH_SHORT).show()
                        }
                        null -> {}
                    }
                }
            }
        }

        setupButtons()
    }


    private fun setupButtons() {
        val buttons = listOf(
            binding.button0, binding.button1, binding.button2, binding.button3,
            binding.button4, binding.button5, binding.button6,
            binding.button7, binding.button8, binding.button9,
            binding.buttonPlus, binding.buttonMinus, binding.buttonMultiply,
            binding.buttonDivide, binding.buttonPercent, binding.buttonDot
        )

        val listener = View.OnClickListener { view ->
            if(isExpressionCalculated)
            {
                binding.resultDisplay.text = ""
                isExpressionCalculated = false
            }

            val button = view as Button
            binding.resultDisplay.append(button.text)
        }

        buttons.forEach { b -> b.setOnClickListener(listener)}

        binding.buttonC.setOnClickListener {
            binding.resultDisplay.text = ""
        }

        binding.buttonBackspace.setOnClickListener {
            val text = binding.resultDisplay.text
            binding.resultDisplay.text = text.dropLast(1)
        }

        binding.buttonEquals.setOnClickListener {
            val expr = binding.resultDisplay.text.toString()
            Log.d("Button equals", "Given expression: " + binding.resultDisplay.text.toString())
            if (expr.isNotBlank()) {
                viewModel.calculateExpression(expr)
            }
        }
    }


}