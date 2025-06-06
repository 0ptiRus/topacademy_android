package com.example.topacademy_android.car.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.topacademy_android.car.data.remote.dto.Car
import com.example.topacademy_android.car.presentation.viewholders.CarViewHolder
import com.example.topacademy_android.databinding.ItemCarBinding

class CarAdapter(private var carList: List<Car>) : RecyclerView.Adapter<CarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val binding = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.bind(carList[position])
    }

    override fun getItemCount(): Int = carList.size
}