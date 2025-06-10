package com.example.topacademy_android.weather.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.topacademy_android.databinding.WeatherActivityBinding
import com.example.topacademy_android.weather.presentation.adapters.ForecastAdapter
import com.example.topacademy_android.weather.presentation.viewmodels.WeatherViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherFragment : Fragment() {
    private var _binding: WeatherActivityBinding? = null


    private val binding get() = _binding!!
    private lateinit var adapter: ForecastAdapter
    private val viewModel: WeatherViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = WeatherActivityBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ForecastAdapter(emptyList())
        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.recyclerView.adapter = adapter
        viewModel.loadWeather(23.09, 113.17)

        viewModel.forecast.observe(viewLifecycleOwner) { forecast ->
            forecast?.let {
                adapter.updateList(it)
            }
        }
    }
}