package com.example.umbrella.viewmodel

class ViewModelController {

    companion object {
        lateinit var mainActivityViewModel: MainActivityViewModel
        lateinit var currentWeatherViewModel: CurrentWeatherViewModel

        fun isMainActivityVMIntiaized() = ::mainActivityViewModel.isInitialized
        fun isCurrentWeatherVMInitialized() = ::currentWeatherViewModel.isInitialized
    }



    init {
        if (!isMainActivityVMIntiaized()) {
            mainActivityViewModel = MainActivityViewModel()
        }

        if (!isCurrentWeatherVMInitialized()) {
            currentWeatherViewModel = CurrentWeatherViewModel()
        }
    }


}