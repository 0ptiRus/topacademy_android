package com.example.topacademy_android.car.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.topacademy_android.car.data.remote.dto.Car
import com.example.topacademy_android.car.presentation.adapters.CarAdapter
import com.example.topacademy_android.databinding.CarActivityBinding

class CarFragment : Fragment() {
    private var _binding: CarActivityBinding? = null


    private val binding get() = _binding!!
    private lateinit var adapter: CarAdapter
    private lateinit var allCars: List<Car>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = CarActivityBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        allCars = listOf(
            Car("Toyota", "Corolla", 2020, "Reliable and fuel-efficient", 20000),
            Car("Honda", "Civic", 2019, "Sporty and comfortable", 18000),
            Car("Ford", "Mustang", 2021, "Powerful sports car", 35000),
            Car("Tesla", "Model S", 2022, "All-electric luxury sedan", 90000),
            Car("BMW", "X5", 2020, "Luxurious SUV", 60000)
        )
        adapter = CarAdapter(allCars)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }
}