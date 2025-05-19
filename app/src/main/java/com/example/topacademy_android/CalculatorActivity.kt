package com.example.topacademy_android

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.example.topacademy_android.databinding.CalculatorActivityBinding

class CalculatorActivity : AppCompatActivity() {
    private lateinit var binding: CalculatorActivityBinding

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
    }

}