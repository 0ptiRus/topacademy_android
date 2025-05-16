package com.example.topacademy_android

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.topacademy_android.databinding.HomeActivityBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: HomeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun onCalculatorButtonClick(view: View?) {
        val intent = Intent(this, CalculatorActivity::class.java)
        startActivity(intent)
    }

    fun onListButtonClick(view: View?) {
        val intent = Intent(this, ListActivity::class.java)
        startActivity(intent)
    }

    fun onWeatherButtonClick(view: View?) {
        val intent = Intent(this, WeatherActivity::class.java)
        startActivity(intent)
    }
}