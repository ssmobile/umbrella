package com.example.umbrella.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.umbrella.R
import com.example.umbrella.databinding.CurrentWeatherFragmentBinding
import com.example.umbrella.viewmodel.CurrentWeatherViewModel
import com.example.umbrella.viewmodel.MainActivityViewModel
import com.example.umbrella.viewmodel.ViewModelController

class CurrentWeatherFragment : Fragment(){
    private lateinit var currentWeatherViewModel: CurrentWeatherViewModel
    private lateinit var binder : CurrentWeatherFragmentBinding

    companion object {
        fun newInstance() = CurrentWeatherFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binder = DataBindingUtil.inflate(inflater, R.layout.current_weather_fragment,container, false)
        val view : View = binder.root
        binder.currentWeatherViewModel = ViewModelController.currentWeatherViewModel
        return view
    }
}
