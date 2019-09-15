package com.example.umbrella.viewmodel

import android.content.Context

class ViewModelController {

    lateinit var mainActivityViewModel: MainActivityViewModel
    companion object {
        lateinit var currentWeatherViewModel: CurrentWeatherViewModel
        lateinit var forecastWeatherViewModel: ForecastWeatherViewModel

        fun isCurrentWeatherVMInitialized() = ::currentWeatherViewModel.isInitialized
        fun isForecastWeatherVMInitialized() = ::forecastWeatherViewModel.isInitialized
    }



    init {

        if (!isCurrentWeatherVMInitialized()) {
            currentWeatherViewModel = CurrentWeatherViewModel()
        }

        if (!isForecastWeatherVMInitialized()) {
            forecastWeatherViewModel = ForecastWeatherViewModel()
        }
    }

    fun getMainActivityModel(ctx : Context) : MainActivityViewModel {
        mainActivityViewModel  = MainActivityViewModel(ctx)
        return mainActivityViewModel
    }


}