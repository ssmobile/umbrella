package com.example.umbrella.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.umbrella.R
import com.example.umbrella.databinding.ForecastWeatherFragmentBinding
import com.example.umbrella.viewmodel.ViewModelController


class ForecastWeatherFragment : Fragment() {

    private lateinit var binder : ForecastWeatherFragmentBinding

    companion object {
        fun newInstance() = CurrentWeatherFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binder = DataBindingUtil.inflate(inflater, R.layout.forecast_weather_fragment,container, false)
        val view : View = binder.root
        binder.forecastWeatherViewModel = ViewModelController.forecastWeatherViewModel
        return view
    }
}

