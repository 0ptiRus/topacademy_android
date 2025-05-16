package com.example.topacademy_android

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.topacademy_android.databinding.CalculatorActivityBinding

class CalculatorActivity : AppCompatActivity() {
    private lateinit var binding: CalculatorActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CalculatorActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}