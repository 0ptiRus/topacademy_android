package com.example.topacademy_android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.topacademy_android.databinding.CarActivityBinding
import androidx.recyclerview.widget.LinearLayoutManager

class CarListActivity : AppCompatActivity() {

    private lateinit var binding: CarActivityBinding
    private lateinit var adapter: CarAdapter
    private lateinit var allCars: List<Car>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CarActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = "Cars"
            setDisplayHomeAsUpEnabled(true)
        }

        toolbar.setNavigationIcon(android.R.drawable.arrow_up_float)
        toolbar.navigationIcon?.setTint(ContextCompat.getColor(this, R.color.black))

        allCars = listOf(
            Car("Toyota", "Corolla", 2020, "Reliable and fuel-efficient", 20000),
            Car("Honda", "Civic", 2019, "Sporty and comfortable", 18000),
            Car("Ford", "Mustang", 2021, "Powerful sports car", 35000),
            Car("Tesla", "Model S", 2022, "All-electric luxury sedan", 90000),
            Car("BMW", "X5", 2020, "Luxurious SUV", 60000)
        )
        adapter = CarAdapter(allCars)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    fun applyFilter(filtered: List<Car>) {
        adapter.updateList(filtered)
    }
}