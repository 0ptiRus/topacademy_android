package com.example.topacademy_android.calculator.presentation.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.topacademy_android.calculator.domain.model.Result
import com.example.topacademy_android.calculator.presentation.viewmodel.CalculatorViewModel
import com.example.topacademy_android.databinding.CalculatorActivityBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CalculatorFragment : Fragment() {
    private var _binding: CalculatorActivityBinding? = null

    private val binding get() = _binding!!
    private val viewModel: CalculatorViewModel by viewModel()
    private var isExpressionCalculated: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = CalculatorActivityBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    @SuppressLint("UnsafeRepeatOnLifecycleDetector")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
                            Toast.makeText(requireContext(), "Ошибка", Toast.LENGTH_SHORT).show()
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
            if (isExpressionCalculated) {
                binding.resultDisplay.text = ""
                isExpressionCalculated = false
            }

            val button = view as Button
            binding.resultDisplay.append(button.text)
        }

        buttons.forEach { b -> b.setOnClickListener(listener) }

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