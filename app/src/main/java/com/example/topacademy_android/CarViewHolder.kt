package com.example.topacademy_android

import androidx.recyclerview.widget.RecyclerView
import com.example.topacademy_android.databinding.ItemCarBinding

class CarViewHolder(private val binding: ItemCarBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(car: Car)
    {
        binding.brandModelText.text = "${car.brand} ${car.model}"
        binding.descriptionText.text = car.description
        binding.yearText.text = "Год: ${car.year}"
        binding.costText.text = "Цена: ${car.cost} ₽"
    }
}