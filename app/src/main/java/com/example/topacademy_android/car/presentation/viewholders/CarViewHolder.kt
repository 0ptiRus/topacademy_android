package com.example.topacademy_android.car.presentation.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.topacademy_android.R
import com.example.topacademy_android.car.data.remote.dto.Car
import com.example.topacademy_android.databinding.ItemCarBinding

class CarViewHolder(private val binding: ItemCarBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(car: Car)
    {
        val context = binding.root.context

        binding.brandModelText.text =
            context.getString(R.string.carBrandModelTemplate, car.brand, car.model)
        binding.descriptionText.text = car.description
        binding.yearText.text = context.getString(R.string.carYearTemplate, car.year.toString())
        binding.costText.text = context.getString(R.string.carCostTemplate, car.cost.toString())
    }
}