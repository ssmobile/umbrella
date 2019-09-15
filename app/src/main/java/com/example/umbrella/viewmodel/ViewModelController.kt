package com.example.umbrella.viewmodel

class ViewModelController {

    companion object {
        lateinit var mainActivityViewModel: MainActivityViewModel
        lateinit var currentWeatherViewModel: CurrentWeatherViewModel
        lateinit var forecastWeatherViewModel: ForecastWeatherViewModel

        fun isMainActivityVMIntiaized() = ::mainActivityViewModel.isInitialized
        fun isCurrentWeatherVMInitialized() = ::currentWeatherViewModel.isInitialized
        fun isForecastWeatherVMInitialized() = ::forecastWeatherViewModel.isInitialized
    }



    init {
        if (!isMainActivityVMIntiaized()) {
            mainActivityViewModel = MainActivityViewModel()
        }

        if (!isCurrentWeatherVMInitialized()) {
            currentWeatherViewModel = CurrentWeatherViewModel()
        }

        if (!isForecastWeatherVMInitialized()) {
            forecastWeatherViewModel = ForecastWeatherViewModel()
        }
    }


}